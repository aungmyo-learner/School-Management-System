

public class OverallStudentPerformance {
	
	private final int examStudents;
	private final int passStudents;
	private final int failStudents;
	private final int averageMarks;
	private final int distinctionStudents;
	private final double passRate;
	public OverallStudentPerformance(int examStudents, int passStudents, int failStudents,
			int averageMarks, int distinctionStudents, double passRate) {
		this.examStudents = examStudents;
		this.passStudents = passStudents;
		this.failStudents = failStudents;
		this.averageMarks = averageMarks;
		this.distinctionStudents = distinctionStudents;
		this.passRate = passRate;
	}
	@Override
	public String toString() {
		return "OverallStudentPerformance \nExam Students: " + examStudents + "\n Pass Students: " + passStudents
				+ "\nFail Students: " + failStudents + "\nAverage Marks: " + averageMarks + "\nPass Rate: " + passRate;
	}
	public int getExamStudents() {
		return examStudents;
	}
	public int getPassStudents() {
		return passStudents;
	}
	public int getFailStudents() {
		return failStudents;
	}
	public int getAverageMarks() {
		return averageMarks;
	}
	public int getDistinctionStudents() {
		return distinctionStudents;
	}
	public double getPassRate() {
		return passRate;
	}
}
