

public enum Menu {
	ENROLL,
	EXPEL,
	VIEW,
	EXIT;
	
	public static Menu menu(char ch) {
		Menu menu = null;
		switch (ch) {
		case '1':
			menu = ENROLL;
			break;
		case '2':
			menu = EXPEL;
			break;
		case '3':
			menu = VIEW;
			break;
		case '4':
			menu = EXIT;
			break;
		}
		return menu;
	}
}
