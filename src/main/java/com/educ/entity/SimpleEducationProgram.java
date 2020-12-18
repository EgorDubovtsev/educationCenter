package com.educ.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimpleEducationProgram implements EducationProgram {
    private String programName;
    private final List<Course> courses = new LinkedList<>();
    private int durationInDays;

    @Override
    public int getDurationInDays() {
        if (durationInDays == 0) {
            durationInDays = courses.stream().mapToInt(Course::getDuration).sum() / 8;
        }

        return durationInDays;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String getProgramName() {
        return programName;
    }

    @Override
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return courses.stream().map(course -> course.toString() + "\n").collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleEducationProgram that = (SimpleEducationProgram) o;

        if (!Objects.equals(programName, that.programName)) return false;
        return Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        int result = programName != null ? programName.hashCode() : 0;
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        return result;
    }
}
