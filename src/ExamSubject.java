

public class ExamSubject {
	private final SubjectName name;
	private final int mark;
	
	public ExamSubject(SubjectName name, int mark) {
		this.name = name;
		this.mark = mark;
	}
	
	public SubjectName getName() {
		return name;
	}
	
	public int getMark() {
		return mark;
	}
	
	public boolean isPass() {
		return mark >= 40;
	}
	
	public boolean determineDistinction(CurriculumGrade grade) {
		if(isBelowHighSchool(grade.getGrade())) {
			return mark>=80;
		}
		return hasHighSchoolDistinction();
	}
	
	private boolean hasHighSchoolDistinction() {
		boolean isSubject = name == SubjectName.MYANMAR || name == SubjectName.ENGLISH;
				return (isSubject && mark >=75) || (!isSubject && mark >= 80);
	}
	
	private boolean isBelowHighSchool(Grades grade) {
		return grade.getOrder() <=9;
	}
	
	public String toString() {
		return "Subject: " + name +
				"\nMark: " + mark;
	}
}
