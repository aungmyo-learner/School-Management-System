

import java.util.Map;

public class SchoolGradeStudentPerformanceController {
	private final SchoolGradeStudentPerformanceService performanceService;
	private final SchoolGradeStudentPerformanceInterFace user;
	
	public SchoolGradeStudentPerformanceController(SchoolGradeStudentPerformanceService performanceService,
			SchoolGradeStudentPerformanceInterFace user) {
		this.performanceService = performanceService;
		this.user = user;
	}

	public void allGradeStudentPerformanceControl() {
		all();
	}

	private void all() {
		Map<CurriculumGrade, GradeStudentsPerformance> gradePerformance = 
				performanceService.getGradePerformancesByGrade();
		user.printGradePerformancesReport(gradePerformance);
	}
	
	public void allExamTypeGradeStudentPerformanceControl() {
		allExamType();
	}
	
	private void allExamType() {
		ExamType type = user.askExamType();
		Map<CurriculumGrade, ExamStudentsPerformanceResult> performances =
		performanceService.getExamTypeGradePerformancesByGrade(type);
		user.printExamTypeGradePerformancesReport(type, performances);
	}
	
	public void gradeGradeStudentPerformanceControl() {
		grade();
	}
	
	private void grade() {
		CurriculumGrade grade = user.askCurriculumGrade();
		GradeStudentsPerformance performance = performanceService.getGradePerformanceOfGrade(grade);
		user.printGradePerformanceOfGrade(performance);
	}
	
	public void gradeExamTypeGradeStudentPerformanceControl() {
		gradeExamType();
	}
	
	private void gradeExamType() {
		CurriculumGrade grade = user.askCurriculumGrade();
		ExamType type = user.askExamType();
		ExamStudentsPerformanceResult result = 
				performanceService.getExamtypeGradePerformanceOfGrade(grade, type);
		user.printExamTypeGradePerformanceOfGrade(type, result);
	}
	
}
