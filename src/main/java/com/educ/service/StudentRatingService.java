package com.educ.service;

import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;

import java.util.Arrays;
import java.util.Map;

public class StudentRatingService implements RatingService {
    private StudentsRatingRepository studentsRatingRepository;

    public StudentRatingService(StudentsRatingRepository studentsRatingRepository) {
        this.studentsRatingRepository = studentsRatingRepository;
    }

    @Override
    public StudentsRatingRepository getStudentsRatingRepository() {
        return studentsRatingRepository;
    }

    private void addStudentIfDoesNotExist(Student student) {
        if (studentsRatingRepository.getStudentsRating().get(student) == null) {
            studentsRatingRepository.getStudentsRating().put(student, new int[student.getEducationProgram().getDurationInDays()]);
        }
    }

    @Override
    public void addRating(Student student, int rating) {
        addStudentIfDoesNotExist(student);

        Long countOfRatings = countOfRatings(student);
        int[] studentRatings = studentsRatingRepository.getStudentsRating().get(student);

        if (studentRatings.length == countOfRatings) {
            throw new IllegalArgumentException("Student have all ratings");
        }
        studentsRatingRepository.getStudentsRating().get(student)[countOfRatings.intValue()] = rating;
    }

    @Override
    public long countOfRatings(Student student) {
        return Arrays.stream(studentsRatingRepository.getStudentsRating().get(student)).filter(rate -> rate != 0).count();
    }

    @Override
    public Map<Student, int[]> getStudentsRating() {
        return studentsRatingRepository.getStudentsRating();
    }
}
