

public class SearchTeacher {
	private final String name;
	private final CurriculumGrade grade;
	public SearchTeacher(String name, CurriculumGrade grade) {
		this.name = name;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public CurriculumGrade getGrade() {
		return grade;
	}
}
