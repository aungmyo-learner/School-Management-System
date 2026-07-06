

import java.util.Map;
import java.util.Scanner;

public class SchoolGradeStudentPerformanceInterFace {
	private final Scanner sc;

	public SchoolGradeStudentPerformanceInterFace(Scanner sc) {
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

	public ExamType askExamType() {
		while(true) {
			int num = readInputInt("1.Initial\n2.Middle\n3.Final");
			ExamType type = ExamType.forType(num);
			if(type != null) return type;
		}
	}
	
	public void printGradePerformancesReport(Map<CurriculumGrade, GradeStudentsPerformance> gradePerformance ) {
		
		if (gradePerformance.isEmpty()) {
			System.out.println("haven't performance");
		}else {

			System.out.println("Grade Performance report by grade...");
			
			gradePerformance.forEach((CurriculumGrade grade, GradeStudentsPerformance g)->System.out.println(g));
		}
	}
	
	public void printExamTypeGradePerformancesReport(ExamType type, Map<CurriculumGrade,
			ExamStudentsPerformanceResult> performances) {
		if (performances.isEmpty()) {

			System.out.println("haven't performance this" + type + " Exam!");
		}else {
			System.out.println(type + "'s Grade Performances report by grade...");
			
			performances.forEach((CurriculumGrade grade, ExamStudentsPerformanceResult result)->{
				System.out.println(result);
				
			});
		}
	}

	public void printGradePerformanceOfGrade(GradeStudentsPerformance performance) {
		if (performance == null) {
			System.out.println("haven't grade Performance this grade");
		}else {
			System.out.println(performance);
		}
		
	}
	
	public void printExamTypeGradePerformanceOfGrade(ExamType type, ExamStudentsPerformanceResult result) {
		if (result == null) {
			System.out.println("haven't grade performance this grade for" + type);
		}else {
			System.out.println(type + "Exam");
			System.out.println(result);
		}
		
	}

	public void notExist() {
		System.out.println("Not Exist.");
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
