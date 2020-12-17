package com.educ.repository;

import java.util.HashMap;
import java.util.Map;

public class SimpleStudentsRatingRepository implements StudentsRatingRepository {
    private Map<Integer, int[]> studentsRating = new HashMap<>();

    @Override
    public Map<Integer, int[]> getStudentsRating() {
        return studentsRating;
    }

    @Override
    public void setStudentsRating(Map<Integer, int[]> studentsRating) {
        this.studentsRating = studentsRating;
    }
}
