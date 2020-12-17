package com.educ.repository;

import java.util.Map;

public interface StudentsRatingRepository {
    Map<Integer, int[]> getStudentsRating();

    void setStudentsRating(Map<Integer, int[]> studentsRating);
}
