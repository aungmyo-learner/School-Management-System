

public enum ExamType {
	ENROLL(0),
	INITIAL(1),
	MIDDLE(2),
	FINAL(3);
	private final int order;
	
	ExamType(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}
	
	public static ExamType forType(int num) {
		for (ExamType type : values()) {
			if(type.getOrder() == num) return type;
		}
		return null;
	}
}
