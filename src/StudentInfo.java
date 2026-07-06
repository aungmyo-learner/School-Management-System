

public class StudentInfo {
	private final String name;
	private final String parent;
	private final CurriculumGrade grade;
	private final ExamType examtype;
	
	public StudentInfo(String name, String parent, CurriculumGrade grade, ExamType examtype) {
		this.name = name;
		this.parent = parent;
		this.grade = grade;
		this.examtype = examtype;
	}
	
	public ExamType getExamtype() {
		return examtype;
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
