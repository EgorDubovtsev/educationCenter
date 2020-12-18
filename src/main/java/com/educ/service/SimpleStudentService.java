package com.educ.service;

import com.educ.entity.Student;
import com.educ.repository.StudentsRepository;

import java.util.List;

public class SimpleStudentService implements StudentService {
    private StudentsRepository studentsRepository;

    public SimpleStudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public StudentsRepository getStudentsRepository() {
        return studentsRepository;
    }

    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentsRepository.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        studentsRepository.addStudent(student);
    }


}
