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

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    };


    public Optional<Faculty> findFacultyByID(Long id) {
        return facultyRepository.findById(id);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
}
