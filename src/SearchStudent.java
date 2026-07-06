

public class SearchStudent {
	private final String name;
	private final String parent;
	private final CurriculumGrade grade;
	public SearchStudent(String name, String parent, CurriculumGrade grade) {
		this.name = name;
		this.parent = parent;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public String getParent() {
		return parent;
	}
	public CurriculumGrade getGrade() {
		return grade;
	}
}
