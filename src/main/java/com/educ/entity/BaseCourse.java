package com.educ.entity;

public class BaseCourse implements Course {
    private String courseName;
    private int durationInHours;

    public BaseCourse(String courseName, int durationInHours) {
        this.courseName = courseName;
        this.durationInHours = durationInHours;
    }


    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int getDuration() {
        return durationInHours;
    }

    @Override
    public void setDuration(int duration) {
        this.durationInHours = duration;
    }
}
