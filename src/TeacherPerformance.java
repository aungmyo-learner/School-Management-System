

public final class TeacherPerformance {
	private final String name;
	private final SubjectName subject;
	private final CurriculumGrade grade;
	private final int examStudentsCount;
	private final int passCount;
	private final int failCount;
	private final int totalMark;
	private final int averageMark;
	private final int distinctionCount;
	private final double passRate;
	private final Level level;
	
	public TeacherPerformance(String name, SubjectName subject, CurriculumGrade grade, int examStudentsCount, int passCount, int failCount,
			int totalMark, int averageMark, int distinctionCount, double passRate, Level level) {
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.examStudentsCount = examStudentsCount;
		this.passCount = passCount;
		this.failCount = failCount;
		this.totalMark = totalMark;
		this.averageMark = averageMark;
		this.distinctionCount = distinctionCount;
		this.passRate = passRate;
		this.level = level;
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
	public int getExamStudentsCount() {
		return examStudentsCount;
	}
	public int getPassCount() {
		return passCount;
	}
	public int getFailCount() {
		return failCount;
	}
	public int getTotalMark() {
		return totalMark;
	}
	public int getAverageMark() {
		return averageMark;
	}
	public int getDistinctionCount() {
		return distinctionCount;
	}
	public double getPassRate() {
		return passRate;
	}
	public Level getLevel() {
		return level;
	}
	public String toString() {
		return name +
				"\n" + subject +
				"\n" + grade +
				"\n" + examStudentsCount +
				"\n" + passCount +
				"\n" + failCount +
				"\n" + totalMark +
				"\n" + averageMark +
				"\n" + distinctionCount +
				"\n" + passRate +
				"\n" + level;
	}
}
