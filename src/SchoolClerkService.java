

import java.util.Set;

public class SchoolClerkService {
	private final SchoolClerkRepository repository;
	public SchoolClerkService(SchoolClerkRepository repository) {
		this.repository = repository;
	}

	private Status state(String name, String role) {
		Status status = null;
		Clerk clerk = repository.findClerk(name, role);
		if(clerk == null) {
			status = Status.NOT_EXST;
		}else {
			status = Status.EXIST;
		}
		return status;
	}
	
	public Status previewClerk(String name, String role) {
		return state(name, role);
	}
	public void enrollClerk(ClerkInfo info) {

		Clerk clerk = new Clerk(info.getName(), info.getRole());
		repository.enrollClerk(clerk);
	}
	
	public void expellClerk(Clerk clerk) {
		repository.expellClerk(clerk);
	}
	
	public Set<Clerk> getClerks() {
		return repository.getClerks();
	}
	
	public Clerk getClerk(String name, String role) {
		return repository.findClerk(name, role);
	}
}
