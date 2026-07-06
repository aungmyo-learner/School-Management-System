

public class MenuMapper {

	public static EntityType forEnrol(char ch) {
		switch (ch) {
		case '1':
			return EntityType.TEACHER;
		case '2':
			return EntityType.STUDENT;
		case '3':
			return EntityType.CLERK;
		case '4':
			return EntityType.EXAM_RECORD;
		case '5':
			return EntityType.EXIT;
		}
		return null;
	}
	
	public static EntityType forGeneral(char ch) {
		switch (ch) {
		case '1':
			return EntityType.TEACHER;
		case '2':
			return EntityType.STUDENT;
		case '3':
			return EntityType.CLERK;
		case '4':
			return EntityType.EXAM_RECORD;
		case '5':
			return EntityType.EXAM_TYPE_EXAM_RECORD;
		case '6':
			return EntityType.EXIT;
		}
		return null;
	}
	
	public static ReportType forView(char ch) {
		switch (ch) {
		case '1':
			return ReportType.STUDENT_PERFORMANCE;
		case '2':
			return ReportType.EXAM_TYPE_STUDENT_PERFORMANCE;
		case '3':
			return ReportType.TEACHER_PERFORMANCE;
		case '4':
			return ReportType.EXAM_TYPE_TEACHER_PERFORMANCE;
		case '5':
			return ReportType.GRADE_PERFORMANCE;
		case '6': 
			return ReportType.EXAM_TYPE_GRADE_PERFORMANCE;
		case '7':
			return ReportType.GRADE_TEACHER_PERFORMANCE;
		case '8':
			return ReportType.EXAM_TYPE_GRADE_TEACHER_PERFORMANCE;
		case '9':
			return ReportType.EXIT;
		}
		return null;
	}
	
	public static EntityType forOverall(char ch) {
		switch (ch) {
		case '1' :
			return EntityType.TEACHER;
		case '2':
			return EntityType.STUDENT;
		}
		return null;
	}
}
