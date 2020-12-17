package com.educ;

import com.educ.entity.*;
import com.educ.repository.EducationProgramsRepository;
import com.educ.repository.SimpleEducationProgramRepository;
import com.educ.repository.SimpleStudentsRepository;
import com.educ.repository.StudentsRepository;

public class Main {
    public static void main(String[] args) {
        Student firstStudent = new SimpleStudent(1,"Ivanov","Ivan");
        Student secondStudent = new SimpleStudent(2,"Petrov","Petr");
        Student thirdStudent = new SimpleStudent(3,"Sidorov","Sidor");
        Student fourthStudent = new SimpleStudent(4,"Kuznetsov","Kuznets");

        StudentsRepository studentsRepository = new SimpleStudentsRepository();
        studentsRepository.addStudent(firstStudent);
        studentsRepository.addStudent(secondStudent);
        studentsRepository.addStudent(thirdStudent);
        studentsRepository.addStudent(fourthStudent);

        Course hibernateCourse = new BaseCourse("Hibernate Course",24);
        Course springCourse = new BaseCourse("Spring Course",16);
        Course javaFXCourse = new BaseCourse("JavaFX Course",8);
        Course webCourse = new BaseCourse("Web Course",30);

        EducationProgram firstEducationProgram = new SimpleEducationProgram();
        firstEducationProgram.addCourse(hibernateCourse);
        firstEducationProgram.addCourse(springCourse);
        firstEducationProgram.setProgramName("First Education Program");

        EducationProgram secondEducationProgram = new SimpleEducationProgram();
        secondEducationProgram.addCourse(javaFXCourse);
        secondEducationProgram.addCourse(webCourse);
        secondEducationProgram.addCourse(hibernateCourse);
        secondEducationProgram.setProgramName("Second Education Program");

        EducationProgramsRepository educationProgramsRepository = new SimpleEducationProgramRepository();
        educationProgramsRepository.addProgram(firstEducationProgram);
        educationProgramsRepository.addProgram(secondEducationProgram);
    }
}
