package com.educ.entity;

import java.util.List;

public interface EducationProgram {
    List<Course> getCourses();

    String getProgramName();

    void setProgramName(String programName);

    void addCourse(Course course);

    int getDurationInDays();
}
