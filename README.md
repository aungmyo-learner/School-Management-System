# School Management System

> A console-based Java application designed to manage teacher, student, clerk, exam record's enrol, expel, view and performance analysis.

---

## Overview

**School Management System** is Java console application.
* It allows users to enrol and expel teacher, student, clerk, exam record, analyze teacher and student's performance,and show user.

---

## Features

* initialize curriculum subjects by grade and initialize enrol teacher that have in school
* Enrol and Expel teacher, student, clerk, exam record
* In view, teacher performance and student performance are devire analysis,not store

---

## Architecture & Design

This project follows a **Layer archiecture** to separate concerns:

```text

SchoolUserInterFace(UI)
SchoolTeacherInterFace(teacherUI)
SchoolStudentInterFace(studentUI)
SchoolClerkInterFace(ClerkUI)
SchoolExamRecordInterFace(ExamRecordUI)
SchoolStudentPerformanceInterFace(StudentPerformanceUI)
SchoolTeacherPerformanceInterFace(TeacherPerformanceUI)
SchoolGradeStudentPerformanceInterFace(GradeStudentPerformanceUI)
SchoolGradeTeacherPerformanceInterFace(GradeStudentPerformanceUI)
SchoolOverallStudentPerformanceInterFace(OverallStudentPerformanceUI)
SchoolOverallTeacherPerformanceInterFace(OverallStudentPerformanceUI)
	↓
SchoolTeacherController(Teacher flow Control)
SchoolStudentController(Student flow Control)
SchoolClerkController(Clerk flow Control)
SchoolExamRecordController(ExamRecord flow Control)
SchoolStudentPerformanceController(StudentPerformance flow Control)
SchoolTeacherPerformanceController(TeacherPerformance flow Control)
SchoolGradeStudentPerformanceController(GradeStudentPerformance flow Control)
SchoolGradeTeacherPerformanceController(GradeStudentPerformance flow Control)
SchoolOverallStudentPerformanceController(OverallStudentPerformance flow Control)
SchoolOverallTeacherPerformanceController(OverallStudentPerformance flow Control)
	↓
SchoolTeacherService(Teacher Logic)
SchoolStudentService(Student Logic)
SchoolClerkService(Clerk Logic)
SchoolExamRecordService(ExamRecord Logic)
SchoolStudentPerformanceService(StudentPerformance Logic)
SchoolTeacherPerformanceService(TeacherPerformance Logic)
SchoolGradeStudentPerformanceService(GradeStudentPerformance Logic)
SchoolGradeTeacherPerformanceService(GradeStudentPerformance Logic)
SchoolOverallStudentPerformanceService(OverallStudentPerformance Logic)
SchoolOverallTeacherPerformanceService(OverallStudentPerformance Logic)
	↓
Domain(Entities	→ Student,Teacher,Clerk,School,ExamRecord,ExamSubject
		Value / Domain Concepts	→ CurriculumGrade,Grades,Stream,ExamType,SubjectName,SubjectType,Level
		Domain-specific calculations / results → StudentPerformance,TeacherPerformance,GradeStudentsPerformance,GradeTeacherPerformance,OverallStudentPerformance,OverallTeacherPerformance)
	↓
Data(SchoolTeacherRepository,SchoolStudentRepository,SchoolClerkRepository,SchoolExamRepository)
```
## Key Design Principles

* Separation of Concerns
* Single Responsibility
* Encapsulation
* Immutability
* Dependency Injection
* DRY
* Composition over Inheritance
* Open/Closed
* Dependency Inversion

---

## Tech Stack

* Java
* Java Collections Freamwork
* OOP
* Java Stream/Lambda
* Generics

## How to Run

```bash
# Clone repository
git clone https://github.com/aungmyo-learner/School-Management-System.git

# Open in IDE (Eclipse / IntelliJ)

# Run main class
School.java
```
---

## Example Output

```
This School is basic education high school in Myanmar Country.
Enter
1.Enroll
2.Expel
3.View
4.Exit
1
Enter
1.Teacher
2.Student
3.Clerk
4.Exam Record
5.Exit
2
Enter your name..
Tin Tin
Enter your parent..
Mya Hnin
Enter Grade
1.Grade 1
2.Grade 2
3.Grade 3
4.Grade 4
5.Grade 5
6.Grade 6
7.Grade 7
8.Grade 8
9.Grade 9
10.Grade 10
11.Grade 11
12.Grade 12
12
Enter Stream
1.SCIENCE
2.ART
1
Success Enrol.
This School is basic education high school in Myanmar Country.
Enter
1.Enroll
2.Expel
3.View
4.Exit
3
Enter
1.Record
2.Report
3.Exit
1
Enter
1.Teacher
2.Student
3.Clerk
4.Exam Record
5.Exam Type Exam Record
6.Exit
2
Enter
1.All
2.A Grade
3.Each
4.Exit
3
Enter your name..
Tin Tin
Enter your parent..
Mya Hnin
Enter Grade
1.Grade 1
2.Grade 2
3.Grade 3
4.Grade 4
5.Grade 5
6.Grade 6
7.Grade 7
8.Grade 8
9.Grade 9
10.Grade 10
11.Grade 11
12.Grade 12
12
Enter Stream
1.SCIENCE
2.ART
1
Student Name: Tin Tin
Parent name: Mya Hnin
Student grade: GRADE12 (SCIENCE)
This School is basic education high school in Myanmar Country.
Enter
1.Enroll
2.Expel
3.View
4.Exit
4
Do you want to see overall performance
1.Yes 2.No
1
1.Teacher 2.Student
2
Only one Exam Type Result
1.Yes 2.No
1
1.Initial
2.Middle
3.Final
3
null
Only overall Result
1.Yes 2.No
2
```
---

## Core Logic Highlights

* Student Performance Calculation
* Exam Record Management
* Grade Performance Aggregation
* Overall Performance Aggregation
* Best Student / Ranking
* Business Rule Validation
* Comparator / Sorting Logic
* Student Enrollment

---

## Future Improvements

* File/Database persistence
* GUI version (JavaFX / Swing)
* REST API version(Spring Boot)
* Advanced analytics (average, ranking)
* Export results (CSV / PDF)

---

## Author
**Aung Myo**

---

## What I Learned

* Designing layered architecture
* Writing clean and maintainable Java code
* Comparator Concept
* Managing state vs computing on demand
* Structuring real-world console applications

---
