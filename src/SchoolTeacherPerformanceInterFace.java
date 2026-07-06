

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SchoolTeacherPerformanceInterFace {
	private final Scanner sc;
	public SchoolTeacherPerformanceInterFace(Scanner sc) {
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
	
	public void printTeacherPerformances(Map<CurriculumGrade, Map<ExamType, Set<TeacherPerformance>>> teacherPerformances) {
		
		System.out.println("Teacher Performances by grade...");
		
		teacherPerformances.forEach((CurriculumGrade grade, Map<ExamType, Set<TeacherPerformance>> types)->{
			System.out.println(grade);
			
			types.forEach((ExamType type, Set<TeacherPerformance> performacnes)->{
				System.out.println(type + " Exam.");
				
				performacnes.forEach(p-> System.out.println(p));
			});
		});
	}

	public ExamType askExamType() {
		while(true) {
			int num = readInputInt("1.Initial\n2.Middle\n3.Final");
			ExamType type = ExamType.forType(num);
			if(type != null) return type;
		}
	}

	public SearchTeacher searchTeacher() {
		String name = readInputString("Enter name.");
		CurriculumGrade grade = askCurriculumGrade();
		return new SearchTeacher(name, grade);
	}

	public void exist() {
		System.out.println("This person is already exist");
	}
	
	public void notExist() {
		System.out.println("This person is not exist.");
	}
	
	public void printExamTypeTeacherPerformances(ExamType type, Map<CurriculumGrade, 
			Set<TeacherPerformance>> performances) {
		System.out.println(type + " Exam's Teacher Performances by grade...");
		for (var grade : performances.entrySet()) {
			System.out.println(grade);
			for (TeacherPerformance performance : grade.getValue()) {
				System.out.println(performance);
			}
		}
	}

	public void printTeacherPerformancesOfGrade(CurriculumGrade grade,
			Map<ExamType, Set<TeacherPerformance>> performances) {
		System.out.println(grade + "performances of teachers");
		
		performances.forEach((ExamType type, Set<TeacherPerformance> performance)->{
			System.out.println(type + " Exam");
			
			performance.forEach((p-> System.out.println(p)));
		});
	}
	
	public void printExamTypeTeacherPerfomrancesOfGrade(ExamType type, Set<TeacherPerformance> performances) {
		System.out.println(type + " Exam Teacher Performances of grade");
		performances.forEach(p->System.out.println(p));
	}

	public void printEachTeacherPerformances(Teacher teacher, Map<ExamType, TeacherPerformance> performances) {
		
		System.out.println(teacher);

		performances.forEach((ExamType type, TeacherPerformance performance)->{
			System.out.println(type + " Exam");
			
			System.out.println(performance);
		});
		
	}
	
	public void printEachExamTypeTeacherPerformance(ExamType type, TeacherPerformance performance) {
		System.out.println(type);
		System.out.println(performance);
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
