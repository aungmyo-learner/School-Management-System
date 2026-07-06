

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.ToIntFunction;

public class SchoolOverallTeacherPerformanceService {
	private final SchoolGradeTeacherPerformanceService teacherService;
	private final SchoolTeacherPerformanceService performanceService;
	public SchoolOverallTeacherPerformanceService(SchoolGradeTeacherPerformanceService teacherService, 
			SchoolTeacherPerformanceService performanceService) {
		this.teacherService = teacherService;
		this.performanceService = performanceService;
	}
	
	public OverallTeacherPerformanceSummary getSummary() {
		return summary();
	}
	
	public OverallTeacherPerformance getOverallTeacherPerformance(ExamType type) {
		return overallTeacherPerformances().get(type);
	}
	
	private int averageOf(Map<ExamType, OverallTeacherPerformance> performances
			, ToIntFunction<OverallTeacherPerformance> mapper) {
		int count = performances.size();
		
		int total = performances.values()
				.stream()
				.mapToInt(mapper)
				.sum();
		return count ==0? 0: total/count;
	}
	
	private OverallBestTeacherPerformance getOverallBestTeacherPerformance() {
		Map<CurriculumGrade, GradeTeacherPerformance> teacherPerformancesByGrade =
				teacherService.getGradeTeacherPerformanceByGrade();
		
		var best = teacherPerformancesByGrade.values()
				.stream()
				.map(GradeTeacherPerformance::getGradeBestTeacherPerformance)
				.max(SchoolComparators.GRADE_OVERALL_TEACHER_BEST_PERFORMANCE)
				.orElse(null);
		if (best == null) {
			return new OverallBestTeacherPerformance("No Teacher", null, null, 0);
		}
		return new OverallBestTeacherPerformance(best.getName(),best.getSubject(), best.getGrade(), best.getScore());
	}
	
	private OverallTeacherPerformanceSummary summary() {
		Map<ExamType, OverallTeacherPerformance> performances = overallTeacherPerformances();
		int teachers = averageOf(performances, OverallTeacherPerformance:: getOverallTeachers);
		int teacherAverageMark = averageOf(performances, OverallTeacherPerformance:: getAverageTeacherAverageMark);
		int averageDistinction = averageOf(performances, OverallTeacherPerformance:: getOverallTeachers);
		
		double passRate = teachers ==0? 0 : ((double) teacherAverageMark/teachers) * 100;
		
		OverallBestTeacherPerformance performance = getOverallBestTeacherPerformance();
		
		OverallTeacherPerformanceSummary summary = new OverallTeacherPerformanceSummary(teachers, teacherAverageMark, passRate,
				averageDistinction, performance);
		return summary;
	}
	
	private Map<ExamType, OverallTeacherPerformance> overallTeacherPerformances() {
		Map<ExamType, OverallTeacherPerformance> performances = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		Map<ExamType, OverallTeacherAccumulator> accumulators = buildOverallTeacherAccumulator();
		for (var typeEntry : accumulators.entrySet()) {
			ExamType type = typeEntry.getKey();
			
			performances.put(type, new OverallTeacherPerformance(typeEntry.getValue().getOverallTeacher(),
					typeEntry.getValue().getAverageTeacherAverageMark(),
					typeEntry.getValue().getAverageTeacherPassRate(),
					typeEntry.getValue().getTeachersDistinctionTotal()));
		}
		return Collections.unmodifiableMap(performances);
	}
	
	private Map<ExamType, OverallTeacherAccumulator> buildOverallTeacherAccumulator(){
		Map<ExamType, OverallTeacherAccumulator> accumulators = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		Map<CurriculumGrade, GradeTeacherPerformance> teacherPerformancesByGrade =
				teacherService.getGradeTeacherPerformanceByGrade();
		for (var gradeEntry : teacherPerformancesByGrade.entrySet()) {
			Map<ExamType, Set<TeacherPerformance>> summaries = performanceService.getBuildTeacherPerformances(gradeEntry.getKey());
			for (var typeEntry : summaries.entrySet()) {
				ExamType type = typeEntry.getKey();
				for (TeacherPerformance performance : typeEntry.getValue()) {
					OverallTeacherAccumulator accumulator = accumulators.computeIfAbsent(type,
							t-> new OverallTeacherAccumulator());
					accumulator.addAverageMark(performance.getAverageMark());
					accumulator.addPassRate(performance.getPassRate());
					accumulator.addDistinctionCount(performance.getDistinctionCount());
					accumulator.incrementOverallTeacher();
				}
			}
		}
		return accumulators;
	}
}
