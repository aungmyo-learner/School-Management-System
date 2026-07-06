

import java.util.Map;

public class ExamRecord {
	private final Student student;
	private final ExamType type;
	private final Map<SubjectName, ExamSubject> subjects;
	
	public ExamRecord(Student student, ExamType type, Map<SubjectName, ExamSubject> subjects) {
		this.student = student;
		this.type = type;
		this.subjects = subjects;
	}

	public Student getStudent() {
		return student;
	}
	
	public ExamType getType() {
		return type;
	}
	public Map<SubjectName, ExamSubject> getSubjects() {
		return subjects;
	}
	
}
