

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SchoolStudentPerformanceInterFace {
	private final Scanner sc;
	public SchoolStudentPerformanceInterFace(Scanner sc) {
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

	public SearchStudent searchStudent() {
		String name = readInputString("Enter your name..");
		String parent = readInputString("Enter your parent..");
		CurriculumGrade grade = askCurriculumGrade();
		return new SearchStudent(name, parent, grade);
	}

	public void exist() {
		System.out.println("This person is already exist");
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

	public ExamType askExamType() {
		while(true) {
			int num = readInputInt("1.Initial\n2.Middle\n3.Final");
			ExamType type = ExamType.forType(num);
			if(type != null) return type;
		}
	}
	
	public void printStudentPerformances(Map<CurriculumGrade,
			Map<ExamType, Set<StudentPerformance>>> performancesByGrade) {
		
		System.out.println("Student Perfomrances by grade....");
		performancesByGrade.forEach((CurriculumGrade grade, Map<ExamType, Set<StudentPerformance>> types)->{
			System.out.println(grade);
			
			types.forEach((ExamType type, Set<StudentPerformance> performances)->{
				System.out.println(type + " Exam.");
				
				performances.forEach(p-> System.out.println(p));
			});
		});
	}
	
	public void printExamTypeStudentPerformances(ExamType type,
			Map<CurriculumGrade, Set<StudentPerformance>> studentPerformances) {
		
		System.out.println(type + " Exam's Students Performances by grade...");
		studentPerformances.forEach((CurriculumGrade grade, Set<StudentPerformance> performances)-> {
			System.out.println(grade);
			
			performances.forEach(p-> System.out.println(p));
		});
	}

	public void printStudentPerformancesOfGrade(CurriculumGrade grade, Map<ExamType,
			Set<StudentPerformance>> performances) {
		System.out.println(grade + "'s Student Performances...");
		
		performances.forEach((ExamType type, Set<StudentPerformance> performance)->{
			System.out.println(type + " Exam.");
			
			performance.forEach(p->System.out.println(p));
		});
	}
	
	public void printExamTypeStudentPerformancesOfGrade(CurriculumGrade grade, ExamType type,
			Set<StudentPerformance> performances) {
		
		System.out.println(grade);
		System.out.println(type + " Exam");
		
		performances.forEach(p ->{
			System.out.println(p);
			
			if(!p.getDistinctions().isEmpty()) {
				System.out.println("Distinction...");
				
				p.getDistinctions().forEach(d-> System.out.println(d));
			}
		});
	}

	public void printEacheStudentPerformances(Student student, Map<ExamType, StudentPerformance> performances) {		
		performances.forEach((ExamType type, StudentPerformance performance)->{
			System.out.println(type + " Exam");
			System.out.println(performance);
		});
		
	}
	
	public void printEachExamTypeStudentPerformance(Student student, ExamType type, StudentPerformance performance) {
		System.out.println(student);
		System.out.println(type + "Exam Student Performance.");
		System.out.println(performance);
		if (!performance.getDistinctions().isEmpty()) {
			performance.getDistinctions().forEach(d->System.out.println(d));
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

}
