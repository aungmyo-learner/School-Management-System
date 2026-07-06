

import java.util.Scanner;
import java.util.Set;

public class SchoolClerkInterFace {
	private final Scanner sc;

	public SchoolClerkInterFace(Scanner sc) {
		this.sc = sc;
	}

	public ClerkInfo askEnrollForClerk() {
		
		String name = readInputString("Enter name");
		String role = readInputString("Enter Role");
		
		return new ClerkInfo(name, role);
	}

	public SearchClerk searchClerk() {
		String name = readInputString("Enter name.");
		String role = readInputString("Enter role");
		return new SearchClerk(name, role);
	}

	public void printClerks(Set<Clerk> clerks) {
		if (clerks.isEmpty()) {
			System.out.println("Haven't any clerk!");
		}else {
			clerks.forEach(c -> System.out.println(c));
		}
	}

	public void printClerk(Clerk clerk) {
		if (clerk == null) {
			System.out.println("Hasn't clerk!");
		}else {
			System.out.println(clerk);
		}
	}

	public void exist() {
		System.out.println("This person is already exist");
	}
	
	public void notExist() {
		System.out.println("This person is not exist.");
	}
	
	public void successEnrol() {
		System.out.println("Success Enrol!");
	}
	
	public void successExpel() {
		System.out.println("Success Expel!");
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
