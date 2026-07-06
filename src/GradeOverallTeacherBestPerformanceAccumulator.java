

public class GradeOverallTeacherBestPerformanceAccumulator {
	private final SubjectName subject;
	private int overallStudentPassCount;
	private int overallExamStudentCount;
	private int overallTotalMarks;
	private int overallDistinctionCount;
	
	public GradeOverallTeacherBestPerformanceAccumulator(SubjectName subject) {
		this.subject = subject;
	}
	
	public int getOverallStudentPassCount() {
		return overallStudentPassCount;
	}

	public SubjectName getSubject() {
		return subject;
	}

	public int getOverallAverageMark() {
		return overallExamStudentCount ==0? 0: overallTotalMarks/overallExamStudentCount;
	}

	public int getOverallDistinctionCount() {
		return overallDistinctionCount;
	}

	public void addStudentPassCount(int count) {
		overallStudentPassCount += count;
	}
	
	public void addExamStudentCount(int count) {
		overallExamStudentCount += count;
	}
	
	public void addTotalMarks(int averageMark) {
		overallTotalMarks += averageMark;
	}
	
	public void addDistinctionCount(int count) {
		overallDistinctionCount += count;
	}
	public double getOverallPassRate() {
		return overallExamStudentCount ==0? 0: ((double)overallStudentPassCount / overallExamStudentCount) * 100;
	}
	
	public double getScore() {
		return (getOverallPassRate() * 0.4) +
				((double) overallDistinctionCount * 0.20) + 
				((double) getOverallAverageMark() * 0.4);
	}
	
	public boolean isScore(double score) {
		return score == getScore();
	}
}
