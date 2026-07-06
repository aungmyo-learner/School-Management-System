

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public final class ExamStudentsPerformanceResult {
	
	private final CurriculumGrade grade;
	private final Set<StudentPerformance> performances;
	private final int averageMark;
    private final int examStudentsCount;
    private final int passStudentsCount;
    private final int failStudentsCount;
    private final int distinctionStudentsCount;
    private final double passRate;
	
	public ExamStudentsPerformanceResult(CurriculumGrade grade, Set<StudentPerformance> performances, int averageMark,
			int examStudentsCount,int passStudentsCount, int failStudentsCount,
			int distinctionStudentsCount, double passRate) {
		this.grade = grade;
		Set<StudentPerformance> copy =new TreeSet<>(SchoolComparators.STUDENT_PERFORMANCE);
		copy.addAll(performances);
		this.performances = Collections.unmodifiableSet(copy);
		this.averageMark = averageMark;
		this.examStudentsCount = examStudentsCount;
		this.passStudentsCount = passStudentsCount;
		this.failStudentsCount = failStudentsCount;
		this.distinctionStudentsCount = distinctionStudentsCount;
		this.passRate = passRate;
	}

	public CurriculumGrade getGrade() {
		return grade;
	}

	public Set<StudentPerformance> getPerformances() {
		return performances;
	}
	
	public int getAverageMark() {
		return averageMark;
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
	
	public double getPassRate() {
		return passRate;
	}
	
	public int getDistinctionStudentsCount() {
		return distinctionStudentsCount;
	}
	
	public String toString() {
		
		if (grade == null) {
			return "haven't this grade's exam student performance result";
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Grade: ").append(grade).
		append("\nAverage Mark: ").append(averageMark)
		.append("\nExam Student Count: ").append(examStudentsCount)
		.append("\nPass Student Count: ").append(passStudentsCount)
		.append("\nFail Student Count: ").append(failStudentsCount)
		.append("\nPass Rate: ").append(passRate)
		.append("\nPerformances..\n");
		
		performances.forEach(p->
		sb.append(p)
		.append("\n"));
		
		return sb.toString();
	}
}
