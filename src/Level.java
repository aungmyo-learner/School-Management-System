

public enum Level {
	S,A,B,C,D,E;
	
	public static Level determineLevel(int averageMark) {
		if (averageMark >= 90 && averageMark <= 100) {
			return S;
		}else if (averageMark >= 80) {
			return A;
		}else if (averageMark >= 70) {
			return B;
		}else if (averageMark >= 50) {
			return C;
		}else if (averageMark >= 40) {
			return D;
		}else if(0 <= averageMark && averageMark <40){
			return E;
		}
		return null;
	}
}
