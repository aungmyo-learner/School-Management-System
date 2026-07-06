

import java.util.Scanner;

public class School {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SchoolCurriculum curriculum = new SchoolCurriculum();
		
		SchoolInitializeSubjectProcess subjectsProcess = new SchoolInitializeSubjectProcess(curriculum);
		subjectsProcess.initializeProcessLearnSubjectsByGrade();
		
		
		SchoolTeacherRepository teacherRepository = new SchoolTeacherRepository();
		SchoolInitializeTeacherProcess teacherProcess = new SchoolInitializeTeacherProcess(teacherRepository);
		teacherProcess.initialize();
		
		// Teacher Part
		SchoolTeacherService teacherService = new SchoolTeacherService(teacherRepository, curriculum);
		SchoolTeacherInterFace teacherInterface = new SchoolTeacherInterFace(sc);

		// StudentPart
		SchoolStudentRepository studentRepository = new SchoolStudentRepository();
		SchoolStudentService studentService = new SchoolStudentService(studentRepository, curriculum);
		SchoolStudentInterFace studentInterFace = new SchoolStudentInterFace(sc);
		
		// Exam Part
		SchoolExamRepository examRepository = new SchoolExamRepository();
		SchoolExamService examService = new SchoolExamService(examRepository);
		SchoolExamInterFace examInterFace = new SchoolExamInterFace(sc);
		
		// Clerk Part
		SchoolClerkRepository clerkRepository = new SchoolClerkRepository();
		SchoolClerkService clerkService = new SchoolClerkService(clerkRepository);
		SchoolClerkInterFace clerkInterFace = new SchoolClerkInterFace(sc);
		
		// Student performance Part
		SchoolStudentPerformanceService studentPerformanceService = new SchoolStudentPerformanceService(examRepository);
		SchoolStudentPerformanceInterFace studentPerformanceInterFace = new SchoolStudentPerformanceInterFace(sc);
		
		// Teacher performance Part
		SchoolTeacherPerformanceService teacherPerformanceService = 
				new SchoolTeacherPerformanceService(examRepository, teacherRepository);
		SchoolTeacherPerformanceInterFace teacherPerformanceInterFace = new SchoolTeacherPerformanceInterFace(sc);
		
		// Grade student performance Part
		SchoolGradeStudentPerformanceService gradeStudentPerformanceService =
				new SchoolGradeStudentPerformanceService(examRepository, studentPerformanceService);
		
		SchoolGradeStudentPerformanceInterFace gradeStudentPerformanceInterFace =
				new SchoolGradeStudentPerformanceInterFace(sc);
		
		// Grade teacher performance Part
		SchoolGradeTeacherPerformanceService gradeTeacherPerformanceService = 
				new SchoolGradeTeacherPerformanceService(teacherRepository, teacherPerformanceService);
		
		SchoolGradeTeacherPerformanceInterFace gradeTeacherPerformanceInterFace =
				new SchoolGradeTeacherPerformanceInterFace(sc);
		
		// Overall Student Performance Part
		SchoolOverallStudentPerformanceService overallStudentPerformanceService =
				new SchoolOverallStudentPerformanceService(gradeStudentPerformanceService);
		
		SchoolOverallStudentPerformanceInterFace overallStudentPerformanceInterFace =
				new SchoolOverallStudentPerformanceInterFace(sc);
		
		// Overall Teacher Performance Part
		SchoolOverallTeacherPerformanceService overallTeacherPerformanceService =
				new SchoolOverallTeacherPerformanceService(gradeTeacherPerformanceService, teacherPerformanceService);
		
		SchoolOverallTeacherPerformanceInterFace overallTeacherPerformanceInterFace =
				new SchoolOverallTeacherPerformanceInterFace(sc);
		
		//Controller
		SchoolTeacherController teacherController = 
				new SchoolTeacherController(teacherService, teacherInterface);
		
		SchoolStudentController studentController = 
				new SchoolStudentController(studentService, examService, studentInterFace);
		
		SchoolClerkController clerkController = new SchoolClerkController(clerkService, clerkInterFace);
		
		SchoolExamController examController = new SchoolExamController(studentService, examService, examInterFace);
		
		SchoolStudentPerformanceController studentPerformanceController =
				new SchoolStudentPerformanceController(studentService, studentPerformanceService, studentPerformanceInterFace);
		
		SchoolTeacherPerformanceController teacherPerformanceController =
				new SchoolTeacherPerformanceController(teacherService, teacherPerformanceService, teacherPerformanceInterFace);
		
		SchoolGradeStudentPerformanceController gradeStudentPerformanceController =
				new SchoolGradeStudentPerformanceController(gradeStudentPerformanceService, gradeStudentPerformanceInterFace);
		
		SchoolGradeTeacherPerformanceController gradeTeacherPerformanceController =
				new SchoolGradeTeacherPerformanceController(gradeTeacherPerformanceService, gradeTeacherPerformanceInterFace);
				
		SchoolOverallStuentPerformanceController overallStuentPerformanceController =
				new SchoolOverallStuentPerformanceController(overallStudentPerformanceService, overallStudentPerformanceInterFace);
		
		SchoolOverallTeacherPerformanceController overallTeacherPerformanceController =
				new SchoolOverallTeacherPerformanceController(overallTeacherPerformanceService, overallTeacherPerformanceInterFace);
		
		SchoolUserInterFace userInterFace = new SchoolUserInterFace(sc);
		
		SchoolController controller = new SchoolController(teacherController, studentController, clerkController,
				examController, studentPerformanceController,teacherPerformanceController,
				gradeStudentPerformanceController, gradeTeacherPerformanceController,overallStuentPerformanceController,
				overallTeacherPerformanceController, userInterFace);
		
		controller.start();
		sc.close();		
	}
}
