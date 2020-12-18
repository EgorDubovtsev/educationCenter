package com.educ.repository;

import com.educ.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class SimpleStudentsRatingRepository implements StudentsRatingRepository {
    private Map<Student, int[]> studentsRating = new HashMap<>();

    @Override
    public Map<Student, int[]> getStudentsRating() {
        return studentsRating;
    }

    @Override
    public void setStudentsRating(Map<Student, int[]> studentsRating) {
        this.studentsRating = studentsRating;
    }
}
