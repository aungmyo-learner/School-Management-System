

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public final class StudentPerformance {
	private final String  name;
	private final CurriculumGrade grade;
	private final int totalMark;
	private final int averageMark;
	private final boolean isPass;
	private final Set<SubjectName>  distinctions;
	private final Level level;
	
	public StudentPerformance(String  name, CurriculumGrade grade, int totalMark, int averageMark, boolean isPass, Set<SubjectName> distinctions, Level level) {
		this.name = name;
		this.grade = grade;
		this.totalMark = totalMark;
		this.averageMark = averageMark;
		this.isPass = isPass;
		Set<SubjectName> copy = new TreeSet<>(SchoolComparators.SUBJECTS);
		
		if(!distinctions.isEmpty()) {
			copy.addAll(distinctions);
		}
		this.distinctions = Collections.unmodifiableSet(copy);
		this.level = level;
	}
	
	public String getName() {
		return name;
	}

	public CurriculumGrade getGrade() {
		return grade;
	}
	
	public int getTotalMark() {
		return totalMark;
	}

	public int getAverageMark() {
		return averageMark;
	}
	
	public boolean isPass() {
		return isPass;
	}
	public Set<SubjectName> getDistinctions() {
		return distinctions;
	}
	public int getDistinctionCount() {
		return distinctions.size();
	}
	public Level getLevel() {
		return level;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (!isPass) {
			sb.append("Name: ").append(name)
			.append("\nGrade: ").append(grade)
			.append("\nTotal Mark: ").append(totalMark)
			.append("\nFail Exam\n")
			.append("\nDistinction Subjects\n");
		}else {
			sb.append("Name: ").append(name)
			.append("\nGrade: ").append(grade)
			.append("\nTotal Mark: ").append(totalMark)
			.append("\nPass Exam\n")
			.append("\nDistinction Subjects\n");
		}
		if(!distinctions.isEmpty()) {
			distinctions.forEach(subject->
			sb.append(subject)
			.append("\n"));
		}
		return sb.toString();
	}
}
