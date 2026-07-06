

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class GradeOverallBestStudentPerformance {
	private final String name;
	private final CurriculumGrade grade;
	private final int overallAverageMark;
	private final Map<ExamType, Set<SubjectName>> distinctionSubjects;
	
	public GradeOverallBestStudentPerformance(String name, CurriculumGrade grade, int overallAverageMark,
			Map<ExamType, Set<SubjectName>> distinctionSubjects) {
		this.name = name;
		this.grade = grade;
		this.overallAverageMark = overallAverageMark;
		Map<ExamType, Set<SubjectName>> copy = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		
		for (var entry : distinctionSubjects.entrySet()) {
		    copy.put(
		        entry.getKey(),
		        Collections.unmodifiableSet(entry.getValue())
		    );
		}
		
		this.distinctionSubjects = Collections.unmodifiableMap(copy);
	}
	
	public int getAverageDistinctionCount() {
		return averageDistinctionCount();
	}
	
	public CurriculumGrade getGrade() {
		return grade;
	}

	private int averageDistinctionCount() {
		int distinctionCount =0;
		int typeCount = distinctionSubjects.size();
		
		for (var type : distinctionSubjects.entrySet()) {
			distinctionCount += type.getValue().size();
		}
		
		return typeCount ==0? 0: distinctionCount/typeCount;
	}
	
	public double getScore() {
		return score();
	}
	
	public double score() {
		return (overallAverageMark * 0.8) +(getAverageDistinctionCount() *0.2);
	}
	public String getName() {
		return name;
	}
	
	public int getOverallAverageMark() {
		return overallAverageMark;
	}
	
	public Map<ExamType, Set<SubjectName>> getDistinctionSubjects() {
		return distinctionSubjects;
	}
	
	public String toString() {
		if (name.equals("No Student")) {
			return "haven't grade overall best student performance";
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name : ").append(name)
		  .append("\nGrade: ")
		  .append(grade)
	      .append("\nOverall Average Mark : ")
	      .append(overallAverageMark)
	      .append("\nOverall Average Distinction Count: ")
	      .append(getAverageDistinctionCount())
	      .append("\nDistinction Subjects:\n");

	    distinctionSubjects.forEach((type, subjects) ->
	        sb.append(type)
	          .append(" -> ")
	          .append(subjects)
	          .append("\n"));

	    return sb.toString();
	}
}
