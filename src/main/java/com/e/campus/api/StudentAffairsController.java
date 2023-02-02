package com.e.campus.api;
import com.e.campus.model.Ogrenci;
import com.e.campus.model.Course;
import com.e.campus.model.StudentAffairs;
import com.e.campus.repository.CourseRepository;
import com.e.campus.repository.OgrenciRepository;
import com.e.campus.repository.StudentAffairsRepository;
import com.e.campus.service.OgrenciService;
import com.e.campus.service.CourseService;
import com.e.campus.service.StudentAffService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-affairs")
public class StudentAffairsController {

    private final OgrenciService ogrenciService;
    private final CourseService courseService;
    private final OgrenciRepository ogrenciRepository;
    private final CourseRepository courseRepository;
    private final StudentAffairsRepository studentAffairsRepository;
    private final StudentAffService studentAffService;

    public StudentAffairsController(OgrenciService ogrenciService, CourseService courseService, OgrenciRepository ogrenciRepository, CourseRepository courseRepository, StudentAffairsRepository studentAffairsRepository, StudentAffService studentAffService) {
        this.ogrenciService = ogrenciService;
        this.courseService = courseService;
        this.ogrenciRepository = ogrenciRepository;
        this.courseRepository = courseRepository;
        this.studentAffairsRepository = studentAffairsRepository;
        this.studentAffService = studentAffService;
    }


    @PostMapping("")
    public StudentAffairs addFaculty(@RequestBody StudentAffairs studentAffairs) {
        return studentAffService.addStudentAffairs(studentAffairs);
    }

    @GetMapping("/ogrenciler")
    public List<Ogrenci> getAllStudents() {
        return ogrenciService.getAllOgrenci();
    }

    @GetMapping("/ogrenci/{id}")
    public Optional<Ogrenci> getStudentById(@PathVariable Long id) {
        return ogrenciService.getOgrenciById(id);
    }

    @PostMapping("/ogrenci")
    public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci ) {
        return ogrenciService.addOgrenci(ogrenci);
    }

    @PutMapping("/ogrenci/{id}")
    public ResponseEntity<Ogrenci> updateOgrenci(@PathVariable Long id, @RequestBody Ogrenci ogrenci) {
        try {
            ogrenci.setId(id);
            Ogrenci updatedOgrenci = ogrenciRepository.save(ogrenci);
            return new ResponseEntity<>(updatedOgrenci, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ogrenci/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            ogrenciRepository.deleteById(id);
            return new ResponseEntity<>("Ogrenci başarıyla silindi.", HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Ogrenci bulunamadı.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Ogrenci silinirken hata oluştu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public String assignStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Optional<Ogrenci> ogrenci = ogrenciService.getOgrenciById(studentId);
        Optional<Course> course = courseService.getCourseById(courseId);
        if(!ogrenci.isPresent() || !course.isPresent()){
            return "Öğrenci veya ders bulunamadı.";
        }
        ogrenci.get().addCourse(course.get());
        ogrenciService.updateOgrenci(ogrenci.get().getId(),ogrenci.get());
        return "ögrenci işler tarafından Öğrenci başarıyla derse atandı.";

    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }

    @GetMapping("/course/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/course")
    public Course addCourse(@RequestBody Course course ) {
        return courseService.addCourse(course);
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
