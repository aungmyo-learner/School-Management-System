

import java.util.Scanner;

public class SchoolOverallStudentPerformanceInterFace { 
	private final Scanner sc;

	public SchoolOverallStudentPerformanceInterFace(Scanner sc) {
		this.sc = sc;
	}
	
	public Answer askOnlyOverallResult() {
		while (true) {
			char ch = readInputChar("Only overall Result\n1.Yes 2.No");
			Answer answer = Answer.askDo(ch);
			if(answer != null) return answer;
		}
	}
	
	public void printOverallSummary(OverallStudentPerformanceSummary summary) {
		System.out.println(summary);
	}
	
	public Answer askOnlyExamTypeOverallResult() {
		while (true) {
			char ch = readInputChar("Only one Exam Type Result\n1.Yes 2.No");
			Answer answer = Answer.askDo(ch);
			if(answer != null) return answer;
		}
	}

	public ExamType askExamType() {
		while(true) {
			int num = readInputInt("1.Initial\n2.Middle\n3.Final");
			ExamType type = ExamType.forType(num);
			if(type != null) return type;
		}
	}

	public void printExamTypeOverallPerformance(OverallStudentPerformance performance) {
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
