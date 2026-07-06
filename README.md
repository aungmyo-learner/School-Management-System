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
```
