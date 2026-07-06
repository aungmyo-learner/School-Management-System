

public class SchoolOverallTeacherPerformanceController {
	private final SchoolOverallTeacherPerformanceService service;
	private final SchoolOverallTeacherPerformanceInterFace user;
	
	public SchoolOverallTeacherPerformanceController(SchoolOverallTeacherPerformanceService service,
			SchoolOverallTeacherPerformanceInterFace user) {
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
			OverallTeacherPerformance performance = service.getOverallTeacherPerformance(type);
			user.printExamTypeOverallPerformance(performance);
		}
	}
	
	private void askAll() {
		Answer answer = user.askOnlyOverallResult();
		if (answer == Answer.YES) {
			OverallTeacherPerformanceSummary summary = service.getSummary();
			user.printOverallSummary(summary);
		}
	}
}
