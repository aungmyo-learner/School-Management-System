

public class EntityViewMapper {
	public static View forGeneral(char ch) {
		switch (ch) {
		case '1':
			return View.ALL;
		case '2':
			return View.A_GRADE;
		case '3':
			return View.EACH;
		case '4':
			return View.EXIT;
		}
		return null;
	}
	
	public static View forClerk(char ch) {
		switch (ch) {
		case '1':
			return View.ALL;
		case '2':
			return View.EACH;
		case '3':
			return View.EXIT;
		}
		return null;
	}
}
