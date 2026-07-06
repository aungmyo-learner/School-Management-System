

public final class Teacher {
	
	private final String name;
	private final SubjectName subject;
	private final CurriculumGrade grade;
	public Teacher(String name, SubjectName subject, CurriculumGrade grade) {
		this.name = name;
		this.subject = subject;
		this.grade = grade;
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
	public String toString() {
		return "Name: " + name +
				"\nSubject: " + subject + 
				"\nGrade: " + grade;
	}
}
