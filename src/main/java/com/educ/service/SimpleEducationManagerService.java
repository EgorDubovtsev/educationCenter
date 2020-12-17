package com.educ.service;

import com.educ.comparator.ComparatorAverageRate;
import com.educ.comparator.ComparatorTimeBeforeTheEnd;
import com.educ.entity.Student;
import com.educ.repository.StudentsRatingRepository;

import java.util.Arrays;
import java.util.List;

public class SimpleEducationManagerService implements EducationManagerService {
    private StudentStatusService studentStatusService;
    private StudentsRatingRepository studentsRatingRepository;

    public StudentsRatingRepository getStudentsRatingRepository() {
        return studentsRatingRepository;
    }

    public void setStudentsRatingRepository(StudentsRatingRepository studentsRatingRepository) {
        this.studentsRatingRepository = studentsRatingRepository;
    }

    public StudentStatusService getStudentStatusService() {
        return studentStatusService;
    }

    public void setStudentStatusService(StudentStatusService studentStatusService) {
        this.studentStatusService = studentStatusService;
    }

    @Override
    public boolean isStudentCanBeExpelled(Student student) {
        int[] studentRatings = studentsRatingRepository.getStudentsRating().get(student.getId());
        int dayBeforeTheEndOfEducation = studentStatusService.daysBeforeTheEndOfTheProgram(student);
        int countOfFutureRatings = dayBeforeTheEndOfEducation % 8;


        int[] bestRatings = Arrays.copyOf(studentRatings, studentRatings.length + countOfFutureRatings);
        for (int i = 0; i < countOfFutureRatings; i++) {
            bestRatings[studentRatings.length + i] = 5;
        }

        return Arrays.stream(bestRatings).average().orElse(0) > 4.5;
    }

    @Override
    public List<Student> studentsSortedByAverageRate(List<Student> students) {
        ComparatorAverageRate comparator = new ComparatorAverageRate(studentStatusService, studentsRatingRepository);
        students.sort(comparator);
        return students;
    }

    @Override
    public List<Student> studentsSortedByDaysBeforeTheEndOfEducation(List<Student> students) {
        ComparatorTimeBeforeTheEnd comparator = new ComparatorTimeBeforeTheEnd(studentStatusService);
        students.sort(comparator);
        return students;
    }
}
