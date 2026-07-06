

import java.util.Map;
import java.util.TreeMap;

public class SchoolExamService {
	private final SchoolExamRepository repository;
	public SchoolExamService(SchoolExamRepository repository) {
		this.repository = repository;
	}
	
	public void enrollExamRecord(ExamRecord exam) {
		Student student = exam.getStudent();
		ExamType type = exam.getType();
		Map<SubjectName, ExamSubject> subjects = new TreeMap<>(SchoolComparators.SUBJECTS);
		subjects.putAll(exam.getSubjects());
		repository.enrolRecord(student, type, subjects);
	}
	
	public void expelExamRecords(Student student) {
		repository.expelExamRecords(student);
	}
	
	public Map<CurriculumGrade, Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>>> getExamRecordsByGrade() {
		return repository.getExamRecordsByGrade();
		
	}
	
	public Map<CurriculumGrade, Map<Student, Map<SubjectName, ExamSubject>>> getExamTypeExamRecordsByGrade(ExamType type){
		return repository.getExamTypeExamRecordsByGrade(type);
	}
	
	public Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> getExamRecordsOfAGrade(CurriculumGrade grade) {
		return repository.getExamRecordsOfAGrade(grade);
	}
	
	public Map<Student, Map<SubjectName, ExamSubject>> getGradeExamTypeExamRecord(CurriculumGrade grade, ExamType type){
		return repository.getGradeExamTypeExamRecord(grade, type);
	}
	
	public Map<ExamType, Map<SubjectName, ExamSubject>> getStudentExamRecords(Student student) {
		return repository.getStudentExamRecords(student);
	}
	
	public Map<SubjectName, ExamSubject> getStudentExamRecord(Student student, ExamType type) {
		return repository.getExamRecord(student, type);
	}
	public void expelExamTypeExamRecord(Student student, ExamType type) {
		repository.expelExamTypeRecord(student, type);
	}
}
