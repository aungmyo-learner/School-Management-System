

public class TeacherInfo {
	private final String  name;
	private final SubjectName subject;
	private final CurriculumGrade grade;
	public TeacherInfo(String name, SubjectName subject, CurriculumGrade grade) { 
		this.grade = grade;
		this.name = name;
		this.subject = subject;
	}
	public CurriculumGrade getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public SubjectName getSubject() {
		return subject;
	}
}
