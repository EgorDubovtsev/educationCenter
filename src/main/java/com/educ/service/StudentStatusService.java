package com.educ.service;

import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;

public interface StudentStatusService {
    Integer daysBeforeTheEndOfTheProgram(Student student);

    Double averageRating(Student student, StudentsRatingRepository ratingRepository);
}
