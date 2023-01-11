package com.e.campus.api;
import com.e.campus.model.Course;
import com.e.campus.model.Ogrenci;
import com.e.campus.service.CourseService;
import com.e.campus.service.OgrenciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ogrenciler")
public class OgrenciController {

    private final OgrenciService ogrenciService;
    private final CourseService courseService;

    public OgrenciController(OgrenciService ogrenciService, CourseService courseService) {
        this.ogrenciService = ogrenciService;
        this.courseService = courseService;
    }


    @GetMapping
    public List<Ogrenci> getAllOgrenci() {
        return ogrenciService.getAllOgrenci();
    }

    @GetMapping("/ogrenci/{ogrenci_id}")
    public Optional<Ogrenci> getOgrenciById(@PathVariable Long id) {
        return ogrenciService.getOgrenciById(id);
    }

    @PostMapping
    public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci ) {
        return  ogrenciService.addOgrenci(ogrenci);
    }

    @PutMapping("/ogrenci/{ogrenci_id}")
    public Ogrenci updateOgrenci(@PathVariable Long id, @RequestBody Ogrenci ogrenci) {
        return ogrenciService.updateOgrenci(id, ogrenci);
    }

    @DeleteMapping("/ogrenci/{ogrenci_id}")
    public void deleteOgrenci(@PathVariable Long id) {
        ogrenciService.deleteOgrenci(id);
    }

    @PostMapping("/ogrenci/{ogrenci_id}/course/{course_Id}")
    public ResponseEntity<String> addCourse(@PathVariable Long ogrenci_id, @PathVariable Long course_Id) {
        Optional<Ogrenci> student = ogrenciService.getOgrenciById(ogrenci_id);
        Optional<Course> course = courseService.getCourseById(course_Id);
        if(!student.isPresent() || !course.isPresent()){
            return new ResponseEntity<>("Student or course does not exist", HttpStatus.BAD_REQUEST);
        }
        student.get().addCourse(course.get());
        ogrenciService.updateOgrenci(student.get().getId(),student.get());
        return new ResponseEntity<>("Course added successfully to student", HttpStatus.OK);
    }



}