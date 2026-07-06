

public enum Kind {
	ENTITY,
	REPORT,
	EXIT;
	
	public static Kind choice(char ch) {
		switch (ch) {
		case '1':
			return ENTITY;					
		case '2':
			return REPORT;
		case '3':
			return EXIT;
		}
		return null;
	}
}
