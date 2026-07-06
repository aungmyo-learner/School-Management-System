

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class SchoolClerkRepository {
	private Set<Clerk> clerks = new TreeSet<>(SchoolComparators.CLERK_BY_NAME);
	
	public Set<Clerk> getClerks() {
		return Collections.unmodifiableSet(clerks);
	}
	public void enrollClerk(Clerk clerk) {
		clerks.add(clerk);
	}	
	public void expellClerk(Clerk clerk) {
		clerks.remove(clerk);
	}
	
	public Clerk findClerk(String name, String role) {
		Clerk clerk = null;
		for (Clerk c : clerks) {
			if(c.getName().equalsIgnoreCase(name) && c.getRole().equalsIgnoreCase(role)) {
				clerk = c;
				break;
			}
		}
		return clerk;
	}
}
