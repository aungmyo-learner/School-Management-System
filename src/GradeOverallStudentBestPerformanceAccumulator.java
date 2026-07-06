

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GradeOverallStudentBestPerformanceAccumulator {
	private final String name;
	private int averageMark;
	private int typeCount;
	private int distinctionCount;
	private int totalMark;
	private Map<ExamType, Set<SubjectName>> distinctionSubjects = 
			new TreeMap<>(SchoolComparators.EXAM_TYPE);
	
	public GradeOverallStudentBestPerformanceAccumulator(String name) {
		this.name = name;
	}
	
	public void addAverageMark(int averageMark) {
		this.averageMark += averageMark;
	}
	
	public void addTotalMark(int totalMark) {
		this.totalMark += totalMark;
	}
	
	public void incrementTypeCount() {
		typeCount++;
	}
	
	public void addDistinciontCount(int count) {
		distinctionCount += count;
	}
	
	public void addDistinctionSubjects(ExamType type, Set<SubjectName> distinction) {
		distinctionSubjects.computeIfAbsent(type, t->new TreeSet<>(SchoolComparators.SUBJECTS)).addAll(distinction);
	}
	
	public int getOverallAverageMark() {
		return typeCount == 0? 0: averageMark / typeCount;
	}
	
	public int getOverallAverageDistinctionCount() {
		return typeCount ==0? 0: distinctionCount / typeCount;
	}
	
	public int getOverallAverageTotalMark() {
		return typeCount ==0? 0: totalMark / typeCount;
	}

	public Map<ExamType, Set<SubjectName>> getDistinctionSubjects(){
		return Collections.unmodifiableMap(distinctionSubjects);
	}

	public String getName() {
		return name;
	}
	
}
