

import java.util.Map;
import java.util.Scanner;

public class SchoolGradeTeacherPerformanceInterFace {
	private final Scanner sc;

	public SchoolGradeTeacherPerformanceInterFace(Scanner sc) {
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

	public void notExist() {
		System.out.println("Not exist.");
	}

	public ExamType askExamType() {
		while(true) {
			int num = readInputInt("1.Initial\n2.Middle\n3.Final");
			ExamType type = ExamType.forType(num);
			if(type != null) return type;
		}
	}

	public void printGradeTeacherPerformancesReport(Map<CurriculumGrade, GradeTeacherPerformance> performances) {
		
		if (performances.isEmpty()) {
			System.out.println("haven't grade teacher performances!");
		}else {
			performances.forEach((CurriculumGrade grade,
					GradeTeacherPerformance performance)->System.out.println(performance));
		}
	}
	
	public void printExamTypeGradeTeacherPerformanceReport(ExamType type,
			Map<CurriculumGrade, TeacherExamDetail> details) {
		
		if (details.isEmpty()) {
			System.out.println("haven't grade teacher performances for " + type + " Exam!");
		}else {

			System.out.println(type + "Exam's Grade Teacher Performances by grade");
			
			details.forEach((CurriculumGrade grade, TeacherExamDetail detail)->{
					System.out.println("Grade: " + grade);
					System.out.println(detail);
				});
		}
	}

	public void printGradeTeacherPerformanceOfGrade(CurriculumGrade grade, GradeTeacherPerformance performance) {
		
		if (performance == null) {
			System.out.println("haven't grade teacher performance in " + grade);
		}else {
			System.out.println(grade);
			performance.getDetails().forEach((ExamType type, TeacherExamDetail detail)->{
				System.out.println(type + " Exam..");
				
				System.out.println(detail);
			});
			System.out.println(performance);
		}
	}
	
	public void printExamTypeGradeTeacherPerformanceOfGrade(CurriculumGrade grade, ExamType type,
			TeacherExamDetail detail) {
		
		if (detail == null) {
			System.out.println("haven't grade teacher performances of grade this " + type + " Exam.");
		}else {
			System.out.println(grade);
			System.out.println(type + " Exam");
			System.out.println(detail);
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
	
}
