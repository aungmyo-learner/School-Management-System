

import java.util.Map;
import java.util.Set;

public class SchoolTeacherController {
	private final SchoolTeacherService teacherService;
	private final SchoolTeacherInterFace user;
	
	public SchoolTeacherController(SchoolTeacherService teacherService, SchoolTeacherInterFace user) {
		this.teacherService = teacherService;
		this.user = user;
	}

	public void enrollControl() {
		enroll();
	}
	
	private void enroll() {
		CurriculumGrade grade = user.askCurriculumGrade();
		Set<SubjectName> subjects = teacherService.getSubjects(grade);
		TeacherInfo info = user.askEnrollTeacherInformation(grade, subjects);
		Status status = teacherService.previewTeacher(info.getName(),info.getGrade());
		switch (status) {
		case EXIST:
			user.exist();
			break;
		case NOT_EXST:
			teacherService.enrollTeacher(info);
		}
	}
	
	public void expelControl() {
		expel();
	}
	
	private void expel() {
		SearchTeacher search = user.searchTeacher();
		Status status = teacherService.previewTeacher(search.getName(), search.getGrade());
		switch (status) {
		case  EXIST:
			Teacher teacher = teacherService.getTeacher(search.getName(), search.getGrade());
			teacherService.expelTeacher(teacher);
			break;
		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
	public void allTeacherControl() {
		all();
	}
	
	private void all() {
		Map<CurriculumGrade, Set<Teacher>> teachers = teacherService.getByGrade();
		user.printTeachers(teachers);
	}
	
	public void gradeTeacherControl() {
		grade();
	}

	private void grade() {
		CurriculumGrade grade = user.askCurriculumGrade();
		Set<Teacher> teachers = teacherService.getAGrade(grade);
		user.printTeachersOfGrade(grade, teachers);
	}
	
	public void eachTeacherControl() {
		each();
	}
	
	private void each() {
		SearchTeacher search = user.searchTeacher();
		Status status = teacherService.previewTeacher(search.getName(), search.getGrade());
		switch (status) {
		case EXIST:
			Teacher teacher = teacherService.getTeacher(search.getName(), search.getGrade());
			user.printTeacher(teacher);
			break;
		case NOT_EXST:
			user.notExist();
		}
	}
	
}
