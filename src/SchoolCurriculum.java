

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SchoolCurriculum {
	private Map<CurriculumGrade, Set<SubjectName>> subjectsByGrade = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
	private Map<CurriculumGrade, Set<SubjectName>> examSubjectsByGrade = new TreeMap<>(SchoolComparators.CURRICULUM_GRADE);
	
	public Set<SubjectName> getSubjectsByGrade(CurriculumGrade curriculumGrade){
		return subjectsByGrade.containsKey(curriculumGrade)?
				Set.copyOf(subjectsByGrade.get(curriculumGrade)): Set.of();
	}
	public Set<SubjectName> getExamSubjectByGrade(CurriculumGrade curriculumGrade) {
		return examSubjectsByGrade.containsKey(curriculumGrade)?
				Set.copyOf(examSubjectsByGrade.get(curriculumGrade)): Set.of();
	}
	public void addSubjects(CurriculumGrade curriculumGrade, Set<SubjectName> subjects) {
		subjectsByGrade.put(curriculumGrade, subjects);
	}
	public void addExamSubjects(CurriculumGrade curriculumGrade, Set<SubjectName> examSubjects) {
		examSubjectsByGrade.put(curriculumGrade, examSubjects);
	}
}
