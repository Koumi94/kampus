package com.e.campus.api;


import com.e.campus.model.Bolum;
import com.e.campus.model.Course;
import com.e.campus.repository.CourseRepository;
import com.e.campus.service.CourseService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private  final CourseRepository courseRepository;

    public CourseController(CourseService courseService, CourseRepository courseRepository) {
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/course/{course_Id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/course/addcourse").toUriString());
        return ResponseEntity.created(uri).body(courseService.addCourse(course));
    }


    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        try {
            course.setId(id);
            Course updatedCourse = courseRepository.save(course);
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        try {
            courseRepository.deleteById(id);
            return new ResponseEntity<>("Ders başarıyla silindi.", HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Ders bulunamadı.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Ders silinirken hata oluştu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
