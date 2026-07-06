

import java.util.Map;
import java.util.Set;

public class SchoolTeacherPerformanceController {
	private final SchoolTeacherService teacherService;
	private final SchoolTeacherPerformanceService performanceService;
	private final SchoolTeacherPerformanceInterFace user;
	
	public SchoolTeacherPerformanceController(SchoolTeacherService teacherService,
			SchoolTeacherPerformanceService performanceService, SchoolTeacherPerformanceInterFace user) {
		this.teacherService = teacherService;
		this.performanceService = performanceService;
		this.user = user;
	}

	public void allTeacherPerformanceControl() {
		all();
	}
	
	private void all() {
		Map<CurriculumGrade, Map<ExamType, Set<TeacherPerformance>>> performance =
				performanceService.getTeacherPerformances();
		user.printTeacherPerformances(performance);
	}	
	
	public void allExamTypeTeacherPerformanceControl() {
		allExamType();
	}
	
	private void allExamType() {
		ExamType type = user.askExamType();
		Map<CurriculumGrade, Set<TeacherPerformance>> performances = 
				performanceService.getExamTypeTeacherPerformances(type);
		user.printExamTypeTeacherPerformances(type, performances);
	}

	public void gradeTeacherPerformanceControl() {
		grade();
	}
	
	private void grade() {
		CurriculumGrade grade = user.askCurriculumGrade();
		Map<ExamType, Set<TeacherPerformance>> performances =
				performanceService.getTeachersPerformances(grade);
		user.printTeacherPerformancesOfGrade(grade, performances);
	}
	
	public void gradeExamTypeTeacherPerformanceControl() {
		gradeExamType();
	}
	
	private void gradeExamType() {
		CurriculumGrade grade = user.askCurriculumGrade();
		ExamType type = user.askExamType();
		Set<TeacherPerformance> performances = 
				performanceService.getExamTypeTeacherPerformanceOfGrade(grade, type);
		user.printExamTypeTeacherPerfomrancesOfGrade(type, performances);
	}
	
	public void eachTeacherPerformanceControl() {
		each();
	}

	private void each() {
		SearchTeacher search = user.searchTeacher();
		Status status = teacherService.previewTeacher(search.getName(), search.getGrade());
		switch (status) {
		case EXIST:
			Teacher teacher = teacherService.getTeacher(search.getName(), search.getGrade());
			Map<ExamType, TeacherPerformance> performances = performanceService.getTeacherPerformances(teacher);
			user.printEachTeacherPerformances(teacher, performances);
			break;
		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
	public void eachExamTypeTeacherControl() {
		eachExamType();
	}
	
	private void eachExamType() {
		SearchTeacher search = user.searchTeacher();
		Status status = teacherService.previewTeacher(search.getName(), search.getGrade());
		switch (status) {
		case EXIST:
			Teacher teacher = teacherService.getTeacher(search.getName(), search.getGrade());
			ExamType type = user.askExamType();
			TeacherPerformance performance = performanceService.getTeacherPerformance(teacher, type);
			user.printEachExamTypeTeacherPerformance(type, performance);
			break;
		case NOT_EXST:
			user.notExist();
			break;
		}
	}
}
