package com.educ.service;

import com.educ.entity.EducationProgram;
import com.educ.repository.EducationProgramsRepository;

public class SimpleEducationProgramService implements EducationProgramService {
    private EducationProgramsRepository educationProgramsRepository;

    public SimpleEducationProgramService(EducationProgramsRepository educationProgramsRepository) {
        this.educationProgramsRepository = educationProgramsRepository;
    }

    @Override
    public void addProgram(EducationProgram educationProgram) {
        educationProgramsRepository.addProgram(educationProgram);
    }
}
