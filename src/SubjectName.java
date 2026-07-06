

public enum SubjectName {
	MYANMAR(1, SubjectType.ACADEMIC),
	ENGLISH(2, SubjectType.ACADEMIC),
	MATHEMATICS(3, SubjectType.ACADEMIC),
	SOCIALITY(4, SubjectType.ACADEMIC),
	GEOGRAPHY(5, SubjectType.ACADEMIC),
	HISTORY(6, SubjectType.ACADEMIC),
	SCIENCE(7, SubjectType.ACADEMIC),
	CHEMISTRY(8, SubjectType.ACADEMIC),
	PHYSICS(9, SubjectType.ACADEMIC),
	BIOLOGY(10, SubjectType.ACADEMIC),
	ECOLOGY(11, SubjectType.ACADEMIC),
	LIFESKILLS(12, SubjectType.NO_ACADEMIC),
	MORALANDVIRTUE(13, SubjectType.NO_ACADEMIC),
	ENVIROMENTEDUCATION(14, SubjectType.NO_ACADEMIC),
	ART(15, SubjectType.NO_ACADEMIC),
	PHYSICALEDUCATION(16, SubjectType.NO_ACADEMIC);
	
	private final int order;
	private final SubjectType type;
	
	SubjectName(int order, SubjectType type) {
		this.type = type;
		this.order = order;
	}

	public int getOrder() {
		return order;
	}
	public SubjectType getType() {
		return type;
	}
	public static SubjectName forSubjectName(int num) {
		for (SubjectName subject : values()) {
			if (subject.getOrder() == num) {
				return subject;
			}
		}
		return null;
	}
	
}
