

import java.util.Objects;

public class CurriculumGrade {
	private final Grades grade;
	private final Stream stream;
	public CurriculumGrade(Grades grade, Stream stream) {
		this.grade = grade;
		this.stream = stream;
	}
	public Grades getGrade() {
		return grade;
	}
	public Stream getStream() {
		return stream;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		
		if(!(obj instanceof CurriculumGrade other))
			return false;
		
		return grade == other.grade
	            && stream == other.stream;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(grade, stream);
	}
	public String toString() {
		if (stream == Stream.SCIENCE || stream == Stream.ART) {
			return grade + " (" + stream + ")";
		}
		return grade + "";
	}
}
