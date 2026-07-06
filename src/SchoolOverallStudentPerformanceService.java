

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.ToIntFunction;

public class SchoolOverallStudentPerformanceService {
	private final  SchoolGradeStudentPerformanceService studentPerformance;

	public SchoolOverallStudentPerformanceService(SchoolGradeStudentPerformanceService studentPerformance) {
		this.studentPerformance = studentPerformance;
	}
	
	private int averageOf(Map<ExamType, OverallStudentPerformance> summaries
			, ToIntFunction<OverallStudentPerformance> mapper) {
		
		int count = summaries.size();
		
		int total = summaries.values()
				.stream()
				.mapToInt(mapper)
				.sum();
		
		return count == 0? 0: total/count;
	}
	public OverallStudentPerformanceSummary getSchoolOverallStudentPerformanceSummary() {
		return schoolOverallStudentPerformanceSummary();
	}
	
	private OverallBestStudentPerformance getOverallBestStudentPerformance() {

		Map<CurriculumGrade, GradeStudentsPerformance> gradesPerformances =
				studentPerformance.getGradePerformancesByGrade();
		
		var best = gradesPerformances.values()
				.stream()
				.map(GradeStudentsPerformance:: getGradeBestStudentPerformance)
				.max(SchoolComparators.GRADE_OVERALL_STUDENT_BEST_PERFORMANCE).orElse(null);
		
		if (best == null) {
			return new OverallBestStudentPerformance("No Student", null, 0);
		}
		return new OverallBestStudentPerformance(best.getName(), best.getGrade(), best.getScore());
	}
	
	private OverallStudentPerformanceSummary schoolOverallStudentPerformanceSummary() {
		
		Map<ExamType, OverallStudentPerformance> summaries = buildOverallStudentPerformance();
		
		int examStudents = averageOf(summaries, OverallStudentPerformance::getExamStudents);
		int distinctionStudents = averageOf(summaries, OverallStudentPerformance::getDistinctionStudents);
		int passStudents = averageOf(summaries, OverallStudentPerformance::getPassStudents);
		int failStudents = averageOf(summaries, OverallStudentPerformance::getFailStudents);
		int averageMark = averageOf(summaries, OverallStudentPerformance::getAverageMarks);
		
		double passRate = examStudents ==0? 0: ((double) passStudents/examStudents) *100;
		
		OverallBestStudentPerformance performance = getOverallBestStudentPerformance();
		
		OverallStudentPerformanceSummary summary =
				new OverallStudentPerformanceSummary(examStudents, passStudents, failStudents,
						averageMark, distinctionStudents, passRate, performance);
		return summary;
	}
	
	public OverallStudentPerformance getExamTypeOverallStudentPerformance(ExamType type) {
		return buildOverallStudentPerformance().get(type);
	}
	
	private Map<ExamType, OverallStudentPerformance> buildOverallStudentPerformance() {
		
		Map<ExamType, OverallStudentPerformance> summaries = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		Map<ExamType, OverallStudentAccumulator> accumulators = buildOverallStudentAccumulator();
		for (var typeEntry : accumulators.entrySet()) {
			ExamType type = typeEntry.getKey();
			
			summaries.put(type, new OverallStudentPerformance(
					typeEntry.getValue().getOverallExamStudents(),
					typeEntry.getValue().getOverallDistinctionStudents(),
					typeEntry.getValue().getOverallPassStudents(),
					typeEntry.getValue().getOverallFailStudents(),
					typeEntry.getValue().getOverallAverageMark(),
					typeEntry.getValue().getOverallPassRate()));
		}
		return Collections.unmodifiableMap(summaries);
	}
	
	private Map<ExamType, OverallStudentAccumulator> buildOverallStudentAccumulator(){
		Map<ExamType, OverallStudentAccumulator> accumulators = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		
		Map<CurriculumGrade, GradeStudentsPerformance> gradesPerformances =
				studentPerformance.getGradePerformancesByGrade();
		
		for (var gradeEntry : gradesPerformances.entrySet()) {
			
			Map<ExamType, ExamStudentsPerformanceResult> studentSummaries = gradeEntry.getValue().getResult();
						
			for (var typeEntry : studentSummaries.entrySet()) {
				ExamType type = typeEntry.getKey();
				OverallStudentAccumulator accumulator = accumulators.computeIfAbsent(type,
						t -> new OverallStudentAccumulator());
				accumulator.addTotalExamStudents(typeEntry.getValue().getExamStudentsCount());
				accumulator.addDistinctionStudents(typeEntry.getValue().getDistinctionStudentsCount());
				accumulator.addPassStudents(typeEntry.getValue().getPassStudentsCount());
				accumulator.addFailStudents(typeEntry.getValue().getFailStudentsCount());
				
				Set<StudentPerformance> performances = typeEntry.getValue().getPerformances();
				for (StudentPerformance performance : performances) {
					accumulator.addTotalMark(performance.getTotalMark());
				}
			}
		}
		return accumulators;
	}
}
