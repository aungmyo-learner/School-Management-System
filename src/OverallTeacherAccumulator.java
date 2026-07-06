

public class OverallTeacherAccumulator {
	private int teacherCount;
	private int totalAverageMark;
	private double totalPassRate;
	private int teachersDistinctionTotal;
	public void incrementOverallTeacher() {
		teacherCount++;
	}
	public void addAverageMark(int averageMark) {
		totalAverageMark += averageMark;
	}
	public void addPassRate(double passRate) {
		totalPassRate += passRate;
	}
	public void addDistinctionCount(int distinctionCount) {
		this.teachersDistinctionTotal += distinctionCount;
	}
	public int getAverageTeacherAverageMark() {
		return teacherCount ==0? 0:totalAverageMark/teacherCount;
	}
	public double getAverageTeacherPassRate() {
		return teacherCount ==0? 0: (totalPassRate/(double) teacherCount) * 100;
	}
	public int getOverallTeacher() {
		return teacherCount;
	}
	public int getTeachersDistinctionTotal() {
		return teachersDistinctionTotal;
	}
	
}
