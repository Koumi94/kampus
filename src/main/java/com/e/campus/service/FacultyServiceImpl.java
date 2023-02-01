package com.e.campus.service;

import com.e.campus.model.Bolum;
import com.e.campus.model.Faculty;
import com.e.campus.model.YuksekCourse;
import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.repository.BolumRepository;
import com.e.campus.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService{

    private  final FacultyRepository facultyRepository;
    private final BolumRepository bolumRepository;


    public FacultyServiceImpl(FacultyRepository facultyRepository, BolumRepository bolumRepository) {
        this.facultyRepository = facultyRepository;
        this.bolumRepository = bolumRepository;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        return null;
    }

    @Override
    public boolean approveCourseRegistration(YukseklisansOgrenci yukseklisansOgrenci, YuksekCourse yuksekCourse) {
        return false;
    }

    ;


    public Optional<Faculty> findFacultyByID(Long id) {
        return facultyRepository.findById(id);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public List<Bolum> getAllBolumsForFaculty(Faculty faculty) {
        return bolumRepository.findByFaculty(faculty);
    }
}
