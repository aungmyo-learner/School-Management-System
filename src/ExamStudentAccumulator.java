

import java.util.Set;
import java.util.TreeSet;

public class ExamStudentAccumulator {
	private int totalStudentMarks;
	private int examStudentsCount;
	private int passStudentsCount;
	private int failStudentsCount;
	private Set<StudentPerformance> performances;
	private int distinctionStudentsCount;
	
	public ExamStudentAccumulator() {
		performances = new TreeSet<>(SchoolComparators.STUDENT_PERFORMANCE);
	}
	public void addStudentTotalMarks(int totalMarks) {
		totalStudentMarks += totalMarks;
	}
	public void incrementExamStudentsCount() {
		examStudentsCount++;
	}
	public void incrementPassStudentsCount() {
		passStudentsCount++;
	}
	public void incrementFailStudentsCount() {
		failStudentsCount++;
	}
	public void incrementDistinctionStudentsCount() {
		distinctionStudentsCount++;
	}
	public void addStudentPerformance(StudentPerformance performance) {
		performances.add(performance);
	}
	
	public int getAverageMark() {
		return examStudentsCount == 0 ? 0:totalStudentMarks / examStudentsCount;
	}
	public int getExamStudentsCount() {
		return examStudentsCount;
	}
	public int getPassStudentsCount() {
		return passStudentsCount;
	}
	public int getFailStudentsCount() {
		return failStudentsCount;
	}
	public int getDistinctionStudentsCount() {
		return distinctionStudentsCount;
	}
	public double getPassRate() {
		return examStudentsCount ==0 ? 0 : ((double)passStudentsCount/examStudentsCount) * 100;
	}
	public Set<StudentPerformance> getStudentPerformances() {
		return Set.copyOf(performances);
	}
}
