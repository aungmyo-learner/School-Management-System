

import java.util.Map;
import java.util.Set;

public class SchoolExamController {
	private final SchoolStudentService studentService;
	private final SchoolExamService examService;
	private final SchoolExamInterFace user;
	
	public SchoolExamController(SchoolStudentService studentService, SchoolExamService examService,
			SchoolExamInterFace user) {
		this.studentService = studentService;
		this.examService = examService;
		this.user = user;
	}
	
	public void enrolControl() {
		enroll();
	}
	
	private void enroll() {
		
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		
		switch (status) {
		
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			Set<SubjectName> examSubjects = studentService.getExamSubjectName(search.getGrade());
			ExamRecord record = user.askForExamRecord(student, examSubjects);
			examService.enrollExamRecord(record);
			break;
		
		case NOT_EXST:
			user.notExist();
			Action action = user.actionForEnroll();
			enrollAction(action);
			break;
			
		}
	}
	
	private void enrollAction(Action action) {
		if (action == Action.ENROLL) {
			StudentInfo info = user.askEnrollForStudent();
			ExamRecord record = studentService.enrollStudent(info);
			examService.enrollExamRecord(record);
			Student student = studentService.getStudent(info.getGrade(), info.getName(), info.getParent());
			Set<SubjectName> examSubjects = studentService.getExamSubjectName(info.getGrade());
			ExamRecord newrecord = user.askForExamRecord(student, examSubjects);
			examService.enrollExamRecord(newrecord);
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
			examService.expelExamRecords(student);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	public void expelExamTypeControl() {
		expelExamType();
	}
	private void expelExamType() {
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		switch (status) {
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			ExamType type = user.askExamType();
			examService.expelExamTypeExamRecord(student, type);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	public void allExamRecordControl() {
		all();
	}
	private void all() {
		Map<CurriculumGrade, Map<Student,
		Map<ExamType, Map<SubjectName, ExamSubject>>>> examRecords = examService.getExamRecordsByGrade();
		user.printExamRecords(examRecords);
	}
	
	public void allExamTypeControl() {
		allExamType();
	}
	
	private void allExamType() {
		ExamType type = user.askExamType();
		Map<CurriculumGrade, Map<Student, Map<SubjectName, ExamSubject>>> records = 
				examService.getExamTypeExamRecordsByGrade(type);
		user.printExamTypeExamRecords(type, records);
	}
	
	public void gradeExamRecordControl() {
		grade();
	}
	
	private void grade() {
		CurriculumGrade grade = user.askCurriculumGrade();
		Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> records
		= examService.getExamRecordsOfAGrade(grade);
		user.printExamRecordOfGrade(grade, records);
	}
	
	public void gradeExamTypeExamRecordControl() {
		gradeExamType();
	}

	private void gradeExamType() {
		CurriculumGrade grade = user.askCurriculumGrade();
		ExamType type = user.askExamType();
		Map<Student, Map<SubjectName, ExamSubject>> students = 
				examService.getGradeExamTypeExamRecord(grade, type);
		user.printExamTypeExamRecordsOfGrade(grade, type, students);
	}

	public void eachExamRecordControl() {
		each();
	}
	
	private void each() {
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		switch (status) {
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			Map<ExamType ,Map<SubjectName, ExamSubject>> records = examService.getStudentExamRecords(student);
			user.printEachStudentExamRecords(student, records);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
	public void eachExamTypeExamRecordControl() {
		eachExamType();
	}
	
	private void eachExamType() {
		SearchStudent search = user.searchStudent();
		Status status = studentService.previewStudent(search.getGrade(), search.getName(), search.getParent());
		switch (status) {
		case EXIST:
			Student student = studentService.getStudent(search.getGrade(), search.getName(), search.getParent());
			ExamType type = user.askExamType();
			Map<SubjectName, ExamSubject> record = examService.getStudentExamRecord(student, type);
			user.printEachExamTypeExamRecord(student, type, record);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
}
