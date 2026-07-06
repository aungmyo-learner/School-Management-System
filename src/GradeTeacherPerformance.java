

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class GradeTeacherPerformance {
	private final CurriculumGrade grade;
	private final Map<ExamType, TeacherExamDetail> details;
	private final GradeOverallBestTeachertPerformance gradeBestTeacherPerformance;
	private final double overallPassRate;
	
	public GradeTeacherPerformance(CurriculumGrade grade, Map<ExamType, TeacherExamDetail> details) {
		this.grade = grade;
		Map<ExamType, TeacherExamDetail> copy = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		copy.putAll(details);
		this.details = Collections.unmodifiableMap(copy);
		this.gradeBestTeacherPerformance = choiceOverallBestTeacherPerformance(details,grade);
		this.overallPassRate = calculateOverallPassRate(details);
	}
	
	public CurriculumGrade getGrade() {
		return grade;
	}

	public double getOverallPassRate() {
		return overallPassRate;
	}

	public Map<ExamType, TeacherExamDetail> getDetails() {
		return details;
	}
	
	private double calculateOverallPassRate(Map<ExamType, TeacherExamDetail> detail) {

	    double totalPassed = 0;
	    double totalStudents = 0;

	    for (TeacherExamDetail examDetail : detail.values()) {

	        for (TeacherPerformance p : examDetail.getPerformances()) {
	            totalPassed += p.getPassCount();
	            totalStudents += p.getExamStudentsCount();
	        }
	    }
	    return totalStudents == 0? 0 : (totalPassed / totalStudents) * 100;
	}
	
	private GradeOverallBestTeachertPerformance choiceOverallBestTeacherPerformance(
			Map<ExamType, TeacherExamDetail> detail,CurriculumGrade grade) {
		
		Map<String, GradeOverallTeacherBestPerformanceAccumulator> accumulators =
				calculateGradeOverallTeacherPerformance(detail);
		
		var best = accumulators.entrySet().stream()
				.max(Map.Entry.comparingByValue(SchoolComparators.GRADE_OVERALL_BEST_TEACHER_PERFORMANCE_ACCUMULATOR))
				.orElse(null);
		if(best == null) {
			return new GradeOverallBestTeachertPerformance("No Teache", null, null,
					0, 0, 0, 0, 0);
		}
		
		return new GradeOverallBestTeachertPerformance(best.getKey(),
				best.getValue().getSubject(),
				grade,
				 best.getValue().getOverallAverageMark(),
				 best.getValue().getOverallStudentPassCount(),
				 best.getValue().getOverallDistinctionCount(),
				 best.getValue().getOverallPassRate(),
				 best.getValue().getScore());
	}
	
	public GradeOverallBestTeachertPerformance getGradeBestTeacherPerformance() {
		return gradeBestTeacherPerformance;
	}

	private Map<String, GradeOverallTeacherBestPerformanceAccumulator> calculateGradeOverallTeacherPerformance(
			Map<ExamType, TeacherExamDetail> details) {
		Map<String, GradeOverallTeacherBestPerformanceAccumulator> accumulators = new TreeMap<>();
		for (var type : details.entrySet()) {
			
			for (TeacherPerformance performance : type.getValue().getPerformances()) {
				
				String name = performance.getName();

				GradeOverallTeacherBestPerformanceAccumulator accumulator =accumulators.computeIfAbsent(name, 
						n -> new GradeOverallTeacherBestPerformanceAccumulator(performance.getSubject()));
				
				accumulator.addExamStudentCount(performance.getExamStudentsCount());
				accumulator.addStudentPassCount(performance.getPassCount());
				accumulator.addTotalMarks(performance.getTotalMark());
			
			}
		}
		return accumulators;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Grade: ").append(grade);
		details.forEach((type,detail)->{
			sb.append(type).append("->")
			.append(detail).append("\n");
		});
		sb.append("Grade Best Teacher Performance\n")
		.append(gradeBestTeacherPerformance)
		.append("\nOverall Pass Rate: ").append(overallPassRate);
		
		return sb.toString();
	}
}
