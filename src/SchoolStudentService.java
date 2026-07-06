

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SchoolStudentService {
	private final SchoolStudentRepository repository;
	private final SchoolCurriculum curriculum;
	
	public SchoolStudentService(SchoolStudentRepository repository, SchoolCurriculum curriculum) {
		this.repository = repository;
		this.curriculum = curriculum;
	}
	private Status state(CurriculumGrade grade, String name, String parent) {
		Status status = null;
		Student student = repository.findStudent(grade, name, parent);
		if (student == null) {
			status = Status.NOT_EXST;
			
		}else {
			status = Status.EXIST;
		}
		return status;
	}
	
	public Status previewStudent (CurriculumGrade grade, String name, String parent) {
		return state(grade, name, parent);
	}
	
	public ExamRecord enrollStudent(StudentInfo info) {
		Set<SubjectName> learnSubjects = new TreeSet<>(SchoolComparators.SUBJECTS);
		learnSubjects.addAll(curriculum.getSubjectsByGrade(info.getGrade()));
		Student student = new Student(info.getName(), info.getParent(), info.getGrade(), learnSubjects);
		student.assignSubjects(learnSubjects);
		repository.enrollStudent(student.getGrade(), student);
		
		Set<SubjectName> subjects = getExamSubjectName(info.getGrade());
		Map<SubjectName, ExamSubject> examSubjects = new TreeMap<>(SchoolComparators.SUBJECTS);
		for (SubjectName subjectName : subjects) {
			ExamSubject subject = new ExamSubject(subjectName, 0);
			examSubjects.put(subjectName, subject);
		}
		ExamRecord record = new ExamRecord(student, info.getExamtype(), examSubjects);
		return record;
	}
	public Set<SubjectName> getExamSubjectName(CurriculumGrade grade){
		return curriculum.getExamSubjectByGrade(grade);
	}
	public void expelStudent(Student student) {
		repository.expelStudent(student.getGrade(), student.getName(), student.getParent());
	}
	
	public Map<CurriculumGrade, Set<Student>> getStudents() {
		return repository.getStudents();
	}
	
	public Set<Student> getStudentsOfAGrade(CurriculumGrade grade) {
		return repository.getStudentsFromAGrade(grade);
	}
	
	public Student getStudent(CurriculumGrade grade, String name, String parent){
		return repository.findStudent(grade, name, parent);
	}
}
