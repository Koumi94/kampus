package com.e.campus.api;
import com.e.campus.model.Ogrenci;
import com.e.campus.model.Course;
import com.e.campus.service.OgrenciService;
import com.e.campus.service.CourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-affairs")
public class StudentAffairsController {

    private final OgrenciService ogrenciService;
    private final CourseService courseService;

    public StudentAffairsController(OgrenciService ogrenciService, CourseService courseService) {
        this.ogrenciService = ogrenciService;
        this.courseService = courseService;
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
    public Ogrenci updateOgrenci(@PathVariable Long id, @RequestBody Ogrenci ogrenci) {
        return ogrenciService.updateOgrenci(id, ogrenci);
    }

    @DeleteMapping("/ogrenci/{id}")
    public void deleteStudent(@PathVariable Long id) {
        ogrenciService.deleteOgrenci(id);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public String assignStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Optional<Ogrenci> ogrenci = ogrenciService.getOgrenciById(studentId);
        Optional<Course> course = courseService.getCourseById(courseId);
        if(!ogrenci.isPresent() || !course.isPresent()){
            return "Student or course not found";
        }
        ogrenci.get().addCourse(course.get());
        ogrenciService.updateOgrenci(ogrenci.get().getId(),ogrenci.get());
        return "Student successfully assigned to course";

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
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
