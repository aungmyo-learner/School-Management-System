

public class Clerk {
	private final String name;
    private final String role;
	public Clerk(String name, String role) {
		this.name = name;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String toString() {
		return "Name: " + name +
				"\nRole: " + role;
	}
}
