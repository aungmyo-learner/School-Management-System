

import java.util.Map;
import java.util.Set;

public class SchoolTeacherService {
	private final SchoolTeacherRepository repository;
	private final SchoolCurriculum curriculum;
	public SchoolTeacherService(SchoolTeacherRepository repository, SchoolCurriculum curriculum) {
		this.repository = repository;
		this.curriculum = curriculum;
	}
	public Set<SubjectName> getSubjects(CurriculumGrade grade) {
		return curriculum.getSubjectsByGrade(grade);
	}
	public Status previewTeacher(String name, CurriculumGrade grade) {
		return state(name, grade);
	}
	private Status state(String name, CurriculumGrade grade) {
		Status status = null;
		Teacher teacher = repository.findTeacher(grade, name);
		if(teacher == null) {
			status = Status.NOT_EXST;
		}else {
			status = Status.EXIST;
		}
		return status;
	}
	public void enrollTeacher(TeacherInfo info) {
		Teacher teacher = new Teacher(info.getName(), info.getSubject(), info.getGrade());
		repository.enrollTeacher(teacher);
	}
	
	public void expelTeacher(Teacher teacher) {
		repository.expelTeacher(teacher.getGrade(), teacher.getName());
	}
	public Map<CurriculumGrade, Set<Teacher>> getByGrade(){
		return repository.getTeachers();
	}
	public Set<Teacher> getAGrade(CurriculumGrade grade) {
		return repository.getTeachersFromAGrade(grade);
	}
	public Teacher getTeacher(String name, CurriculumGrade grade) {
		return repository.findTeacher(grade, name);
	}
}
