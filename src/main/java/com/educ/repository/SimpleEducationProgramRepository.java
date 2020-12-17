package com.educ.repository;

import com.educ.entity.EducationProgram;

import java.util.LinkedList;
import java.util.List;

public class SimpleEducationProgramRepository implements EducationProgramsRepository {
    private final List<EducationProgram> allPrograms = new LinkedList<>();

    @Override
    public List<EducationProgram> getAllPrograms() {
        return allPrograms;
    }

    @Override
    public void addProgram(EducationProgram program) {
        allPrograms.add(program);
    }

}
