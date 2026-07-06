

public enum Action {
	ENROLL,
	FIRE,
	EXIT;
	
	public static Action forEnroll(char ch) {
		Action action = null;
		switch (ch) {
		case '1':
			action = ENROLL;
			break;
		case '2':
			action = EXIT;
			break;
		}
		return action;
	}
	public static Action forFire(char ch) {
		Action action = null;
		switch (ch) {
		case '1':
			action = FIRE;
			break;
		case '2':
			action = EXIT;
			break;
		}
		return action;
	}
	
}
