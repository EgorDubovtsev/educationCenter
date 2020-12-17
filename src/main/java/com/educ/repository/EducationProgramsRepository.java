package com.educ.repository;

import com.educ.entity.EducationProgram;

import java.util.List;

public interface EducationProgramsRepository {
    List<EducationProgram> getAllPrograms();
    void addProgram(EducationProgram program);

}
