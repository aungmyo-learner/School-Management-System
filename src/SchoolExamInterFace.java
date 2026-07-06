

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SchoolExamInterFace {
	private final Scanner sc;

	public SchoolExamInterFace(Scanner sc) {
		this.sc = sc;
	}

	public CurriculumGrade askCurriculumGrade() {
		while (true) {
			 int gradeOrder =0;
			 Grades g = null;
			 while (true) {
				 gradeOrder = readInputInt("Enter Grade"
							+ "\n1.Grade 1\n2.Grade 2\n3.Grade 3\n4.Grade 4\n5.Grade 5\n6.Grade 6"
							+ "\n7.Grade 7\n8.Grade 8\n9.Grade 9\n10.Grade 10\n11.Grade 11\n12.Grade 12");
				 g = Grades.forGrade(gradeOrder);
				 if (g != null)break;
			}
			Stream stream = null;
			if(!g.requiresStream(gradeOrder)) {
				stream = Stream.NONE;
			}else {
				while(true) {
					int streamOrder = readInputInt("Enter Stream" + "\n1.SCIENCE\n2.ART");
					stream = Stream.getStream(streamOrder);
					if(stream != null) break;
				}
			}
			CurriculumGrade grade = new CurriculumGrade(g, stream);
			if(grade != null) return grade;
		}
	}

	public void exist() {
		System.out.println("This person is already exist");
	}
	
	public void notExist() {
		System.out.println("This person is not exist.");
	}

	public SearchStudent searchStudent() {
		String name = readInputString("Enter your name..");
		String parent = readInputString("Enter your parent..");
		CurriculumGrade grade = askCurriculumGrade();
		return new SearchStudent(name, parent, grade);
	}

	public StudentInfo askEnrollForStudent() {
			String name = readInputString("Enter your name..");
			String parent = readInputString("Enter your parent..");
			CurriculumGrade grade = askCurriculumGrade();
			ExamType type = ExamType.ENROLL;
			return new StudentInfo(name, parent, grade, type);
	}
	
	public ExamRecord askForExamRecord(Student student, Set<SubjectName> names) {
		while(true) {
			Map<SubjectName, ExamSubject> subjects = new TreeMap<>(SchoolComparators.SUBJECTS);
			ExamType type = askExamType();
			for (SubjectName subjectName : names) {
				int mark =0;
				do {
					mark = readInputInt(subjectName + "'s Enter Mark");
				} while (mark < 0 || mark >100);
				ExamSubject subject = new ExamSubject(subjectName, mark);
				subjects.put(subjectName, subject);
			}
			if(subjects.size() == names.size())return new ExamRecord(student, type, subjects);
		}
	}
	
	public ExamType askExamType() {
		while(true) {
			int num = readInputInt("1.Initial\n2.Middle\n3.Final");
			ExamType type = ExamType.forType(num);
			if(type != null) return type;
		}
	}
	
	public Action actionForEnroll() {
		while (true) {
			char ch = readInputChar("1.Enroll\n2.Exit");
			Action action = Action.forEnroll(ch);
			if (action != null) return action;
		}
	}

	public void printExamRecords(Map<CurriculumGrade, Map<Student,
			Map<ExamType, Map<SubjectName, ExamSubject>>>> examRecords) {
		if (examRecords.isEmpty()) {
			System.out.println("Haven't exam records!");
		}else {

			examRecords.forEach((CurriculumGrade grade, Map<Student, Map<ExamType,
					Map<SubjectName, ExamSubject>>> students)-> {
				System.out.println(grade);
				
				students.forEach((Student student, Map<ExamType, Map<SubjectName, ExamSubject>> types)->{
					System.out.println(student);
					
					types.forEach((ExamType type, Map<SubjectName, ExamSubject> subjects)->{
						System.out.println(type + " Exam.");
						
						subjects.forEach((SubjectName name, ExamSubject subject)->System.out.println(subject)); 
					});
				});
			});
		}
	}
	
	public void printExamTypeExamRecords(ExamType type, Map<CurriculumGrade, 
			Map<Student, Map<SubjectName, ExamSubject>>> records) {
		if (records.isEmpty()) {
			System.out.println("haven't exam record for " + type + " Exam.");
		}else {
			System.out.println(type + " Exam.");
			
			records.forEach((CurriculumGrade grade, Map<Student,
					Map<SubjectName, ExamSubject>> students)-> {
						
					if (students.isEmpty()) {
						System.out.println("haven't exam record for " + grade);
					}else {
						System.out.println(grade);
						
						students.forEach((Student student, Map<SubjectName, ExamSubject> subjects)->{
							System.out.println(student);
							
							subjects.forEach((SubjectName name, ExamSubject subject)->System.out.println(subject)); 
						});
					}
				
			});
		}
	}

	public void printExamRecordOfGrade(CurriculumGrade grade, 
			Map<Student, Map<ExamType, Map<SubjectName, ExamSubject>>> records) {
		
		if (records.isEmpty()) {
			System.out.println("haven't exam records " + grade);
		}else {

			System.out.println(grade + " of  Exam Record.");
			records.forEach((Student student, Map<ExamType, Map<SubjectName, ExamSubject>> record) ->{
				
				if (record.isEmpty()) {
					System.out.println("haven't exam records for\n" + student);
				}else {
					System.out.println(student.getName());
					
					record.forEach((ExamType type, Map<SubjectName, ExamSubject> subjects) -> {
						if (subjects.isEmpty()) {
							System.out.println("haven't exam records for\n" + student);
						}else {
							System.out.println(type + " Exam.");
							
							subjects.forEach((SubjectName name, ExamSubject subject)
									-> System.out.println(subject));
						}
					});
					
				}
			});
		}
	}
	
	public void printExamTypeExamRecordsOfGrade(CurriculumGrade grade, ExamType type,
			Map<Student, Map<SubjectName, ExamSubject>> students) {
		
		if (students.isEmpty()) {
			System.out.println("haven't students this grade for " + type + "Exam");
		}else {
			System.out.println(grade);
			System.out.println(type + " Exam.");
			
			students.forEach((Student student, Map<SubjectName, ExamSubject> subjects)->{
				if (subjects.isEmpty()) {
					System.out.println("haven't exam records for thhis student");
				}else {
					System.out.println(student);
					
					subjects.forEach((SubjectName name, ExamSubject subject)-> System.out.println(subject));
				}
			});
			
		}
	}

	public void printEachStudentExamRecords(Student student, Map<ExamType, Map<SubjectName, ExamSubject>> records) {
		
		if (records.isEmpty()) {
			System.out.println("haven't exam records for this student" );
		}
		System.out.println(student.getName() + "'s " + " exam records.");
		
		records.forEach((ExamType type, Map<SubjectName, ExamSubject> subjects)->{
			System.out.println(type);
			
			subjects.forEach((SubjectName name, ExamSubject subject)-> System.out.println(subject));
		});
	}

	public void printEachExamTypeExamRecord(Student student, ExamType type, Map<SubjectName, ExamSubject> subjects) {
		
		if (subjects.isEmpty()) {
			System.out.println("haven't exam records for " + type + "Exam");
		}else {
			System.out.println(student);
			System.out.println(type + " Exam Record.");
			subjects.forEach((SubjectName name, ExamSubject subject)-> System.out.println(subject));
		}		
	}
	
	private int readInputInt(String message) {
		while (true) {
			System.out.println(message);
			try {
				int num = Integer.parseInt(sc.nextLine());
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a valid number.");
			}
		}
	}
	
	private String readInputString(String message) {
		while (true) {
			System.out.println(message);
			try {
				String s = sc.nextLine().trim();
				if(s.isBlank()) {
					throw new IllegalArgumentException("Input cannot be blank.");
				}
				return s;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid!");
			}
		}
	}

	private char readInputChar(String message) {
		while (true) {
			System.out.println(message);
			try {
				String s = sc.nextLine().trim();
				return s.charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Invalid input!");
			}
		}
	}

}
