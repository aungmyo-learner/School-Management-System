

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class GradeStudentsPerformance {
	private final CurriculumGrade grade;
	private final Map<ExamType, ExamStudentsPerformanceResult> result;
	private final GradeOverallBestStudentPerformance gradeBestStudentPerformance;
	
	public GradeStudentsPerformance(CurriculumGrade grade, Map<ExamType, ExamStudentsPerformanceResult> result) {
		this.grade = grade;
		Map<ExamType, ExamStudentsPerformanceResult> copy = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		copy.putAll(result);
		this.result = Collections.unmodifiableMap(copy);
		this.gradeBestStudentPerformance = choiceOverallGradeBestStudentPerformance(result);
	}
	
	public CurriculumGrade getGrade() {
		return grade;
	}

	public Map<ExamType, ExamStudentsPerformanceResult> getResult() {
		return Collections.unmodifiableMap(result);
	}
	
	private GradeOverallBestStudentPerformance choiceOverallGradeBestStudentPerformance(
			Map<ExamType, ExamStudentsPerformanceResult> result) {
		
		Map<String, GradeOverallStudentBestPerformanceAccumulator> accumulators = 
				calculateGradeOverallStudentPerformances(result);
		
		var best = accumulators.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue(
						SchoolComparators.GRADE_OVERALL_BEST_STUDENT_PERFORMANCE_ACCUMULATOR)).orElse(null);
		return best == null? null :
			new GradeOverallBestStudentPerformance(
				best.getValue().getName(), grade,
				best.getValue().getOverallAverageMark(),
				best.getValue().getDistinctionSubjects());
	}
	
	private Map<String, GradeOverallStudentBestPerformanceAccumulator> calculateGradeOverallStudentPerformances(
			Map<ExamType, ExamStudentsPerformanceResult> result){

		Map<String, GradeOverallStudentBestPerformanceAccumulator> accumulators = new TreeMap<>();
		
		for (var r : result.entrySet()) {
			
			ExamType type = r.getKey();
			Set<StudentPerformance> performance = r.getValue().getPerformances();
			
			for (StudentPerformance p : performance) {
				
				String name = p.getName();
				GradeOverallStudentBestPerformanceAccumulator accumulator = accumulators.computeIfAbsent(name,
						n-> new GradeOverallStudentBestPerformanceAccumulator(n));
				accumulator.incrementTypeCount();
				accumulator.addAverageMark(p.getAverageMark());
				accumulator.addDistinctionSubjects(type, p.getDistinctions());
				accumulator.addDistinciontCount(p.getDistinctionCount());
				accumulator.addTotalMark(p.getTotalMark());
			}
			
		}
		return accumulators;
	}

	public GradeOverallBestStudentPerformance getGradeBestStudentPerformance() {
		return gradeBestStudentPerformance;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Grade: ").append(grade);
		
		result.forEach((type, r)-> sb.append(type).append("→").append(r).append("\n"));
		sb.append("Best Student Performance\n").append(gradeBestStudentPerformance);
		
		return sb.toString();
	}
}
