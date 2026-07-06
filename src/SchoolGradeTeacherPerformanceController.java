

import java.util.Map;

public class SchoolGradeTeacherPerformanceController {
	private final SchoolGradeTeacherPerformanceService performanceService;
	private final SchoolGradeTeacherPerformanceInterFace user;
	
	public SchoolGradeTeacherPerformanceController(SchoolGradeTeacherPerformanceService performanceService,
			SchoolGradeTeacherPerformanceInterFace user) {
		this.performanceService = performanceService;
		this.user = user;
	}

	public void allGradeTeacherPerformanceControl() {
		all();
	}

	private void all() {
		Map<CurriculumGrade, GradeTeacherPerformance> performances = 
				performanceService.getGradeTeacherPerformanceByGrade();
		user.printGradeTeacherPerformancesReport(performances);
	}
	
	public void allExamTypeGradeTeacherPerformanceControl() {
		allExamType();
	}

	private void allExamType() {
		ExamType type = user.askExamType();
		Map<CurriculumGrade, TeacherExamDetail> details = 
				performanceService.getExamTypeGradeTeacherperformances(type);
		user.printExamTypeGradeTeacherPerformanceReport(type, details);
	}
	
	public void gradeGradeTeacherPerformanceControl() {
		grade();
	}
	
	private void grade() {
		CurriculumGrade grade = user.askCurriculumGrade();
		GradeTeacherPerformance performance = performanceService.getGradeTeacherPerformances(grade);
		user.printGradeTeacherPerformanceOfGrade(grade, performance);
	}
	
	public void gradeExamTypeGradeTeacherPerformanceControl() {
		gradeExamType();
	}
	
	private void gradeExamType() {
		CurriculumGrade grade = user.askCurriculumGrade();
		ExamType type = user.askExamType();
		TeacherExamDetail detail = 
				performanceService.getExamTypeGradeTeacherPerformanceOfGrade(grade, type);
		user.printExamTypeGradeTeacherPerformanceOfGrade(grade, type, detail);
	}
	
}
