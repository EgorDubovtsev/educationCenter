package com.educ.service;

import com.educ.entity.Student;

import java.util.List;

public interface IOService {
    void printStudentsList(List<Student> studentList);

    void printStudentData(Student student);

    void printStudentStatus(Student student);

    void printStudentRatings(Student student);

    void printGoodStudents(List<Student> students);

}
