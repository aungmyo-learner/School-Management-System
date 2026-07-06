

public class SchoolController {
	private final SchoolTeacherController teacherController;
	private final SchoolStudentController studentController;
	private final SchoolClerkController clerkController;
	private final SchoolExamController examController;
	private final SchoolStudentPerformanceController studentPerformanceController;
	private final SchoolTeacherPerformanceController teacherPerformanceController;
	private final SchoolGradeStudentPerformanceController gradeStudentPerformanceController;
	private final SchoolGradeTeacherPerformanceController gradeTeacherPerformanceController;
	private final SchoolOverallStuentPerformanceController overallStudentPerformanceController;
	private final SchoolOverallTeacherPerformanceController overallTeacherPerformanceController;
	private final SchoolUserInterFace user;

	public SchoolController(SchoolTeacherController teacherController, SchoolStudentController studentController,
			SchoolClerkController clerkController, SchoolExamController examController,
			SchoolStudentPerformanceController studentPerformanceController,
			SchoolTeacherPerformanceController teacherPerformanceController,
			SchoolGradeStudentPerformanceController gradeStudentPerformanceController,
			SchoolGradeTeacherPerformanceController gradeTeacherPerformanceController,
			SchoolOverallStuentPerformanceController overallStudentPerformanceController,
			SchoolOverallTeacherPerformanceController overallTeacherPerformanceController, SchoolUserInterFace user) {
		this.teacherController = teacherController;
		this.studentController = studentController;
		this.clerkController = clerkController;
		this.examController = examController;
		this.studentPerformanceController = studentPerformanceController;
		this.teacherPerformanceController = teacherPerformanceController;
		this.gradeStudentPerformanceController = gradeStudentPerformanceController;
		this.gradeTeacherPerformanceController = gradeTeacherPerformanceController;
		this.overallStudentPerformanceController = overallStudentPerformanceController;
		this.overallTeacherPerformanceController = overallTeacherPerformanceController;
		this.user = user;
	}

	public void start() {
		while (true) {
			Menu menu = user.askChoiceMenu();
			if (menu == Menu.EXIT) break;
			switch (menu) {
			case ENROLL:
				EntityType enrol = user.askEnrol();
				enrollType(enrol);
				break;
				
			case EXPEL:
				EntityType expel = user.askExpel();
				expelType(expel);
				break;
			case VIEW:
				choiceView();
				break;
			default:
				break;
			}
		}
		overallCase();
	}
	
	private void enrollType(EntityType type) {
		switch (type) {
		case TEACHER:
			teacherController.enrollControl();
			break;
		case STUDENT:
			studentController.enrollControl();
			break;
		case CLERK:
			clerkController.enrolControl();
			break;
		case EXAM_RECORD:
			examController.enrolControl();
			break;
		case EXAM_TYPE_EXAM_RECORD:
			break;
		default:
			break;
		}
	}

	private void expelType(EntityType type) {
		switch (type) {
		case TEACHER:
			teacherController.expelControl();
			break;
		case STUDENT:
			studentController.expelControl();
			break;
		case CLERK:
			clerkController.expelControl();
			break;
		case EXAM_RECORD:
			examController.expelControl();
			break;
		case EXAM_TYPE_EXAM_RECORD:
			examController.expelExamTypeControl();
			break;
		default:
			break;
		}
	}
	
	private void choiceView() {
		Kind kind = user.askKind();
		switch (kind) {
		case ENTITY:
			entity();
			break;
		case REPORT:
			report();
			break;
		default:
			break;
		}
	}
	
	private void entity() {
		EntityType manage = user.askViewManage();
		switch (manage) {
		case TEACHER:
		case STUDENT:
		case EXAM_RECORD:
		case EXAM_TYPE_EXAM_RECORD:
			generalView(manage);
			break;
		case CLERK:
			clerkView(manage);
			break;

		default:
			break;
		}
	}
	
	private void generalView(EntityType type) {
		View view = user.askGeneralView();
		switch (view) {
		case ALL:
			allViewEntityType(type);
			break;
		case A_GRADE:
			gradeViewEntityType(type);
			break;
		case EACH:
			eachViewEntityType(type);
			break;

		default:
			break;
		}
	}
	
	private void clerkView(EntityType type) {
		View view = user.askClerkView();
		switch (view) {
		case ALL:
			allViewEntityType(type);
			break;
		case EACH:
			eachViewEntityType(type);
			break;
		default:
			break;
		}
	}
	
	private void allViewEntityType(EntityType type) {
		switch (type) {
		case TEACHER:
			teacherController.allTeacherControl();
			break;
			
		case STUDENT:
			studentController.allStudentControl();
			break;
			
		case CLERK:
			clerkController.allClerkControl();
			break;
			
		case EXAM_RECORD:
			examController.allExamRecordControl();
			break;

		case EXAM_TYPE_EXAM_RECORD:
			examController.allExamTypeControl();
			break;
			
		default:
			break;
		}
	}
	
	private void gradeViewEntityType(EntityType type) {

		switch (type) {
		case TEACHER:
			teacherController.gradeTeacherControl();
			break;
			
		case STUDENT:
			studentController.gradeStudentControl();
			break;
		
		case EXAM_RECORD:
			examController.gradeExamRecordControl();
			break;

		case EXAM_TYPE_EXAM_RECORD:
			examController.gradeExamTypeExamRecordControl();
			break;
			
		default:
			break;
		}
	}
	
