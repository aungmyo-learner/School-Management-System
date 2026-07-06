

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SchoolGradeStudentPerformanceService {

	private final SchoolExamRepository repository;
	private final SchoolStudentPerformanceService service;
	
	public SchoolGradeStudentPerformanceService(SchoolExamRepository repository, SchoolStudentPerformanceService service) {
		this.repository = repository;
		this.service = service;
	}
	
	public Map<CurriculumGrade, GradeStudentsPerformance> getGradePerformancesByGrade() {
		return gradePerformancesByGrade();
	}
	
	private Map<CurriculumGrade, GradeStudentsPerformance> gradePerformancesByGrade() {

		if (repository.getExamRecordsByGrade().isEmpty()) {
			return Map.of();
		}
		
		Map<CurriculumGrade, GradeStudentsPerformance> gradesPerformances =
				new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var curriculumGrade : repository.getExamRecordsByGrade().entrySet()) {
			CurriculumGrade grade = curriculumGrade.getKey();
			Map<ExamType, ExamStudentsPerformanceResult> summaries = new TreeMap<>(buildGradeExamPerformance(grade));
			GradeStudentsPerformance gradePerformance = new GradeStudentsPerformance(grade, summaries);
			gradesPerformances.put(grade, gradePerformance);
		}
		return Collections.unmodifiableMap(gradesPerformances);
	}
	
	public ExamStudentsPerformanceResult getExamtypeGradePerformanceOfGrade(CurriculumGrade grade,
			ExamType type) {
		return buildGradeExamPerformance(grade).get(type);
	}
	
	public GradeStudentsPerformance getGradePerformanceOfGrade(CurriculumGrade grade) {
		return gradePerformance(grade);
	}

	public Map<CurriculumGrade, ExamStudentsPerformanceResult> getExamTypeGradePerformancesByGrade(ExamType type){
		return examTypeGradePerformancesByGrade(type);
	}
	

	private GradeStudentsPerformance gradePerformance(CurriculumGrade grade) {
		Map<ExamType, ExamStudentsPerformanceResult> summaries = new TreeMap<>(buildGradeExamPerformance(grade));
		GradeStudentsPerformance gradePerformance = new GradeStudentsPerformance(grade, summaries);
		
		return gradePerformance;
	}
	
	private Map<ExamType, ExamStudentsPerformanceResult> buildGradeExamPerformance(CurriculumGrade grade) {
		
		if (repository.getExamRecordsOfAGrade(grade).isEmpty()) {
			return Map.of();
		}
		
		Map<ExamType, ExamStudentAccumulator> accumulators = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		Map<ExamType, ExamStudentsPerformanceResult> summaries = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		
		for (var student : repository.getExamRecordsOfAGrade(grade).entrySet()) {
			Student s = student.getKey();
			
			for (var examType : student.getValue().entrySet()) {
				ExamType type = examType.getKey();
				ExamStudentAccumulator accumulator = accumulators
						.computeIfAbsent(type,
					        t -> new ExamStudentAccumulator()
					    );
				
				StudentPerformance performance = service.caculateStudentPerformance(s, examType.getValue());				
				
				if(performance.isPass()) {
					accumulator.incrementPassStudentsCount();
				}else {
					accumulator.incrementFailStudentsCount();
				}
				if(!performance.getDistinctions().isEmpty()) accumulator.incrementDistinctionStudentsCount();
				accumulator.addStudentTotalMarks(performance.getTotalMark());
				accumulator.incrementExamStudentsCount();
				accumulator.addStudentPerformance(performance);
			}
		}
		
		for (var examType : accumulators.entrySet()) {
			ExamType type = examType.getKey();
			summaries.put(type,  new ExamStudentsPerformanceResult(
					grade,
					examType.getValue().getStudentPerformances(),
					examType.getValue().getAverageMark(),
					examType.getValue().getPassStudentsCount(),
					examType.getValue().getFailStudentsCount(),
					examType.getValue().getExamStudentsCount(),
					examType.getValue().getDistinctionStudentsCount(), 
					examType.getValue().getPassRate()));
		}
		return Collections.unmodifiableMap(summaries);
	}

	private Map<CurriculumGrade, ExamStudentsPerformanceResult> examTypeGradePerformancesByGrade(ExamType type){
		Map<CurriculumGrade, ExamStudentsPerformanceResult> byGrade = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		if (repository.getExamRecordsByGrade().isEmpty()) {
			return Map.of();
		}
		
		for (var grade : repository.getExamRecordsByGrade().entrySet()) {
			if (buildGradeExamPerformance(grade.getKey()).containsKey(type)) {
				byGrade.put(grade.getKey(), buildGradeExamPerformance(grade.getKey()).get(type));
			}
		}
		return Collections.unmodifiableMap(byGrade);
	}
}
