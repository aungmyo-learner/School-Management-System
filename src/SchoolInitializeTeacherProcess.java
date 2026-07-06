

public final class SchoolInitializeTeacherProcess {
	private final SchoolTeacherRepository repository;
	
	public SchoolInitializeTeacherProcess(SchoolTeacherRepository repository) {
		this.repository = repository;
	}
	public void initialize() {
		grade1();
		grade2();
		grade3();
		grade4();
		grade5();
		grade6();
		grade7();
		grade8();
		grade9();
		grade10();
		grade11();
		grade12();
	}
	private void grade1() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE1, Stream.NONE);
		addTeacher(grade, "Aye Mya", SubjectName.MYANMAR);
		addTeacher(grade, "Hla May", SubjectName.ENGLISH);
		addTeacher(grade, "Win Myint", SubjectName.MATHEMATICS);
		addTeacher(grade, "Mya May", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);

	}
	private void grade2() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE2, Stream.NONE);
		addTeacher(grade, "Win Win", SubjectName.MYANMAR);
		addTeacher(grade, "Yin May", SubjectName.ENGLISH);
		addTeacher(grade, "Hla Phoo", SubjectName.MATHEMATICS);
		addTeacher(grade, "Hnin Thandar", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade3() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE3, Stream.NONE);
		addTeacher(grade, "Thandar Win", SubjectName.MYANMAR);
		addTeacher(grade, "Hla Pyae Moe", SubjectName.ENGLISH);
		addTeacher(grade, "Yin Yin Aung", SubjectName.MATHEMATICS);
		addTeacher(grade, "Myat Noe Oo", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade4() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE4, Stream.NONE);
		addTeacher(grade, "Noe Noe", SubjectName.MYANMAR);
		addTeacher(grade, "Su Myat Nawe", SubjectName.ENGLISH);
		addTeacher(grade, "Ei Myat Mon", SubjectName.MATHEMATICS);
		addTeacher(grade, "Han Ni San", SubjectName.SOCIALITY);
		addTeacher(grade, "Myat Ei Mon", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade5() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE5, Stream.NONE);
		addTeacher(grade, "Su Su Htwe", SubjectName.MYANMAR);
		addTeacher(grade, "Su Myat Aung", SubjectName.ENGLISH);
		addTeacher(grade, "Sandar Win", SubjectName.MATHEMATICS);
		addTeacher(grade, "Khin Khin Gyi", SubjectName.SOCIALITY);
		addTeacher(grade, "May Thien Sandar", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade6() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE6, Stream.NONE);
		addTeacher(grade, "Lwin May Oo", SubjectName.MYANMAR);
		addTeacher(grade, "Phoo Myat May", SubjectName.ENGLISH);
		addTeacher(grade, "Myat Noe Khin", SubjectName.MATHEMATICS);
		addTeacher(grade, "Khin khin Hlaing", SubjectName.GEOGRAPHY);
		addTeacher(grade, "Khin Hlaing Win", SubjectName.HISTORY);
		addTeacher(grade, "Win Win Aye", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade7() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE7, Stream.NONE);
		addTeacher(grade, "Aye Thandar Myint", SubjectName.MYANMAR);
		addTeacher(grade, "Than Than Win", SubjectName.ENGLISH);
		addTeacher(grade, "Eaint Phoo May", SubjectName.MATHEMATICS);
		addTeacher(grade, "Thawdar Win", SubjectName.GEOGRAPHY);
		addTeacher(grade, "Amayar Maung", SubjectName.HISTORY);
		addTeacher(grade, "Hnin Aye Wai", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade8() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE8, Stream.NONE);
		addTeacher(grade, "Tha Zin Oo", SubjectName.MYANMAR);
		addTeacher(grade, "Thandar Aung", SubjectName.ENGLISH);
		addTeacher(grade, "Htet Hla May", SubjectName.MATHEMATICS);
		addTeacher(grade, "Hla Hla  Aung", SubjectName.GEOGRAPHY);
		addTeacher(grade, "Aye Win Maw", SubjectName.HISTORY);
		addTeacher(grade, "Myint Sandar Oo", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade9() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE9, Stream.NONE);
		addTeacher(grade, "Khin May Hlaing", SubjectName.MYANMAR);
		addTeacher(grade, "Yadanar Aung", SubjectName.ENGLISH);
		addTeacher(grade, "Su Yadanar Htet", SubjectName.MATHEMATICS);
		addTeacher(grade, "Su Su Win", SubjectName.GEOGRAPHY);
		addTeacher(grade, "Win Myat Myat Thu", SubjectName.HISTORY);
		addTeacher(grade, "Eaint Ei Khin", SubjectName.SCIENCE);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade10() {
		CurriculumGrade grade = new CurriculumGrade(Grades.GRADE10, Stream.NONE);
		addTeacher(grade, "Tin Tin Oo", SubjectName.MYANMAR);
		addTeacher(grade, "Ei Sandar", SubjectName.ENGLISH);
		addTeacher(grade, "Sandi", SubjectName.MATHEMATICS);
		addTeacher(grade, "Aye Mya May", SubjectName.CHEMISTRY);
		addTeacher(grade, "Khin Myat Noe", SubjectName.PHYSICS);
		addTeacher(grade, "Su Su", SubjectName.BIOLOGY);
		addTeacher(grade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(grade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(grade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(grade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(grade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade11() {
		CurriculumGrade noneGrade = new CurriculumGrade(Grades.GRADE11, Stream.NONE);
		CurriculumGrade scienceGrade = new CurriculumGrade(Grades.GRADE11, Stream.SCIENCE);
		CurriculumGrade artGrade = new CurriculumGrade(Grades.GRADE11, Stream.ART);
		addTeacher(noneGrade, "Aye Aye Win", SubjectName.MYANMAR);
		addTeacher(noneGrade, "Su Sandi Myint", SubjectName.ENGLISH);
		addTeacher(noneGrade, "Wint War Hlaing", SubjectName.MATHEMATICS);

		addTeacher(scienceGrade, "Hsu Myat Noe", SubjectName.CHEMISTRY);
		addTeacher(scienceGrade, "Phoo Myat Thwe", SubjectName.PHYSICS);
		addTeacher(scienceGrade, "Thwe Tar Lin", SubjectName.BIOLOGY);
		
		addTeacher(artGrade, "Khin Mar Lwin", SubjectName.GEOGRAPHY);
		addTeacher(artGrade, "Mar Mar Aye", SubjectName.HISTORY);
		addTeacher(artGrade, "Myint Oo", SubjectName.ECOLOGY);
		
		addTeacher(noneGrade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(noneGrade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(noneGrade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(noneGrade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(noneGrade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void grade12() {
		CurriculumGrade noneGrade = new CurriculumGrade(Grades.GRADE12, Stream.NONE);
		CurriculumGrade scienceGrade = new CurriculumGrade(Grades.GRADE12, Stream.SCIENCE);
		CurriculumGrade artGrade = new CurriculumGrade(Grades.GRADE12, Stream.ART);
		
		addTeacher(noneGrade, "Tin Maung", SubjectName.MYANMAR);
		addTeacher(noneGrade, "Kyaw Myint Oo", SubjectName.ENGLISH);
		addTeacher(noneGrade, "Hla Phay", SubjectName.MATHEMATICS);

		addTeacher(scienceGrade, "Khin Khin Oo", SubjectName.CHEMISTRY);
		addTeacher(scienceGrade, "San San Thwe", SubjectName.PHYSICS);
		addTeacher(scienceGrade, "Chit Oo May", SubjectName.BIOLOGY);
		
		addTeacher(artGrade, "Mya Lay", SubjectName.GEOGRAPHY);
		addTeacher(artGrade, "Khin Sandar Myint", SubjectName.HISTORY);
		addTeacher(artGrade, "Nyein Maung", SubjectName.ECOLOGY);
		
		addTeacher(noneGrade, "Aye Sandar", SubjectName.LIFESKILLS);
		addTeacher(noneGrade, "Lwin Lwin Aung", SubjectName.MORALANDVIRTUE);
		addTeacher(noneGrade, "Lwin Mar Aung", SubjectName.ENVIROMENTEDUCATION);
		addTeacher(noneGrade, "Aye Hla Tin", SubjectName.ART);
		addTeacher(noneGrade, "Hla Myo Win", SubjectName.PHYSICALEDUCATION);
	}
	private void addTeacher(CurriculumGrade grade, String name, SubjectName subject) {
		 repository.enrollTeacher(new Teacher(name, subject, grade));
	}
}
