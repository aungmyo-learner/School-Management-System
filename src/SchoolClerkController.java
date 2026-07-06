

import java.util.Set;

public class SchoolClerkController {
	private final SchoolClerkService service;
	private final SchoolClerkInterFace user;
	public SchoolClerkController(SchoolClerkService service, SchoolClerkInterFace user) {
		this.service = service;
		this.user = user;
	}
	
	public void enrolControl() {
		enroll();
	}
	
	private void enroll() {
		ClerkInfo info = user.askEnrollForClerk();
		Status status = service.previewClerk(info.getName(), info.getRole());
		switch (status) {
		case EXIST:
			user.exist();
			break;

		case NOT_EXST:
			service.enrollClerk(info);
			user.successEnrol();
			break;
		}
	}
	
	public void expelControl() {
		expel();
	}
	
	private void expel() {
		SearchClerk search = user.searchClerk();
		Status status =service.previewClerk(search.getName(), search.getRole());
		switch (status) {
		case EXIST:
			Clerk clerk = service.getClerk(search.getName(), search.getRole());
			service.expellClerk(clerk);
			user.successExpel();
			break;
		case NOT_EXST:
			user.notExist();
		}
	}
	
	public void allClerkControl() {
		all();
	}

	private void all() {
		Set<Clerk> clerks = service.getClerks();
		
		user.printClerks(clerks);
	}

	public void eachClerkControl() {
		each();
	}
	
	private void each() {
		SearchClerk search = user.searchClerk();
		Status status = service.previewClerk(search.getName(), search.getRole());
		switch (status) {
		case EXIST:
			Clerk clerk = service.getClerk(search.getName(), search.getRole());
			user.printClerk(clerk);
			break;

		case NOT_EXST:
			user.notExist();
			break;
		}
	}
	
}
