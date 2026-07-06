

import java.util.Map;
import java.util.Set;

public class SchoolStudentController {
	private final SchoolStudentService studentService;
	private final SchoolExamService examService;
	private final SchoolStudentInterFace user;
	public SchoolStudentController(SchoolStudentService studentService, SchoolExamService examService,
			SchoolStudentInterFace user) {
		this.studentService = studentService;
		this.examService = examService;
		this.user = user;
	}
	
	public void enrollControl() {
		enroll();
	}
	
	private void enroll() {
		StudentInfo info = user.askEnrollForStudent();
		Status status = studentService.previewStudent(info.getGrade(), info.getName(), info.getParent());
		switch (status) {
		case EXIST:
			user.exist();
			break;
		case NOT_EXST:
			ExamRecord record = studentService.enrollStudent(info);
			examService.enrollExamRecord(record);
			user.successEnrol();
			break;
		}
	}
	
	public void expelControl() {
		expel();
	}
	
	private void expel() {
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		switch (status) {
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			studentService.expelStudent(student);
			user.successExpel();
			break;
		case NOT_EXST:
			user.notExist();
		}
	}
	
	public void allStudentControl() {
		all();
	}
	
	private void all() {
		Map<CurriculumGrade, Set<Student>> students = studentService.getStudents();
		user.printStudents(students);
	}
	
	public void gradeStudentControl() {
		grade();
	}

	private void grade() {
		CurriculumGrade grade = user.askCurriculumGrade();
		Set<Student> students = studentService.getStudentsOfAGrade(grade);
		user.printStudentsOfGrade(grade, students);
	}

	public void eachStudentControl() {
		each();
	}
	
	private void each() {
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		switch (status) {
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			user.printStudent(student);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
}
