package com.educ;

import com.educ.entity.*;
import com.educ.repository.*;
import com.educ.service.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Student firstStudent = new SimpleStudent(1, "Ivanov", "Ivan");
        Student secondStudent = new SimpleStudent(2, "Petrov", "Petr");
        Student thirdStudent = new SimpleStudent(3, "Sidorov", "Sidor");
        Student fourthStudent = new SimpleStudent(4, "Kuznetsov", "Kuznets");

        StudentsRepository studentsRepository = new SimpleStudentsRepository();
        StudentService studentService = new SimpleStudentService(studentsRepository);
        studentService.addStudent(firstStudent);
        studentService.addStudent(secondStudent);
        studentService.addStudent(thirdStudent);
        studentService.addStudent(fourthStudent);

        Course hibernateCourse = new BaseCourse("Hibernate Course", 24);
        Course springCourse = new BaseCourse("Spring Course", 16);
        Course javaFXCourse = new BaseCourse("JavaFX Course", 8);
        Course webCourse = new BaseCourse("Web Course", 30);

        EducationProgram firstEducationProgram = new SimpleEducationProgram();
        firstEducationProgram.addCourse(hibernateCourse);
        firstEducationProgram.addCourse(springCourse);

        firstEducationProgram.setProgramName("First Education Program");

        EducationProgram secondEducationProgram = new SimpleEducationProgram();
        secondEducationProgram.addCourse(javaFXCourse);
        secondEducationProgram.addCourse(webCourse);
        secondEducationProgram.addCourse(hibernateCourse);
        secondEducationProgram.setProgramName("Second Education Program");

        EducationProgramsRepository educationProgramsRepository = new SimpleEducationProgramRepository();
        educationProgramsRepository.addProgram(firstEducationProgram);
        educationProgramsRepository.addProgram(secondEducationProgram);

        StudentsRatingRepository studentsRatingRepository = new SimpleStudentsRatingRepository();

        RatingService ratingService = new StudentRatingService(studentsRatingRepository);

        firstStudent.setEducationProgram(firstEducationProgram);
        firstStudent.setStartDate(LocalDate.now().minus(1, ChronoUnit.DAYS));
        ratingService.addRating(firstStudent, 5);

        secondStudent.setEducationProgram(firstEducationProgram);
        secondStudent.setStartDate(LocalDate.now().minus(2, ChronoUnit.DAYS));
        ratingService.addRating(secondStudent, 2);
        ratingService.addRating(secondStudent, 2);

        thirdStudent.setEducationProgram(secondEducationProgram);
        thirdStudent.setStartDate(LocalDate.now());

        ratingService.addRating(thirdStudent, 3);
        ratingService.addRating(thirdStudent, 3);

        fourthStudent.setEducationProgram(secondEducationProgram);
        fourthStudent.setStartDate(LocalDate.now().minus(6, ChronoUnit.DAYS));
        ratingService.addRating(fourthStudent, 4);
        ratingService.addRating(fourthStudent, 3);
        ratingService.addRating(fourthStudent, 2);
        ratingService.addRating(fourthStudent, 2);
        ratingService.addRating(fourthStudent, 2);
        ratingService.addRating(fourthStudent, 5);

        StudentStatusService studentStatusService = new SimpleStudentsStatusService();

        studentStatusService.setRatingService(ratingService);

        EducationManagerService educationManagerService = new SimpleEducationManagerService();
        educationManagerService.setStudentStatusService(studentStatusService);

        IOService ioService = new SimpleIOService(studentStatusService);
        ioService.printStudentData(firstStudent);
        ioService.printStudentStatus(firstStudent);
        ioService.printStudentRatings(firstStudent);
        ioService.printStudentsList(educationManagerService.studentsSortedByAverageRate(studentService.getAllStudents()));
        System.out.println("------------------");
        ioService.printStudentsList(educationManagerService.studentsSortedByDaysBeforeTheEndOfEducation(studentService.getAllStudents()));
        System.out.println("------------------");
        ioService.printGoodStudents(studentService.getAllStudents());
    }
}
