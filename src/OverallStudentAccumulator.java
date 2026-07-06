

public class OverallStudentAccumulator {
	private int overallExamStudents;
	private int overallPassStudents;
	private int overallFailStudents;
	private int overallTotalMark;
	private int overallDistinctionStudents;
	
	public OverallStudentAccumulator() {
		
	}
	
	public void addTotalExamStudents(int examStudents) {
		this.overallExamStudents += examStudents;
	}
	public void addPassStudents(int passStudents) {
		this.overallPassStudents += passStudents;
	}
	public void addFailStudents(int failStudents) {
		this.overallFailStudents += failStudents;
	}
	public void addTotalMark(int totalMark) {
		this.overallTotalMark += totalMark;
	}
	public void addDistinctionStudents(int distinctionStudents) {
		this.overallDistinctionStudents += distinctionStudents;
	}
	
	public int getOverallExamStudents() {
		return overallExamStudents;
	}
	public int getOverallPassStudents() {
		return overallPassStudents;
	}
	public int getOverallFailStudents() {
		return overallFailStudents;
	}
	public int getOverallAverageMark() {
		return overallExamStudents == 0? 0:overallTotalMark/overallExamStudents;
	}
	public double getOverallPassRate() {
		return overallExamStudents == 0? 0:((double)overallPassStudents/overallExamStudents)*100;
	}
	public int getOverallDistinctionStudents() {
		return overallDistinctionStudents;
	}
}
