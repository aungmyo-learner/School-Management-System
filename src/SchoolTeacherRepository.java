

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SchoolTeacherRepository {
	private Map<CurriculumGrade, Set<Teacher>> teachers = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
	
	public Map<CurriculumGrade, Set<Teacher>> getTeachers(){
		
		Map<CurriculumGrade, Set<Teacher>> copy = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var entry : this.teachers.entrySet()) {
			
			Set<Teacher> teachers = new TreeSet<>(SchoolComparators.TEACHER);
			teachers.addAll(entry.getValue());
			
			CurriculumGrade grade = entry.getKey();
			
			copy.put(grade, Collections.unmodifiableSet(teachers));
		}
		return Collections.unmodifiableMap(copy);
	}
	
	public void enrollTeacher(Teacher teacher) {
		teachers.computeIfAbsent(teacher.getGrade(), g -> new TreeSet<>(SchoolComparators.TEACHER)).add(teacher);
	}
	
	public void expelTeacher(CurriculumGrade grade, String name) {
		Set<Teacher> teachers = this.teachers.get(grade);
		if(teachers != null) {
			teachers.removeIf(teacher -> teacher.getName().equalsIgnoreCase(name));
		}
	}
	
	public Set<Teacher> getTeachersFromAGrade(CurriculumGrade grade){
		return teachers.containsKey(grade)? Set.copyOf(teachers.get(grade)): Set.of();
	}
	
	public Teacher findTeacher(CurriculumGrade grade, String name) {
		Set<Teacher> teachersInGrade = teachers.get(grade);
		if (teachersInGrade == null) {
	        return null;
	    }
		Teacher teacher = null;
		for (Teacher t : teachersInGrade) {
			if(t.getName().equalsIgnoreCase(name)) {
				teacher =t;
				break;
			}
		}
		return teacher;
	}	
}
