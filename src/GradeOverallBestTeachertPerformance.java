

public final class GradeOverallBestTeachertPerformance {
	private final String name;
	private final SubjectName subject;
	private final CurriculumGrade grade;
	private final int overallPassCount;
	private final int overallAverageMark;
	private final int overallDistinctionCount;
	private final double overallPassRate;
	private final double score;
	public GradeOverallBestTeachertPerformance(String name, SubjectName subject, CurriculumGrade grade, int overallPassCount,
			int overallAverageMark, int overallDistinctionCount, double overallPassRate, double score) {
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.overallPassCount = overallPassCount;
		this.overallAverageMark = overallAverageMark;
		this.overallDistinctionCount = overallDistinctionCount;
		this.overallPassRate = overallPassRate;
		this.score = score;
	}
	public int getOverallAverageMark() {
		return overallAverageMark;
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
	public int getOverallPassCount() {
		return overallPassCount;
	}
	public int getOverallDistinctionCount() {
		return overallDistinctionCount;
	}
	public double getOverallPassRate() {
		return overallPassRate;
	}
	public double getScore() {
		return score;
	}
	
	public String toString() {
		
		if (name.equals("No Teacher")) {
			return "Haven't grade overall best teacher performance";
		}
		
		return "Name: " + name +
				"\nSubject: " + subject +
				"\nOverall Pass Count: " + overallPassCount +
				"\nOverall Distinction Count: " + overallDistinctionCount +
				"\nOverall Pass Rate: " + overallPassRate +
				"Score: " + score;
	}
}
