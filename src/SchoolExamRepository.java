

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SchoolExamRepository {
	private Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> examRecords = new TreeMap<>(SchoolComparators.STUDENT_BY_NAME);
	
	public void enrolRecord(Student student, ExamType type, Map<SubjectName, ExamSubject> subjects) {
		  Map<SubjectName, ExamSubject> sortedSubjects =
		            new TreeMap<>(SchoolComparators.SUBJECTS);

		    sortedSubjects.putAll(subjects);
		examRecords.computeIfAbsent(student, s -> new TreeMap<>(SchoolComparators.EXAM_TYPE)).put(type, sortedSubjects);
	}
	
	public void expelExamRecords(Student student) {
		expel(student);
	}
	
	private void expel(Student student) {
		if(examRecords.containsKey(student)) examRecords.remove(student);		
	}
	
	public void expelExamTypeRecord(Student student, ExamType type) {
		expelExamTypeExamRecord(student, type);
	}
	
	private void expelExamTypeExamRecord(Student student, ExamType type) {
		if(examRecords.get(student).containsKey(type)) examRecords.get(student).remove(type);
	}
	
	public Map<CurriculumGrade, Map<Student,
	Map<ExamType, Map<SubjectName, ExamSubject>>>> getExamRecordsByGrade(){
		return examRecordsByGrade();
	}
	
	private Map<CurriculumGrade, Map<Student,
	Map<ExamType, Map<SubjectName, ExamSubject>>>> examRecordsByGrade(){
		
		if (examRecords.isEmpty()) {
			return Map.of();
		}
		
		Map<CurriculumGrade, Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>>> byGrade =
				new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (Student student : examRecords.keySet()) {
			CurriculumGrade grade = student.getGrade();
						
			Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> students =  
					byGrade
					.computeIfAbsent(grade,
					g -> new TreeMap<>(SchoolComparators.STUDENT_BY_NAME)
            );
			
			Map<ExamType, Map<SubjectName, ExamSubject>> records = new TreeMap<>(SchoolComparators.EXAM_TYPE);
			
			for (var entry  : examRecords.get(student).entrySet()) {
				Map<SubjectName, ExamSubject> subjects = new TreeMap<>(SchoolComparators.SUBJECTS);
				
				ExamType type  = entry.getKey();
				subjects.putAll(entry.getValue());
				records.put(type, Collections.unmodifiableMap(subjects));
			}
			students.put(student, Collections.unmodifiableMap(records));
		}
		return  Collections.unmodifiableMap(byGrade);
	}
	
	public Map<CurriculumGrade, Map<Student, Map<SubjectName, ExamSubject>>> getExamTypeExamRecordsByGrade(ExamType type){
		return examTypeExamRecordsByGrade(type);
	}
	
	private Map<CurriculumGrade, Map<Student, Map<SubjectName, ExamSubject>>> examTypeExamRecordsByGrade(ExamType type){

		if (examRecords.isEmpty()) {
			return Map.of();
		}
		
		Map<CurriculumGrade, Map<Student, Map<SubjectName, ExamSubject>>> byGrade =
				new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var student : examRecords.entrySet()) {
			CurriculumGrade grade = student.getKey().getGrade();
			Map<Student, Map<SubjectName, ExamSubject>> record = byGrade
					.computeIfAbsent(grade, g -> new TreeMap<>(SchoolComparators.STUDENT_BY_NAME));
			for (var typeEntry : student.getValue().entrySet()) {
				if (type == typeEntry.getKey()) {
					Map<SubjectName, ExamSubject> subjects = new TreeMap<>(SchoolComparators.SUBJECTS);
					subjects.putAll(typeEntry.getValue());
					record.put(student.getKey(), Collections.unmodifiableMap(subjects));
				}
			}
		}
		
		return Collections.unmodifiableMap(byGrade);
	}

	public Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> getExamRecordsOfAGrade(CurriculumGrade grade) {
		return gradeExamRecords(grade);
	}
	
	private Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> gradeExamRecords(CurriculumGrade grade) {
		
		if (examRecords.isEmpty()) {
			return Map.of();
		}
		
		Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> students = new TreeMap<>(SchoolComparators.STUDENT_BY_NAME);
		
		for (var studentEntry : examRecords.entrySet()) {
			Student student = studentEntry.getKey();
			if(student.getGrade().equals(grade)) {
				Map<ExamType, Map<SubjectName, ExamSubject>> records = new TreeMap<>(SchoolComparators.EXAM_TYPE);
				
				for (var typeEntry : studentEntry.getValue().entrySet()) {
					Map<SubjectName, ExamSubject> subjects = new TreeMap<>(SchoolComparators.SUBJECTS);
					
					ExamType type  = typeEntry.getKey();					
					subjects.putAll(typeEntry.getValue());
					records.put(type, Collections.unmodifiableMap(subjects));
				}
				students.put(student, Collections.unmodifiableMap(records));
			}
		}
		return Collections.unmodifiableMap(students);
	}
	
	public Map<Student, Map<SubjectName, ExamSubject>> getGradeExamTypeExamRecord(CurriculumGrade grade, ExamType type){
		return gradeExamTypeExamRecord(grade, type);
	}
	
	private Map<Student, Map<SubjectName, ExamSubject>> gradeExamTypeExamRecord(CurriculumGrade grade, ExamType type){

		if (examRecords.isEmpty()) {
			return Map.of();
		}
		
		Map<Student, Map<SubjectName, ExamSubject>> students = new TreeMap<>(SchoolComparators.STUDENT_BY_NAME);
		
		for (var student : examRecords.entrySet()) {
			if (student.getKey().getGrade().equals(grade) && student.getValue().containsKey(type)) {
				Map<SubjectName, ExamSubject> record = student.getValue().get(type);
				students.put(student.getKey(), Collections.unmodifiableMap(record));
			}else {
				students.put(student.getKey(), Map.of());
			}
		}
		return Collections.unmodifiableMap(students);
	}
	public Map<ExamType, Map<SubjectName, ExamSubject>> getStudentExamRecords(Student student) {
		return studentExamRecords(student);
	}
	
	private Map<ExamType, Map<SubjectName, ExamSubject>> studentExamRecords(Student student) {
		Map<ExamType,Map<SubjectName, ExamSubject>> studentRecords = examRecords.get(student);

		if (studentRecords == null) {
			return Map.of();
		}
		
		Map<ExamType, Map<SubjectName, ExamSubject>> records = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		
		for (var entry : studentRecords.entrySet()) {
			Map<SubjectName, ExamSubject> subjects = new TreeMap<>(SchoolComparators.SUBJECTS);
			
			ExamType type  = entry.getKey();
			if (entry.getValue().isEmpty()) {
				subjects.putAll(Map.of());
			}else {
				subjects.putAll(entry.getValue());
			}
			
			records.put(type, Collections.unmodifiableMap(subjects));
		}
		
		return Collections.unmodifiableMap(records);
	}
	
	public Map<SubjectName, ExamSubject> getExamRecord(Student student, ExamType type){
		return examRecord(student, type);
	}
	
	private Map<SubjectName, ExamSubject> examRecord(Student student, ExamType type){
		Map<SubjectName, ExamSubject> subjects = new TreeMap<>(SchoolComparators.SUBJECTS);
		subjects.putAll(examRecords.get(student).getOrDefault(type, Map.of()));
		return Collections.unmodifiableMap(subjects);
	}
	
}
