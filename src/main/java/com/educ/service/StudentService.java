package com.educ.service;

import com.educ.entity.Student;
import com.educ.repository.StudentsRepository;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void addStudent(Student student);

    StudentsRepository getStudentsRepository();

    void setStudentsRepository(StudentsRepository studentsRepository);
}
