package com.educ.service;

import com.educ.entity.Student;

import java.util.List;

public interface EducationManagerService {
    List<Student> studentsSortedByAverageRate(List<Student> students);

    List<Student> studentsSortedByDaysBeforeTheEndOfEducation(List<Student> students);

    StudentStatusService getStudentStatusService();

    void setStudentStatusService(StudentStatusService studentStatusService);

}
