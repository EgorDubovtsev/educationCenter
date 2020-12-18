package com.educ.service;

import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;

public interface StudentStatusService {
    Integer daysBeforeTheEndOfTheProgram(Student student);

    Double averageRating(Student student, StudentsRatingRepository ratingRepository);

    boolean isStudentCanBeExpelled(Student student);

    RatingService getRatingService();

    void setRatingService(RatingService ratingService);

    int[] getStudentRatings(Student student);


}
