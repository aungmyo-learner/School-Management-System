

public class SchoolOverallStuentPerformanceController {
	private final SchoolOverallStudentPerformanceService service;
	private final SchoolOverallStudentPerformanceInterFace user;
	
	public SchoolOverallStuentPerformanceController(SchoolOverallStudentPerformanceService service,
			SchoolOverallStudentPerformanceInterFace user) {
		this.service = service;
		this.user = user;
	}
	
	public void start() {
		askExamType();
		askAll();
	}
	
	private void askExamType() {
		Answer answer = user.askOnlyExamTypeOverallResult();
		if(answer == Answer.YES) {
			ExamType type = user.askExamType();
			OverallStudentPerformance performance = service.getExamTypeOverallStudentPerformance(type);
			user.printExamTypeOverallPerformance(performance);
		}
	}
	
	private void askAll() {
		Answer answer = user.askOnlyOverallResult();
		if (answer == Answer.YES) {
			OverallStudentPerformanceSummary summary = service.getSchoolOverallStudentPerformanceSummary();
			user.printOverallSummary(summary);
		}
	}
}
