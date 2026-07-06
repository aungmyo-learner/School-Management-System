

public class OverallBestStudentPerformance {
	private final String name;
	private final CurriculumGrade grade;
	private final double score;
	public OverallBestStudentPerformance(String name, CurriculumGrade grade, double score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public CurriculumGrade getGrade() {
		return grade;
	}

	public double getScore() {
		return score;
	}

	@Override
	public String toString() {
		if (name.equals("No Student")) {
			return "haven't overall best student peformance";
		}
		return "OverallBestStudentPerformance \nName: " + name + "\nGrade: " + grade + "\nScore: " + score;
	}
}
