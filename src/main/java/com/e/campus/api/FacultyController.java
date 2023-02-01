package com.e.campus.api;

import com.e.campus.model.Bolum;
import com.e.campus.model.Course;
import com.e.campus.model.Faculty;
import com.e.campus.service.BolumService;
import com.e.campus.service.CourseService;
import com.e.campus.service.FacultyService;
import com.e.campus.service.OgrenciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private BolumService bolumService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private OgrenciService ogrenciService;

    @GetMapping("/faculty")
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.getAllFaculties();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    @GetMapping("/faculty/{faculty_Id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        if (!faculty.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(faculty.get(), HttpStatus.OK);
    }

    @PostMapping("/faculty")
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/faculty/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        Optional<Faculty> existingFaculty = facultyService.getFacultyById(id);
        if (!existingFaculty.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        faculty.setId(id);
        facultyService.updateFaculty(id, faculty);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }


    @DeleteMapping("/faculty/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/faculty/{facultyId}/bolum/{bolumId}")
    public ResponseEntity<Faculty> addBolumToFaculty(@PathVariable Long facultyId, @PathVariable Long bolumId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        Optional<Bolum> bolum = bolumService.getBolumById(bolumId);
        if (!faculty.isPresent() || !bolum.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            Bolum b = bolum.get();
            Faculty f =faculty.get();
            b.setFaculty(f);
            f.getBolums().add(b);
            bolumService.updateBolum(bolum.get().getId(), b);
            facultyService.updateFaculty(faculty.get().getId(), f);
            return new ResponseEntity<>(f, HttpStatus.CREATED);
    }


    @DeleteMapping("/faculty/{facultyId}/bolum/{bolumId}")
    public ResponseEntity<Void> removeBolumFromFaculty(@PathVariable Long facultyId, @PathVariable Long bolumId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if (!faculty.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bolumService.deleteBolum(bolumId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/faculty/{facultyId}/course")
    public ResponseEntity<Course> addCourseToFaculty(@PathVariable Long facultyId, @RequestBody Course course) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if(!faculty.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        course.setFaculty(faculty.get());
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping("/faculty/{facultyId}/course/{course_Id}")
    public ResponseEntity<Void> removeCourseFromFaculty(@PathVariable Long facultyId, @PathVariable Long courseId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        if(!faculty.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

