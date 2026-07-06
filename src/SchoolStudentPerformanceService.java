

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SchoolStudentPerformanceService {
	private final SchoolExamRepository repository;
	
	public SchoolStudentPerformanceService(SchoolExamRepository repository) {
		this.repository = repository;
	}
	
	public Map<CurriculumGrade, Map<ExamType, Set<StudentPerformance>>> getStudentPerformances(){
		return studentPerformances();
	}

	private Map<CurriculumGrade, Map<ExamType, Set<StudentPerformance>>> studentPerformances(){
		
		Map<CurriculumGrade, Map<ExamType, Set<StudentPerformance>>> performances = 
				new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var grade : repository.getExamRecordsByGrade().entrySet()) {
			
			Map<ExamType, Set<StudentPerformance>> p = 
					performances.computeIfAbsent(grade.getKey(), g -> new TreeMap<>(SchoolComparators.EXAM_TYPE));
		
			for (var student : grade.getValue().entrySet()) {
			
				Map<ExamType, StudentPerformance> performance = eachStudentPerformances(student.getKey());
				
				for (var type : performance.entrySet()) {
				
					p.computeIfAbsent(type.getKey(),
							t-> new TreeSet<>(SchoolComparators.STUDENT_PERFORMANCE)).add(type.getValue());
				}
			}
		}
		return Collections.unmodifiableMap(performances);
	}
	
	private Map<ExamType, StudentPerformance> eachStudentPerformances(Student student) {
		
		Map<ExamType, StudentPerformance> summaries = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		for (var typeEntry : repository.getStudentExamRecords(student).entrySet()) {
			ExamType type = typeEntry.getKey();
			StudentPerformance performance = caculateStudentPerformance(student, typeEntry.getValue());
			summaries.put(type, performance);
		}
		return Collections.unmodifiableMap(summaries);
	}
	
	public Map<ExamType, Set<StudentPerformance>> getGradeStudentPerformances(CurriculumGrade grade) {
		return gradeStudentPerformances(grade);
	}
	
	private Map<ExamType, Set<StudentPerformance>> gradeStudentPerformances(CurriculumGrade grade) {
		return studentPerformances().getOrDefault(grade, Map.of());
	}
	
	public Map<ExamType, StudentPerformance> getEachStudentPerformances(Student student) {
		return eachStudentPerformances(student);
	}
	
	public Map<CurriculumGrade, Set<StudentPerformance>> getExamTypeStudentPerformance(ExamType type) {
		return examTypeStudentPerformance(type);
	}
	
	private Map<CurriculumGrade, Set<StudentPerformance>> examTypeStudentPerformance(ExamType type) {
		
		Map<CurriculumGrade, Set<StudentPerformance>> performances = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var grade : repository.getExamRecordsByGrade().entrySet()) {
		
			for (var student : grade.getValue().entrySet()) {
			
				Map<ExamType, StudentPerformance> performancesByExam =
			            eachStudentPerformances(student.getKey());
				
				if (performancesByExam.containsKey(type)) {
				
					performances.computeIfAbsent(grade.getKey(), 
					g -> new TreeSet<>(SchoolComparators.STUDENT_PERFORMANCE))
					.add(performancesByExam.get(type));
				}
			}
		}
		
		return Collections.unmodifiableMap(performances);
	}
	
	public Set<StudentPerformance> getExamTypeStudentPerformancesOfGrade(CurriculumGrade grade,ExamType type) {
		return examTypeStudentPerformancesOfGrade(grade, type);
	}
	
	private Set<StudentPerformance> examTypeStudentPerformancesOfGrade( CurriculumGrade grade, ExamType type) {

	    Set<StudentPerformance> performances =
	            new TreeSet<>(SchoolComparators.STUDENT_PERFORMANCE);

	    for (var studentEntry :
	            repository.getExamRecordsOfAGrade(grade).entrySet()) {

	        Student student = studentEntry.getKey();

	        if (studentEntry.getValue().containsKey(type)) {

	            StudentPerformance performance =
	                    caculateStudentPerformance(
	                            student,
	                            studentEntry.getValue().get(type));

	            performances.add(performance);
	        }
	    }

	    return Collections.unmodifiableSet(performances);
	}
		
	public StudentPerformance getEachStudentPerformance(Student student, ExamType type) {
		return caculateStudentPerformance(student, repository.getExamRecord(student, type));
	}
	
	public StudentPerformance caculateStudentPerformance(Student student, Map<SubjectName, ExamSubject> examSubjects) {
		return calculate(student, examSubjects);
	}
	
	private StudentPerformance calculate(Student student, Map<SubjectName, ExamSubject> examSubjects) {
		Set<SubjectName> subjects = examSubjects.keySet();
		Set<SubjectName> distinction = new TreeSet<>(SchoolComparators.SUBJECTS);
		int totalMark =0, count =0, averageMark =0, passSubjectCount =0;
		Level level = null;
		for (SubjectName subjectName : subjects) {
			boolean isAcademic = examSubjects.get(subjectName).getName().getType() == SubjectType.ACADEMIC;
			totalMark += examSubjects.get(subjectName).getMark();
			if (examSubjects.get(subjectName).isPass() && isAcademic) {
				passSubjectCount++;
				if(examSubjects.get(subjectName).determineDistinction(student.getGrade())) {
					distinction.add(subjectName);
				}
			}
			count++;
		}
		boolean isPass = passSubjectCount == subjects.size();
		
		Set<SubjectName> distinctionSubjects = new TreeSet<>(distinction);
		
		if(count != 0) {
			averageMark = totalMark/count;
			level = Level.determineLevel(averageMark);
		}
		StudentPerformance performance = new StudentPerformance(student.getName(), student.getGrade(), totalMark,
				averageMark, isPass, distinctionSubjects, level);
		return performance;
		
	}
}
