package com.educ.entity;


import java.time.LocalDate;
import java.util.Objects;

public class SimpleStudent implements Student {
    private int id;
    private String name;
    private String surname;
    private EducationProgram educationProgram;
    private LocalDate startDate;

    public SimpleStudent(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public EducationProgram getEducationProgram() {
        return educationProgram;
    }

    @Override
    public void setEducationProgram(EducationProgram educationProgram) {
        this.educationProgram = educationProgram;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleStudent that = (SimpleStudent) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;

        return Objects.equals(educationProgram, that.educationProgram);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (educationProgram != null ? educationProgram.hashCode() : 0);

        return result;
    }
}
