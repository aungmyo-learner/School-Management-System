

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TeacherExamDetail {
	private final double passRate;
	private final TeacherPerformance bestPerformance;
	private final Set<TeacherPerformance> performances;
	public TeacherExamDetail(double passRate, Set<TeacherPerformance> performances) {
		this.passRate = passRate;
		Set<TeacherPerformance> copy = new TreeSet<>(SchoolComparators.TEACHER_PERFORMANCE);
		copy.addAll(performances);
		this.performances = Collections.unmodifiableSet(copy);
		this.bestPerformance = performances.stream().max(SchoolComparators.TEACHER_PERFORMANCE).orElse(null);
	}
	
	public double getPassRate() {
		return passRate;
	}
	
	public TeacherPerformance getBestPerformance() {
		return bestPerformance;
	}
	
	public Set<TeacherPerformance> getPerformances() {
		return performances;
	}
	
	public int getTeacherCount() {
		return performances.size();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Teacher Performances..\n");
		performances.forEach(p->	sb.append(p));
		sb.append("\nBest Teacher Performace: ").append(bestPerformance)
		.append("\nPass Rate: ").append(passRate);
		
		return sb.toString();
	}
}
