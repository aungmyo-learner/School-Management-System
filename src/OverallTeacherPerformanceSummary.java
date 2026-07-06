

public final class OverallTeacherPerformanceSummary {
	private final int averageTeacher;
	private final int averageTeacherAverageMark;
	private final double averageTeacherPassRate;
	private final int averageDistinctions;
	private final OverallBestTeacherPerformance best;
	public OverallTeacherPerformanceSummary(int averageTeacher, int averageTeacherAverageMark,
			double averageTeacherPassRate, int averageDistinctions, OverallBestTeacherPerformance best) {
		this.averageTeacher = averageTeacher;
		this.averageTeacherAverageMark = averageTeacherAverageMark;
		this.averageTeacherPassRate = averageTeacherPassRate;
		this.averageDistinctions = averageDistinctions;
		this.best = best;
	}
	
	@Override
	public String toString() {
		return "OverallTeacherPerformanceSummary \naverageTeacher: " + averageTeacher +
				"\naverageTeacherAverageMark: " + averageTeacherAverageMark +
				"\naverageTeacherPassRate=" + averageTeacherPassRate
				+ "\naverageDistinctions: " + averageDistinctions +
				"\nBest Teacher Performance\n" + best;
	}

	public int getOverallTeachers() {
		return averageTeacher;
	}
	
	public int getAverageTeacherAverageMark() {
		return averageTeacherAverageMark;
	}
	
	public double getAverageTeacherPassRate() {
		return averageTeacherPassRate;
	}
	
	public int getAverageDistinctionTotal() {
		return averageDistinctions;
	}
	
	public OverallBestTeacherPerformance getBest() {
		return best;
	}
	
}
