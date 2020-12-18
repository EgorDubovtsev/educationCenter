package com.educ.service;

import com.educ.comparator.ComparatorAverageRate;
import com.educ.comparator.ComparatorTimeBeforeTheEnd;
import com.educ.entity.Student;

import java.util.Collections;
import java.util.List;

public class SimpleEducationManagerService implements EducationManagerService {
    private StudentStatusService studentStatusService;

    @Override
    public StudentStatusService getStudentStatusService() {
        return studentStatusService;
    }

    @Override
    public void setStudentStatusService(StudentStatusService studentStatusService) {
        this.studentStatusService = studentStatusService;
    }

    @Override
    public List<Student> studentsSortedByAverageRate(List<Student> students) {
        ComparatorAverageRate comparator = new ComparatorAverageRate(studentStatusService, studentStatusService.getRatingService().getStudentsRatingRepository());
        students.sort(comparator);
        Collections.reverse(students);

        return students;
    }

    @Override
    public List<Student> studentsSortedByDaysBeforeTheEndOfEducation(List<Student> students) {
        ComparatorTimeBeforeTheEnd comparator = new ComparatorTimeBeforeTheEnd(studentStatusService);
        students.sort(comparator);

        return students;
    }

}
