package com.e.campus.service;

import com.e.campus.model.Faculty;
import com.e.campus.model.YuksekCourse;
import com.e.campus.model.YukseklisansOgrenci;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    Optional<Faculty> getFacultyById(Long id);
    Faculty addFaculty(Faculty faculty);
    Faculty updateFaculty(Long id, Faculty faculty);
    Faculty deleteFaculty(Long id);

    boolean approveCourseRegistration(YukseklisansOgrenci yukseklisansOgrenci, YuksekCourse yuksekCourse);
}
