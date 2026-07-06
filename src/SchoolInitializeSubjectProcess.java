

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class SchoolInitializeSubjectProcess {
	 private final SchoolCurriculum curriculum;
	 
	public SchoolInitializeSubjectProcess(SchoolCurriculum curriculum) {
		this.curriculum = curriculum;
	}
	public void initializeProcessLearnSubjectsByGrade() {
		grade123();
		grade45();
		grade6789();
		grade10();
		science();
		art();
	}
	private void grade123() {
		
		List<SubjectName> learnList = List.of(
			    SubjectName.MYANMAR,
			    SubjectName.ENGLISH,
			    SubjectName.MATHEMATICS,
			    SubjectName.SCIENCE,
			    SubjectName.LIFESKILLS,
			    SubjectName.MORALANDVIRTUE,
			    SubjectName.ENVIROMENTEDUCATION,
			    SubjectName.ART,
			    SubjectName.PHYSICALEDUCATION
			);
		List<SubjectName> examList = List.of(
				SubjectName.MYANMAR,
			    SubjectName.ENGLISH,
			    SubjectName.MATHEMATICS,
			    SubjectName.SCIENCE
		);
		Set<SubjectName> learnSubjects = createSubjects(learnList);
		Set<SubjectName> examSubjects = createSubjects(examList);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE1, Stream.NONE), learnSubjects);		
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE2, Stream.NONE), learnSubjects);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE3, Stream.NONE), learnSubjects);
		
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE1, Stream.NONE), examSubjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE2, Stream.NONE), examSubjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE3, Stream.NONE), examSubjects);

	}
	private void grade45() {
		List<SubjectName> learnList = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.SCIENCE,
				SubjectName.SOCIALITY,
				SubjectName.LIFESKILLS,
				SubjectName.MORALANDVIRTUE,
				SubjectName.ENVIROMENTEDUCATION,
				SubjectName.ART,
				SubjectName.PHYSICALEDUCATION
				);
		List<SubjectName> examList = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.SOCIALITY,
				SubjectName.SCIENCE
		);
		Set<SubjectName> learnSubjects = createSubjects(learnList);
		Set<SubjectName> examSubjects = createSubjects(examList);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE4, Stream.NONE), learnSubjects);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE5, Stream.NONE), learnSubjects);
		
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE4, Stream.NONE), examSubjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE5, Stream.NONE), examSubjects);
	}
	private void grade6789() {
		List<SubjectName> learnList = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.GEOGRAPHY,
				SubjectName.HISTORY,
				SubjectName.SCIENCE,
				SubjectName.MORALANDVIRTUE,
				SubjectName.ENVIROMENTEDUCATION,
				SubjectName.ART,
				SubjectName.PHYSICALEDUCATION
				);
		List<SubjectName> examList = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.GEOGRAPHY,
				SubjectName.HISTORY,
				SubjectName.SCIENCE
		);
		Set<SubjectName> learnSubjects = createSubjects(learnList);
		Set<SubjectName> examSubjects = createSubjects(examList);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE6, Stream.NONE), learnSubjects);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE7, Stream.NONE), learnSubjects);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE8, Stream.NONE), learnSubjects);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE9, Stream.NONE), learnSubjects);

		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE6, Stream.NONE), examSubjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE7, Stream.NONE), examSubjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE8, Stream.NONE), examSubjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE9, Stream.NONE), examSubjects);
	}
	private void grade10() {
		List<SubjectName> learnList = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.CHEMISTRY,
				SubjectName.PHYSICS,
				SubjectName.BIOLOGY,
			    SubjectName.ART,
			    SubjectName.PHYSICALEDUCATION
				);
		Set<SubjectName> learnSubjects = createSubjects(learnList);
		
		List<SubjectName> examList = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.CHEMISTRY,
				SubjectName.PHYSICS,
				SubjectName.BIOLOGY
				);
		Set<SubjectName> examSubjects = createSubjects(examList);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE10, Stream.NONE), learnSubjects);
		
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE10, Stream.NONE), examSubjects);

	}
	private void science() {
		List<SubjectName> list = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.CHEMISTRY,
				SubjectName.PHYSICS,
				SubjectName.BIOLOGY
				);
		Set<SubjectName> subjects = createSubjects(list);
		
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE11, Stream.SCIENCE), subjects);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE12, Stream.SCIENCE), subjects);
		
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE11, Stream.SCIENCE), subjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE12, Stream.SCIENCE), subjects);

	}
	private void art() {
		List<SubjectName> list = List.of(
				SubjectName.MYANMAR,
				SubjectName.ENGLISH,
				SubjectName.MATHEMATICS,
				SubjectName.GEOGRAPHY,
				SubjectName.HISTORY,
				SubjectName.ECOLOGY
				);
		Set<SubjectName> subjects = createSubjects(list);
		
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE11, Stream.ART), subjects);
		curriculum.addSubjects(new CurriculumGrade(Grades.GRADE12, Stream.ART), subjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE11, Stream.ART), subjects);
		curriculum.addExamSubjects(new CurriculumGrade(Grades.GRADE12, Stream.ART), subjects);
	}
	private  Set<SubjectName> createSubjects(List<SubjectName> list) {
		Set<SubjectName> subjects = new TreeSet<>(SchoolComparators.SUBJECTS);
		subjects.addAll(list);
		
		return subjects;
	}
}