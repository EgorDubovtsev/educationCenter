package com.educ.comparator;

import com.educ.entity.Student;
import com.educ.service.StudentStatusService;

import java.util.Comparator;

public class ComparatorTimeBeforeTheEnd implements Comparator<Student> {
    private StudentStatusService studentStatusService;

    public ComparatorTimeBeforeTheEnd(StudentStatusService studentStatusService) {
        this.studentStatusService = studentStatusService;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return studentStatusService.daysBeforeTheEndOfTheProgram(o1).compareTo(studentStatusService.daysBeforeTheEndOfTheProgram(o2));
    }
}
