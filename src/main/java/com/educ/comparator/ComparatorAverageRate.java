package com.educ.comparator;

import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;
import com.educ.service.StudentStatusService;

import java.util.Comparator;

public class ComparatorAverageRate implements Comparator<Student> {
    private StudentStatusService studentStatusService;
    private StudentsRatingRepository studentsRatingRepository;

    public ComparatorAverageRate(StudentStatusService studentStatusService, StudentsRatingRepository studentsRatingRepository) {
        this.studentStatusService = studentStatusService;
        this.studentsRatingRepository = studentsRatingRepository;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return studentStatusService.averageRating(o1, studentsRatingRepository).compareTo(studentStatusService.averageRating(o2, studentsRatingRepository));
    }
}
