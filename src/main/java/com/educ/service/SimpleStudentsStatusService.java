package com.educ.service;

import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


public class SimpleStudentsStatusService implements StudentStatusService {
    private RatingService ratingService;

    @Override
    public Integer daysBeforeTheEndOfTheProgram(Student student) {
        Long daysOnEducation = student.getStartDate().until(LocalDate.now(), ChronoUnit.DAYS);

        return student.getEducationProgram().getDurationInDays() - daysOnEducation.intValue();
    }

    @Override
    public Double averageRating(Student student, StudentsRatingRepository ratingRepository) {
        return Arrays.stream(ratingRepository.getStudentsRating().get(student)).filter(rating->rating!=0).average().orElse(0);
    }

    @Override
    public boolean isStudentCanBeExpelled(Student student) {
        int[] studentRatings = ratingService.getStudentsRating().get(student);
        int[] bestRatings = Arrays.copyOf(studentRatings, studentRatings.length);

        for (int i = 1; i <= daysBeforeTheEndOfTheProgram(student); i++) {
            bestRatings[studentRatings.length -i] = 5;
        }

        return Arrays.stream(bestRatings).average().orElse(0) < 4.5;
    }

    @Override
    public RatingService getRatingService() {
        return ratingService;
    }

    @Override
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Override
    public int[] getStudentRatings(Student student) {
        return Arrays.stream(ratingService.getStudentsRating().get(student)).filter(mark->mark!=0).toArray();
    }

}
