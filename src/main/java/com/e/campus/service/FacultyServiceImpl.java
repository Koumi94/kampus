package com.e.campus.service;

import com.e.campus.model.Faculty;
import com.e.campus.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService{

    private  final FacultyRepository facultyRepository;


    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return null;
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return null;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        return null;
    }

    @Override
    public void deleteFaculty(Long id) {

    }

    ;


    public Optional<Faculty> findFacultyByID(Long id) {
        return facultyRepository.findById(id);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
}
