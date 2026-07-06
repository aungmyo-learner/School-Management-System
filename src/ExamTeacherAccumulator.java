

public class ExamTeacherAccumulator {
	private int examStudentsCount;
	private int passStudentsCount;
	private int failStudentsCount;
	private int totalMark;
	private int distinctionStudentsCount;
	
	public void incrementExamStudentsCount() {
		examStudentsCount++;
	}
	public void accumulate(ExamSubject subject, CurriculumGrade grade) {
		if(subject.isPass()) {
			passStudentsCount++;
		}else {
			failStudentsCount++;
		}
		if(subject.determineDistinction(grade)) distinctionStudentsCount++;
	}
	
	public void addTotalMark(int mark) {
		this.totalMark += mark;
	}
	
	public int getAverageMark() {
		return examStudentsCount == 0? 0:totalMark/examStudentsCount;
	}
	
	public double getPassRate() {
		return examStudentsCount ==0? 0: ((double)passStudentsCount / examStudentsCount) * 100;
	}
	
	public int getFailStudentsCount() {
		return failStudentsCount;
	}
	
	public int getExamStudentsCount() {
		return examStudentsCount;
	}
	
	public int getPassStudentsCount() {
		return passStudentsCount;
	}
	
	public int getTotalMark() {
		return totalMark;
	}
	
	public int getDistinctionStudentsCount() {
		return distinctionStudentsCount;
	}
}