	private void eachViewEntityType(EntityType type) {
		switch (type) {
		case TEACHER:
			teacherController.eachTeacherControl();
			break;
			
		case STUDENT:
			studentController.eachStudentControl();
			break;
			
		case CLERK:
			clerkController.eachClerkControl();
			break;
			
		case EXAM_RECORD:
			examController.eachExamRecordControl();
			break;

		case EXAM_TYPE_EXAM_RECORD:
			examController.eachExamTypeExamRecordControl();
			break;

		default:
			break;
		}
		
	}
	
	private void report() {
		ReportType type = user.askReport();
		switch (type) {
		case STUDENT_PERFORMANCE:
		case EXAM_TYPE_STUDENT_PERFORMANCE:
		case TEACHER_PERFORMANCE:
		case EXAM_TYPE_TEACHER_PERFORMANCE:
			personPerformances(type);
			break;
		case GRADE_PERFORMANCE:
		case EXAM_TYPE_GRADE_PERFORMANCE:
		case GRADE_TEACHER_PERFORMANCE:
		case EXAM_TYPE_GRADE_TEACHER_PERFORMANCE:
			gradePerformances(type);
			break;
		default:
			break;
		}
	}
	
	private void personPerformances(ReportType type) {
		View view = user.askPersonPerformancesView();
		switch (view) {
		case ALL:
			allReportView(type);
			break;
		case A_GRADE:
			gradeReportView(type);
			break;
		case EACH:
			eachReportView(type);
			break;
		default:
			break;
		}
	}
	
	private void gradePerformances(ReportType type) {
		View view = user.askGradePerformancesView();
		switch (view) {
		case ALL:
			allReportView(type);
			break;
		case A_GRADE:
			gradeReportView(type);
			break;
			
		default:
			break;
		}

	}
	private void allReportView(ReportType type) {
		switch (type) {
		case STUDENT_PERFORMANCE:
			studentPerformanceController.allStudentPerformanceControl();
			break;
		case EXAM_TYPE_STUDENT_PERFORMANCE:
			studentPerformanceController.allExamTypeStudentPerformacneControl();
			break;
		case TEACHER_PERFORMANCE:
			teacherPerformanceController.allTeacherPerformanceControl();
			break;
		case EXAM_TYPE_TEACHER_PERFORMANCE:
			teacherPerformanceController.allExamTypeTeacherPerformanceControl();
			break;
		case GRADE_PERFORMANCE:
			gradeStudentPerformanceController.allGradeStudentPerformanceControl();
			break;
		case EXAM_TYPE_GRADE_PERFORMANCE:
			gradeStudentPerformanceController.allExamTypeGradeStudentPerformanceControl();
			break;
		case GRADE_TEACHER_PERFORMANCE:
			gradeTeacherPerformanceController.allGradeTeacherPerformanceControl();
			break;
		case EXAM_TYPE_GRADE_TEACHER_PERFORMANCE:
			gradeTeacherPerformanceController.allExamTypeGradeTeacherPerformanceControl();
			break;
		default:
			break;
		}
	}
	
	private void gradeReportView(ReportType type) {
		switch (type) {
		case STUDENT_PERFORMANCE:
			studentPerformanceController.gradeStudentPerformanceControl();
			break;
		case EXAM_TYPE_STUDENT_PERFORMANCE:
			studentPerformanceController.gradeExamTypeStudentPerformanceControl();
			break;
		case TEACHER_PERFORMANCE:
			teacherPerformanceController.gradeTeacherPerformanceControl();
			break;
		case EXAM_TYPE_TEACHER_PERFORMANCE:
			teacherPerformanceController.gradeExamTypeTeacherPerformanceControl();
			break;
		case GRADE_PERFORMANCE:
			gradeStudentPerformanceController.gradeGradeStudentPerformanceControl();
			break;
		case EXAM_TYPE_GRADE_PERFORMANCE:
			gradeStudentPerformanceController.gradeExamTypeGradeStudentPerformanceControl();
			break;
		case GRADE_TEACHER_PERFORMANCE:
			gradeTeacherPerformanceController.gradeGradeTeacherPerformanceControl();
			break;
		case EXAM_TYPE_GRADE_TEACHER_PERFORMANCE:
			gradeTeacherPerformanceController.gradeExamTypeGradeTeacherPerformanceControl();
			break;
		default:
			break;
		}
	}
	
	private void eachReportView(ReportType type) {
		switch (type) {
		case STUDENT_PERFORMANCE:
			studentPerformanceController.eachStudentPerformanceControl();
			break;
		case EXAM_TYPE_STUDENT_PERFORMANCE:
			studentPerformanceController.eachExamTypeStudentPerformanceControl();
			break;
		case TEACHER_PERFORMANCE:
			teacherPerformanceController.eachTeacherPerformanceControl();
			break;
		case EXAM_TYPE_TEACHER_PERFORMANCE:
			teacherPerformanceController.eachExamTypeTeacherControl();
			break;

		default:
			break;
		}
	}
	
	private void overallCase() {
		Answer answer = user.askOverallPerformance();
		if(answer == Answer.YES) {
			EntityType type = user.askChoice();
			choose(type);
		}
	}
	
	private void choose(EntityType type) {
		switch (type) {
		case TEACHER:
			overallTeacherPerformanceController.start();
			break;
		case STUDENT:
			overallStudentPerformanceController.start();
			break;
		default:
			break;
		}
	}
}
