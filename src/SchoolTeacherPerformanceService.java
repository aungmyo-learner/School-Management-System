

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SchoolTeacherPerformanceService {
	private final SchoolExamRepository examRecords;
	private final SchoolTeacherRepository teachersRepo;
	public SchoolTeacherPerformanceService(SchoolExamRepository examRecords,
			SchoolTeacherRepository teachersRepo) {
		this.examRecords = examRecords;
		this.teachersRepo = teachersRepo;
	}
	
	
	public Map<CurriculumGrade,Map<ExamType, Set<TeacherPerformance>>> getTeacherPerformances() {
		return teacherPerformances();
	}
	
	public Map<CurriculumGrade, Set<TeacherPerformance>> getExamTypeTeacherPerformances(ExamType type) {
		return examTypeTeacherPerformances(type);
	}
	
	private Map<CurriculumGrade, Set<TeacherPerformance>> examTypeTeacherPerformances(ExamType type) {
		
		Map<CurriculumGrade, Set<TeacherPerformance>> performances = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var grade : teachersRepo.getTeachers().entrySet()) {
		
			Map<ExamType, Set<TeacherPerformance>> p =
			        buildTeacherPerformances(grade.getKey());
			
			if (p.containsKey(type)) {
				performances.computeIfAbsent(grade.getKey(), 
						g -> new TreeSet<>(SchoolComparators.TEACHER_PERFORMANCE))
				.addAll(p.get(type));
			}
		}
		
		return Collections.unmodifiableMap(performances);
	}
	
	private Map<CurriculumGrade,Map<ExamType, Set<TeacherPerformance>>> teacherPerformances() {
		Map<CurriculumGrade, Map<ExamType, Set<TeacherPerformance>>> performances = 
				new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
		
		for (var grade : teachersRepo.getTeachers().entrySet()) {
			
			Map<ExamType, Set<TeacherPerformance>> p =  performances
					.computeIfAbsent(grade.getKey(), g -> new TreeMap<>(SchoolComparators.EXAM_TYPE));
			p.putAll(buildTeacherPerformances(grade.getKey()));
			
		}
		return Collections.unmodifiableMap(performances);
	}
	
	public Set<TeacherPerformance> getExamTypeTeacherPerformanceOfGrade(CurriculumGrade grade, ExamType type) {
			return buildTeacherPerformances(grade).getOrDefault(type, Set.of());
	}
	
	public Map<ExamType, TeacherPerformance> getTeacherPerformances(Teacher teacher) {
		return teacherPerformances(teacher);
	}
	
	public TeacherPerformance getTeacherPerformance(Teacher teacher, ExamType type) {
		ExamTeacherAccumulator accumulator = buildTeacherAccumulators(teacher)
				.getOrDefault(type, new ExamTeacherAccumulator());
		return teacherPerformance(teacher, accumulator);
	}
	
	private Map<ExamType, TeacherPerformance> teacherPerformances(Teacher teacher) {
		Map<ExamType, TeacherPerformance> performances = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		Map<ExamType, ExamTeacherAccumulator> accumulators = buildTeacherAccumulators(teacher);
		
		for (var typeEntry : accumulators.entrySet()) {
			ExamType type = typeEntry.getKey();
			TeacherPerformance performance = teacherPerformance(teacher, typeEntry.getValue());
			performances.put(type, performance);
		}
		return Collections.unmodifiableMap(performances);
	}
	
	public Map<ExamType, Set<TeacherPerformance>> getTeachersPerformances(CurriculumGrade grade) {
		return buildTeacherPerformances(grade);
	}
	public Map<ExamType, Set<TeacherPerformance>> getBuildTeacherPerformances(CurriculumGrade grade){
		return buildTeacherPerformances(grade);
	}
	private Map<ExamType, Set<TeacherPerformance>> buildTeacherPerformances(CurriculumGrade grade) {
		Set<Teacher> teachers = teachersRepo.getTeachersFromAGrade(grade);
		Map<ExamType, Set<TeacherPerformance>> performances = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		
		for (Teacher teacher : teachers) {
			if (teacher.getSubject().getType() == SubjectType.ACADEMIC) {
				Map<ExamType, ExamTeacherAccumulator> accumulator = buildTeacherAccumulators(teacher);
				
				for (var typeEntry : accumulator.entrySet()) {
					ExamType type = typeEntry.getKey();
					TeacherPerformance performance = teacherPerformance(teacher, typeEntry.getValue());
					performances.computeIfAbsent(type, t-> new TreeSet<>(SchoolComparators.TEACHER_PERFORMANCE))
					.add(performance);
				}
			}
		}
		return performances;
	}
	
	private Map<ExamType, ExamTeacherAccumulator> buildTeacherAccumulators(Teacher teacher) {
		Map<ExamType, ExamTeacherAccumulator> accumulators = new TreeMap<>(SchoolComparators.EXAM_TYPE);
		
		for (var studentEntry : examRecords.getExamRecordsOfAGrade(teacher.getGrade()).entrySet()) {
			
			for (var typeEntry : studentEntry.getValue().entrySet()) {
			
				ExamType type = typeEntry.getKey();
				
				ExamTeacherAccumulator accumulator = accumulators.computeIfAbsent(type,
						t -> new ExamTeacherAccumulator());
				if (typeEntry.getValue().containsKey(teacher.getSubject())) {
					ExamSubject subject = typeEntry.getValue().get(teacher.getSubject());
					accumulator.incrementExamStudentsCount();
					accumulator.addTotalMark(subject.getMark());
					accumulator.accumulate(subject, studentEntry.getKey().getGrade());				}
			}
		}
		return Collections.unmodifiableMap(accumulators);
	}
	
	private TeacherPerformance teacherPerformance(Teacher teacher, ExamTeacherAccumulator accumulator) {
		
		int totalMark = accumulator.getTotalMark();
		int averageMark = accumulator.getAverageMark();
		Level level = Level.determineLevel(averageMark);
		int examStudentsCount = accumulator.getExamStudentsCount();
		int passStudentsCount = accumulator.getPassStudentsCount();
		int failStudentsCount = accumulator.getFailStudentsCount();
		int distinctionStudentsCount = accumulator.getDistinctionStudentsCount();
		double passRate = accumulator.getPassRate();
		TeacherPerformance performance = new TeacherPerformance(teacher.getName(), teacher.getSubject(), teacher.getGrade(),
				examStudentsCount, passStudentsCount, failStudentsCount,
				totalMark, averageMark, distinctionStudentsCount, passRate, level);
		
		return performance;
	}
	
}
