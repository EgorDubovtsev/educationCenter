package com.educ.service;

import com.educ.entity.Course;
import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


public class SimpleStudentsStatusService implements StudentStatusService {

    @Override
    public Integer daysBeforeTheEndOfTheProgram(Student student) {
        Long daysOnEducation = student.getStartDate().until(LocalDate.now(), ChronoUnit.DAYS);
        return (student.getEducationProgram().getCourses().stream()
                .map(Course::getDuration).mapToInt(Integer::valueOf).sum() / 8) - daysOnEducation.intValue();
    }

    @Override
    public Double averageRating(Student student, StudentsRatingRepository ratingRepository) {
        return Arrays.stream(ratingRepository.getStudentsRating().get(student.getId())).average().orElse(0);
    }
}
