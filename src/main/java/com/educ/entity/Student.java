package com.educ.entity;

import java.time.LocalDate;

public interface Student {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

    EducationProgram getEducationProgram();

    void setEducationProgram(EducationProgram educationProgram);

    LocalDate getStartDate();

    void setStartDate(LocalDate startDate);
}
