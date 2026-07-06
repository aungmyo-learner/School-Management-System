

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	private final String name;
	private final String parent;
	private final CurriculumGrade grade;
	private final Set<SubjectName> subjects;
	
	public Student(String name, String parent, CurriculumGrade grade, Set<SubjectName> subjects) {
		this.name = name;
		this.parent = parent;
		this.grade = grade;
		this.subjects = subjects;
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
	
	public Set<SubjectName> getSubjects() {
		return Collections.unmodifiableSet(subjects);
	}
	
	public void assignSubjects(Set<SubjectName> subjects) {
		if(!this.subjects.isEmpty()) return;
		
		if(subjects != null) {
			Set<SubjectName> copy = new TreeSet<>(SchoolComparators.SUBJECTS);
			copy.addAll(subjects);
			this.subjects.addAll(copy);
		}
	}
	public String toString() {
		return "Student Name: " + name + "\nParent name: " + parent + "\nStudent grade: " + grade;
	}
}
