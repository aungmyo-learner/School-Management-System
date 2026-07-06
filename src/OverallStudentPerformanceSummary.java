

public final class OverallStudentPerformanceSummary {
	private final int totalExamStudents;
	private final int passStudents;
	private final int failStudents;
	private final int averageMark;
	private final int distinctionStudents;
	private final double passRate;
	private final OverallBestStudentPerformance performance;
	public OverallStudentPerformanceSummary(int totalExamStudents, int passStudents, int failStudents, int averageMark,
			int distinctionStudents, double passRate,OverallBestStudentPerformance performance) {
		this.totalExamStudents = totalExamStudents;
		this.passStudents = passStudents;
		this.failStudents = failStudents;
		this.averageMark = averageMark;
		this.distinctionStudents = distinctionStudents;
		this.passRate = passRate;
		this.performance = performance;
	}
	public OverallBestStudentPerformance getPerformance() {
		return performance;
	}
	public int getTotalExamStudents() {
		return totalExamStudents;
	}
	public int getPassStudents() {
		return passStudents;
	}
	public int getFailStudents() {
		return failStudents;
	}
	public int getAverageMark() {
		return averageMark;
	}
	public int getDistinctionStudents() {
		return distinctionStudents;
	}
	public double getPassRate() {
		return passRate;
	}
	@Override
	public String toString() {
		return "OverallStudentPerformanceSummary \nTotal Exam Students: " + totalExamStudents +
				"\npassStudents: "+ passStudents +
				"\nfailStudents=" + failStudents +
				"\naverageMark=" + averageMark +
				"\ndistinctionStudents=" + distinctionStudents +
				"\npassRate: " + passRate +
				"Overall best student performance\n" + performance;
	}
	
}
