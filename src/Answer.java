

public enum Answer {
	YES,
	NO;
	
	public static Answer askDo(char ch) {
		switch (ch) {
		case '1':
			return YES;

		case '2':
			return NO;
		}
		return null;
	}
}
