package com.educ.service;

import com.educ.entity.Student;

import java.util.Arrays;
import java.util.List;

public class SimpleIOService implements IOService {
    private StudentStatusService studentStatusService;

    public SimpleIOService(StudentStatusService studentStatusService) {
        this.studentStatusService = studentStatusService;
    }

    @Override
    public void printStudentsList(List<Student> studentList) {
        studentList.forEach(student -> System.out.println(student.toString() + " " +
                studentStatusService.averageRating(student, studentStatusService.getRatingService().getStudentsRatingRepository()) +
                " " + studentStatusService.daysBeforeTheEndOfTheProgram(student)));
    }

    @Override
    public void printStudentData(Student student) {
        System.out.println("STUDENT: " + student.getName() + " " + student.getSurname() +
                "\nID: " + student.getId() +
                "\nEDUCATION PROGRAM: " + student.getEducationProgram().getProgramName() +
                "\nSTART DATE: " + student.getStartDate() + "\n");
        System.out.println("COURSE\t\tDURATION(hrs)\n______________________________");
        System.out.println(student.getEducationProgram().toString());
    }

    @Override
    public void printStudentStatus(Student student) {
        System.out.println(student.getName() + " " + student.getSurname() + " - до окончания обучения по программе " + student.getEducationProgram().getProgramName() +
                " осталось " + studentStatusService.daysBeforeTheEndOfTheProgram(student) +
                " д. Средний балл: " + studentStatusService.averageRating(student,
                studentStatusService.getRatingService().getStudentsRatingRepository()));
        System.out.println(studentStatusService.isStudentCanBeExpelled(student) ? "Отчислить" : "Может продолжать обучение");
    }

    @Override
    public void printStudentRatings(Student student) {
        System.out.println("Marks: " + Arrays.toString(studentStatusService.getStudentRatings(student)));
    }

    @Override
    public void printGoodStudents(List<Student> students) {
        students.stream().filter(student -> !studentStatusService.isStudentCanBeExpelled(student)).forEach(System.out::println);
    }
}
