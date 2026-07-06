

public enum Stream {
	NONE(0),
	SCIENCE(1),
	ART(2);
	private final int order;
	Stream(int order) {
		this.order = order;
	}
	public int getOrder() {
		return order;
	}
	public static Stream getStream(int num) {
		for (Stream stream : values()) {
			if(stream.getOrder() == num)
				return stream;
		}
		return null;
	}
}
