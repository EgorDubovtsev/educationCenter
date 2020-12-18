package com.educ.repository;

import com.educ.entity.Student;

import java.util.Map;

public interface StudentsRatingRepository {
    Map<Student, int[]> getStudentsRating();

    void setStudentsRating(Map<Student, int[]> studentsRating);
}
