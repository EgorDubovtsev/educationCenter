package com.educ.repository;

import com.educ.entity.Student;

import java.util.LinkedList;
import java.util.List;

public class SimpleStudentsRepository implements StudentsRepository {
    private final List<Student> allStudents = new LinkedList<>();

    @Override
    public List<Student> getAllStudents() {
        return allStudents;
    }

    @Override
    public void addStudent(Student student) {
        allStudents.add(student);
    }
}
