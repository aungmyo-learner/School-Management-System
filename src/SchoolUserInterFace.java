

import java.util.Scanner;

public class SchoolUserInterFace {
	private final Scanner sc;

	public SchoolUserInterFace(Scanner sc) {
		this.sc = sc;
	}
	public Menu askChoiceMenu() {
		while (true) {
			char ch = readInputChar("This School is basic education high school in Myanmar Country."
					+ "\nEnter\n1.Enroll\n2.Expel\n3.View\n4.Exit");
			Menu menu = Menu.menu(ch);
			if(menu != null) return menu;
		}
	}
	
	public Kind askKind() {
		while (true) {
			char ch = readInputChar("Enter\n1.Record\n2.Report\n3.Exit");
			Kind kind = Kind.choice(ch);
			if(kind != null) return kind;
		}
	}

	public EntityType askEnrol() {
		while (true) {
			char ch = readInputChar("Enter\n1.Teacher\n2.Student\n3.Clerk"
					+ "\n4.Exam Record\n5.Exit");
			EntityType type = MenuMapper.forEnrol(ch);
			if(type != null) return type;
		}
	}
	
	public EntityType askExpel() {
		while (true) {
			char ch = readInputChar("Enter\n1.Teacher\n2.Student\n3.Clerk"
					+ "\n4.Exam Record\n5.Exam Type Exam Record\n6.Exit");
			EntityType type = MenuMapper.forGeneral(ch);
			if(type != null) return type;
		}
	}
	
	public EntityType askViewManage() {
		while (true) {
			char ch = readInputChar("Enter\n1.Teacher\n2.Student\n3.Clerk"
					+ "\n4.Exam Record\n5.Exam Type Exam Record\n6.Exit");
			EntityType type = MenuMapper.forGeneral(ch);
			if(type != null) return type;
		}
	}
	
	public ReportType askReport() {
		while (true) {
			char ch = readInputChar("Enter"
					+ "\n1.Student Performance\n2.Exam Type Student Performance\n3.Teacher Performance"
					+ "\n4.Exam Type Teacher Performance\n5.Grade Student Performance\n6.Exam Type Grade Student Performance"
					+ "\n7.Grade Teacher Performance\n8.Exam Type Grade Teacher Performance\n9.Exit");
			ReportType type = MenuMapper.forView(ch);
			if(type != null)return type;
		}
	}
	
	public View askGeneralView() {
		while(true) {
			char ch = readInputChar("Enter\n1.All\n2.A Grade\n3.Each\n4.Exit");
			View view = EntityViewMapper.forGeneral(ch);
			if (view != null) return view;
		}
	}
	
	public View askClerkView() {
		while (true) {
			char ch = readInputChar("Enter\n1.All\n2.Each\n3.Exit");
			View view = EntityViewMapper.forClerk(ch);
			if(view != null) return view;
		}
	}
	public View askPersonPerformancesView() {
		while (true) {
			char ch = readInputChar("Enter\n1.All\n2.A Grade\n3.Each\n4.Exit");
			View view = ReportViewMapper.forPersonPeformance(ch);
			if(view != null) return view;
		}
	}
	
	public View askGradePerformancesView() {
		while (true) {
			char ch = readInputChar("Enter"
					+ "\n1.All\n2.A Grade");
			View view = ReportViewMapper.forGradePeformance(ch);
			if(view != null) return view;
		}
	}

	public Answer askOverallPerformance() {
		while (true) {
			char ch = readInputChar("Do you want to see overall performance"
					+ "\n1.Yes 2.No");
			Answer answer = Answer.askDo(ch);
			if (answer != null) return answer;
		}
	}
	
	public EntityType askChoice() {
		while (true) {
			char ch = readInputChar("1.Teacher 2.Student");
			EntityType type = MenuMapper.forOverall(ch);
			if(type != null) return type;
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

