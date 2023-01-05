package com.e.campus.service;

import com.e.campus.model.Faculty;

import java.util.List;
import java.util.Optional;


public interface FacultyService {



    public Faculty addFaculty(Faculty faculty) ;


    public Optional<Faculty> findFacultyByID(Long id) ;
    public List<Faculty> getAllFaculty() ;
}
