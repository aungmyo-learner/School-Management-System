

public class OverallTeacherPerformance {
	private final int overallTeachers;
	private final int averageTeacherAverageMark;
	private final double averageTeacherPassRate;
	private final int teachersDistinctionTotal;
	public OverallTeacherPerformance(int overallTeachers, int averageTeacherAverageMark,
			double averageTeacherPassRate, int teachersDistinctionTotal) {
		
		this.overallTeachers = overallTeachers;
		this.averageTeacherAverageMark = averageTeacherAverageMark;
		this.averageTeacherPassRate = averageTeacherPassRate;
		this.teachersDistinctionTotal = teachersDistinctionTotal;
	}
	
	public int getOverallTeachers() {
		return overallTeachers;
	}
	
	public int getAverageTeacherAverageMark() {
		return averageTeacherAverageMark;
	}
	
	public double getAverageTeacherPassRate() {
		return averageTeacherPassRate;
	}
	
	@Override
	public String toString() {
		return "OverallTeacherPerformance \nOverallTeachers: " + overallTeachers +
				"\nAverageTeacherAverageMark: " + averageTeacherAverageMark +
				"\nAverageTeacherPassRate=" + averageTeacherPassRate +
				"\nTeachersDistinctionTotal: " + teachersDistinctionTotal;
	}

	public int getTeachersDistinctionTotal() {
		return teachersDistinctionTotal;
	}
}
