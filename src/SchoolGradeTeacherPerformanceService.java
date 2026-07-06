

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SchoolGradeTeacherPerformanceService {
	private final SchoolTeacherRepository teacherRepo;
	private final SchoolTeacherPerformanceService performanceService;
	
	public Map<CurriculumGrade, GradeTeacherPerformance> getGradeTeacherPerformanceByGrade() {
		return gradeTeacherPerformanceByGrade();
	}
	
	public SchoolGradeTeacherPerformanceService(SchoolTeacherRepository teacherRepo,
			SchoolTeacherPerformanceService performanceService) {
		this.teacherRepo = teacherRepo;
		this.performanceService = performanceService;
	}

	private Map<CurriculumGrade, GradeTeacherPerformance> gradeTeacherPerformanceByGrade() {
		
		if (teacherRepo.getTeachers().isEmpty()) {
			return Map.of();
		}
		
		Map<CurriculumGrade, GradeTeacherPerformance> teacherPerformanceByGrade = 
				new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		for (var gradeEntry : teacherRepo.getTeachers().entrySet()) {
			CurriculumGrade grade = gradeEntry.getKey();
			GradeTeacherPerformance performance = buildGradeTeacherPerformance(grade);
			teacherPerformanceByGrade.put(grade, performance);
		}
		return Collections.unmodifiableMap(teacherPerformanceByGrade);
	}
	public Map<CurriculumGrade, TeacherExamDetail> getExamTypeGradeTeacherperformances(ExamType type) {
		return examTypeGradeTeacherperformances(type);
	}
	
	private Map<CurriculumGrade, TeacherExamDetail> examTypeGradeTeacherperformances(ExamType type) {
		

		if (teacherRepo.getTeachers().isEmpty()) {
			return Map.of();
		}
		
		Map<CurriculumGrade, TeacherExamDetail> detailsByGrade = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var grade : teacherRepo.getTeachers().entrySet()) {
			
			Map<ExamType, TeacherExamDetail> details = buildTeacherExamDetail(grade.getKey());
			
			TeacherExamDetail detail = details.get(type);
			
			if (detail != null)
				detailsByGrade.put(grade.getKey(), detail);
		}
		
		return detailsByGrade;
	}
	
	public GradeTeacherPerformance getGradeTeacherPerformances(CurriculumGrade grade) {
		return buildGradeTeacherPerformance(grade);
	}
	
	public TeacherExamDetail getExamTypeGradeTeacherPerformanceOfGrade(CurriculumGrade grade, ExamType type) {
		 return buildTeacherExamDetail(grade).get(type);
	}

	private GradeTeacherPerformance buildGradeTeacherPerformance(CurriculumGrade grade) {
		Map<ExamType, TeacherExamDetail> details = buildTeacherExamDetail(grade);
		return new GradeTeacherPerformance(grade, details);
	}
	
	private Map<ExamType, TeacherExamDetail> buildTeacherExamDetail(CurriculumGrade grade) {
		
		Map<ExamType, Set<TeacherPerformance>> performances = performanceService.getBuildTeacherPerformances(grade); 
		
		if (performances.isEmpty()) {
			return Map.of();
		}
		Map<ExamType, TeacherExamDetail> details = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		
		for (var typeEntry : performances.entrySet()) {
			ExamType type = typeEntry.getKey();
			double passRate =0, totalPassCount = 0, totalExamStudentCount =0;
			Set<TeacherPerformance> p = new TreeSet<>(SchoolComparators.TEACHER_PERFORMANCE);
			p.addAll(typeEntry.getValue());
			for (TeacherPerformance performance : typeEntry.getValue()) {
				totalPassCount += performance.getPassCount();
				totalExamStudentCount += performance.getExamStudentsCount();
			}
			
			passRate = (totalPassCount /totalExamStudentCount) * 100;
			TeacherExamDetail detail = new TeacherExamDetail(passRate, p);
			details.put(type, detail);
		}
		return details;
	}
	
}
