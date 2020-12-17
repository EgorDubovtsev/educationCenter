package com.educ.repository;

import com.educ.entity.Student;

import java.util.List;

public interface StudentsRepository {
    List<Student> getAllStudents();

    void addStudent(Student student);
}
