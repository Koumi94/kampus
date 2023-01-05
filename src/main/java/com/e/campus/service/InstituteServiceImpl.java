package com.e.campus.service;

import com.e.campus.model.Institute;
import com.e.campus.repository.InstituteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImpl implements InstituteService{
    private final InstituteRepository instituteRepository;


    public InstituteServiceImpl(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }


    public List<Institute> getAllInstitute() {

        return instituteRepository.findAll();

    };

    public Institute addInstitute(Institute institute) {
        return  instituteRepository.save(institute);
    };


    public Institute findInstituteByID(Long id) {
        Institute institute =instituteRepository.findInstituteById(id);
        return  institute;
    }
}
