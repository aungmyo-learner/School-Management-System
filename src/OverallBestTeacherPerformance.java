

public class OverallBestTeacherPerformance {
	private final String name;
	private final SubjectName subject;
	private final CurriculumGrade grade;
	private final double score;
	public OverallBestTeacherPerformance(String name, SubjectName subject,  CurriculumGrade grade, double score) {
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public SubjectName getSubject() {
		return subject;
	}
	
	public CurriculumGrade getGrade() {
		return grade;
	}

	public double getScore() {
		return score;
	}
	
	public String toString() {
		if (name.equals("No Teacher")) {
			return "haven't overall best Teacher performance";
		}
		return "Name: " + name +
				"\nSubject: " + subject +
				"\nGrade: " + grade +
				"\nScore: " + score;
	}
}
