

import java.util.Comparator;

public class SchoolComparators {
	public static final Comparator<Student> STUDENT_BY_NAME = Comparator.comparing(Student::getName);
	public static final Comparator<ExamType> EXAM_TYPE = Comparator.comparing(ExamType::getOrder);
	public static final Comparator<SubjectName> SUBJECTS = Comparator.comparing(SubjectName::getOrder);
	
	public static final Comparator<CurriculumGrade> CURRICULUM_GRADE =
			Comparator
			.comparing((CurriculumGrade c) -> c.getGrade())
			.thenComparing((c -> c.getStream())
					);
	public static final Comparator<Grades> GRADE = Comparator.comparing(Grades::getOrder);

	public static final Comparator<Teacher> TEACHER = Comparator
			.comparing(Teacher::getSubject)
			.thenComparing(Teacher::getName);
	
	public static final Comparator<Clerk> CLERK_BY_NAME = Comparator.comparing(Clerk::getName);
	
	public static final Comparator<StudentPerformance> STUDENT_PERFORMANCE = 
			Comparator
			.comparing(StudentPerformance:: getAverageMark)
			.thenComparing(StudentPerformance::getTotalMark)
			.thenComparing(StudentPerformance:: getDistinctionCount);

	public static final Comparator<TeacherPerformance> TEACHER_PERFORMANCE =
			Comparator
			.comparing(TeacherPerformance::getPassRate)
			.thenComparing(TeacherPerformance::getAverageMark)
			.thenComparing(TeacherPerformance::getDistinctionCount);
	
	public static final Comparator<GradeOverallStudentBestPerformanceAccumulator>
	GRADE_OVERALL_BEST_STUDENT_PERFORMANCE_ACCUMULATOR =
			Comparator
			.comparing(GradeOverallStudentBestPerformanceAccumulator:: getOverallAverageMark)
			.thenComparing(GradeOverallStudentBestPerformanceAccumulator:: getOverallAverageTotalMark)
			.thenComparing(GradeOverallStudentBestPerformanceAccumulator:: getOverallAverageDistinctionCount);
	
	public static final Comparator<GradeOverallBestStudentPerformance> GRADE_OVERALL_STUDENT_BEST_PERFORMANCE = 
			Comparator.comparing(GradeOverallBestStudentPerformance::getScore);

	public static final Comparator<GradeOverallTeacherBestPerformanceAccumulator>
	GRADE_OVERALL_BEST_TEACHER_PERFORMANCE_ACCUMULATOR =
			Comparator.comparing(GradeOverallTeacherBestPerformanceAccumulator::getScore);
	
	public static final Comparator<GradeOverallBestTeachertPerformance> GRADE_OVERALL_TEACHER_BEST_PERFORMANCE = 
			Comparator.comparing(GradeOverallBestTeachertPerformance::getScore);
	
	
	
	
	
	
	
	
	
}
