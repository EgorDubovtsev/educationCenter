package com.educ.service;

import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;

import java.util.Map;

public interface RatingService {
    void addRating(Student student, int rating);

    long countOfRatings(Student student);

    Map<Student, int[]> getStudentsRating();

    StudentsRatingRepository getStudentsRatingRepository();
}
