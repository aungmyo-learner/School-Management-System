

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SchoolStudentInterFace {
	private final Scanner sc;

	public SchoolStudentInterFace(Scanner sc) {
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
	
	public void successEnrol() {
		System.out.println("Success Enrol.");
	}
	
	public void successExpel() {
		System.out.println("Success Expel.");
	}
	
	public void notExist() {
		System.out.println("This person is not exist.");
	}
	
	public StudentInfo askEnrollForStudent() {
		String name = readInputString("Enter your name..");
		String parent = readInputString("Enter your parent..");
		CurriculumGrade grade = askCurriculumGrade();
		ExamType type = ExamType.ENROLL;
		return new StudentInfo(name, parent, grade, type);
	}

	public SearchStudent searchStudent() {
		String name = readInputString("Enter your name..");
		String parent = readInputString("Enter your parent..");
		CurriculumGrade grade = askCurriculumGrade();
		return new SearchStudent(name, parent, grade);
	}

	public void printStudents(Map<CurriculumGrade, Set<Student>> students) {
		
		students.forEach((CurriculumGrade grade, Set<Student> student)->{
			System.out.println(grade);
			
			student.forEach(s-> System.out.println(s));
		});
	}

	public void printStudentsOfGrade(CurriculumGrade grade, Set<Student> students) {
		System.out.println(grade + " Students..");
		students.forEach(s->System.out.println(s));
	}

	public void printStudent(Student student) {
		System.out.println(student);
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

}
