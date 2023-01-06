package com.e.campus.service;

import com.e.campus.model.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    Faculty getFacultyById(Long id);
    Faculty addFaculty(Faculty faculty);
    Faculty updateFaculty(Long id, Faculty faculty);
    void deleteFaculty(Long id);
}
