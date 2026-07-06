

import java.util.Map;
import java.util.Set;

public class SchoolStudentPerformanceController {
	private final SchoolStudentService studentService;
	private final SchoolStudentPerformanceService performanceService;
	private final SchoolStudentPerformanceInterFace user;
	
	public SchoolStudentPerformanceController(SchoolStudentService studentService,
			SchoolStudentPerformanceService performanceService, SchoolStudentPerformanceInterFace user) {
		this.studentService = studentService;
		this.performanceService = performanceService;
		this.user = user;
	}

	public void allStudentPerformanceControl() {
		all();
	}

	private void all() {
		Map<CurriculumGrade, Map<ExamType, Set<StudentPerformance>>> performances = 
				performanceService.getStudentPerformances();
		user.printStudentPerformances(performances);
	}
	
	public void allExamTypeStudentPerformacneControl() {
		allExamType();
	}
	
	private void allExamType() {
		ExamType type = user.askExamType();
		Map<CurriculumGrade, Set<StudentPerformance>> performances = 
				performanceService.getExamTypeStudentPerformance(type);
		user.printExamTypeStudentPerformances(type, performances);
	}
	
	public void gradeStudentPerformanceControl() {
		grade();
	}

	private void grade() {
		CurriculumGrade grade = user.askCurriculumGrade();
		Map<ExamType, Set<StudentPerformance>> performances = 
				performanceService.getGradeStudentPerformances(grade);
		user.printStudentPerformancesOfGrade(grade, performances);
	}
	
	public void gradeExamTypeStudentPerformanceControl() {
		gradeExamType();
	}
	
	private void gradeExamType() {
		CurriculumGrade grade = user.askCurriculumGrade();
		ExamType type = user.askExamType();
		Set<StudentPerformance> performances = 
				performanceService.getExamTypeStudentPerformancesOfGrade(grade, type);
		user.printExamTypeStudentPerformancesOfGrade(grade, type, performances);
	}
	
	public void eachStudentPerformanceControl() {
		each();
	}
	
	private void each() {
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		switch (status) {
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			Map<ExamType, StudentPerformance> perofrmances = 
					performanceService.getEachStudentPerformances(student);
			user.printEacheStudentPerformances(student, perofrmances);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
	public void eachExamTypeStudentPerformanceControl() {
		eachExamType();
	}
	
	private void eachExamType() {
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		switch (status) {
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			ExamType type = user.askExamType();
			StudentPerformance performance = performanceService.getEachStudentPerformance(student, type);
			user.printEachExamTypeStudentPerformance(student, type, performance);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
}
