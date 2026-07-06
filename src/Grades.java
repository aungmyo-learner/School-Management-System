

public enum Grades {
	GRADE1(1),
	GRADE2(2),
	GRADE3(3),
	GRADE4(4),
	GRADE5(5),
	GRADE6(6),
	GRADE7(7),
	GRADE8(8),
	GRADE9(9),
	GRADE10(10),
	GRADE11(11),
	GRADE12(12);
	private final int order;
	Grades(int order) {
		this.order = order;
	}
	public int getOrder() {
		return order;
	}
	public static Grades forGrade(int num) {
		for (Grades grade : values()) {
			if (grade.getOrder() == num) {
				return grade;
			}
		}
		return null;
	}
	  public boolean requiresStream(int num) {
	        return num >= 11;
	    }
}
