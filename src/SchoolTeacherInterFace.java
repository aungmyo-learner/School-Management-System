

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SchoolTeacherInterFace {
	private final Scanner sc;
	
	public SchoolTeacherInterFace(Scanner sc) {
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
	
	public TeacherInfo askEnrollTeacherInformation(CurriculumGrade grade, Set<SubjectName> subjects) {
		String name = readInputString("Enter your name.");
		while (true) {
			SubjectName subject = null;
			Set<Integer> numbers = new TreeSet<>();
			for (SubjectName subjectName : subjects) {
				System.out.println(subjectName.getOrder() + ". " + subjectName);
				numbers.add(subjectName.getOrder());
			}
			int num = readInputInt("Choice one subject..");
			for (Integer integer : numbers) {
				if(integer == num) {
					subject  = SubjectName.forSubjectName(num);
					break;
				}
			}
			if (subject != null) return new TeacherInfo(name, subject, grade);
		}
	}
	
	public void exist() {
		System.out.println("This person is already exist");
	}
	
	public void notExist() {
		System.out.println("This person is not exist.");
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

	public SearchTeacher searchTeacher() {
		String name = readInputString("Enter name.");
		CurriculumGrade grade = askCurriculumGrade();
		return new SearchTeacher(name, grade);
	}

	public void printTeachers(Map<CurriculumGrade, Set<Teacher>> teachers) {
		
		teachers.forEach((CurriculumGrade grade, Set<Teacher> teacher)-> {
			System.out.println(grade);
			teacher.forEach(t-> System.out.println(t));
		});
	}

	public void printTeachersOfGrade(CurriculumGrade grade, Set<Teacher> teachers) {
		System.out.println(grade + " Teachers.");
		teachers.forEach(t->System.out.println(t));
	}

	public void printTeacher(Teacher teacher) {
		System.out.println(teacher);
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
