

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SchoolStudentRepository {
	private Map<CurriculumGrade, Set<Student>> students = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
	
	public Map<CurriculumGrade, Set<Student>> getStudents() {
		Map<CurriculumGrade, Set<Student>> copy = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		 Set<Student> students = new TreeSet<>(SchoolComparators.STUDENT_BY_NAME);
		 
		 for (var entry : this.students.entrySet()) {
			CurriculumGrade grade = entry.getKey();
			
			students.addAll(entry.getValue());
			copy.put(grade, Collections.unmodifiableSet(students));
		}
		return Collections.unmodifiableMap(copy);
	}
	
	public void enrollStudent(CurriculumGrade grade, Student student) {
		students.computeIfAbsent(grade, g-> new TreeSet<>(SchoolComparators.STUDENT_BY_NAME)).add(student);
	}
	
	public void fireStudent(Student student) {			
		students.get(student.getGrade()).remove(student);
	}
	public void expelStudent(CurriculumGrade grade, String studentName,String parentName) {
		Set<Student> students = this.students.get(grade);
		students.removeIf(student -> student.getName().equalsIgnoreCase(studentName) && student.getParent().equalsIgnoreCase(parentName));
	}
	
	public Student findStudent(CurriculumGrade grade, String studentName,String parentName) {
		
		if(!students.isEmpty()) {
			Set<Student> studentsInGrade = students.get(grade);
			Student student = null;
			if(!studentsInGrade.isEmpty()) {
				for (Student s : studentsInGrade) {
					if(s.getName().equalsIgnoreCase(studentName) && s.getParent().equalsIgnoreCase(parentName)) {
						student = s;
						break;
					}
				}
				return student;
			}
		}
		return null;
	}
	public Set<Student> getStudentsFromAGrade(CurriculumGrade grade) {
		return students.containsKey(grade)? Set.copyOf(students.get(grade)): Set.of();
	}
}
