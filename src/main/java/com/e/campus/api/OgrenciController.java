package com.e.campus.api;
import com.e.campus.model.Course;
import com.e.campus.model.Faculty;
import com.e.campus.model.Ogrenci;
import com.e.campus.repository.OgrenciRepository;
import com.e.campus.service.CourseService;
import com.e.campus.service.FacultyService;
import com.e.campus.service.OgrenciService;
import org.springframework.dao.EmptyResultDataAccessException;
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
    private final FacultyService facultyService;

    private final OgrenciRepository ogrenciRepository;

    public OgrenciController(OgrenciService ogrenciService, CourseService courseService, FacultyService facultyService, OgrenciRepository ogrenciRepository) {
        this.ogrenciService = ogrenciService;
        this.courseService = courseService;
        this.facultyService = facultyService;
        this.ogrenciRepository = ogrenciRepository;
    }


    @GetMapping
    public ResponseEntity<List<Ogrenci>> getAllOgrenci() {
        List<Ogrenci> ogrenciler = ogrenciService.getAllOgrenci();
        return new ResponseEntity<>(ogrenciler, HttpStatus.OK);
    }

    @GetMapping("/ogrenci/{ogrenci_id}")
    public ResponseEntity<Ogrenci> getOgrenciById(@PathVariable Long id) {
        Optional<Ogrenci> ogrenci = ogrenciService.getOgrenciById(id);
        if(!ogrenci.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ogrenci.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ogrenci> addOgrenci(@RequestBody Ogrenci ogrenci ) {
          ogrenciService.addOgrenci(ogrenci);
        return new ResponseEntity<>(ogrenci, HttpStatus.CREATED);
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
    public ResponseEntity<String> deleteOgrenci(@PathVariable Long id) {
        try {
            ogrenciRepository.deleteById(id);
            return new ResponseEntity<>("Bolum başarıyla silindi.", HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Bolum bulunamadı.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Bolum silinirken hata oluştu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ogrenci/{ogrenci_id}/course/{course_Id}")
    public ResponseEntity<String> addCourse(@PathVariable Long ogrenci_id, @PathVariable Long course_Id) {
        Optional<Ogrenci> ogrenci = ogrenciService.getOgrenciById(ogrenci_id);
        Optional<Course> course = courseService.getCourseById(course_Id);
        if(!ogrenci.isPresent() || !course.isPresent()){
            return new ResponseEntity<>("Öğrenci veya kurs mevcut değil", HttpStatus.BAD_REQUEST);
        }
        ogrenci.get().addCourse(course.get());
        ogrenciService.updateOgrenci(ogrenci.get().getId(),ogrenci.get());
        return new ResponseEntity<>("Ders, öğrenciye başarıyla eklendi", HttpStatus.OK);
    }

    @PutMapping("/faculties/{facultyId}/ogrenci/{ogrenciId}")
    public ResponseEntity<String> assignStudentToFaculty(@PathVariable Long facultyId, @PathVariable Long ogrenciId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        Optional<Ogrenci> student = ogrenciService.getOgrenciById(ogrenciId);
        if(!faculty.isPresent() || !student.isPresent()){
            return new ResponseEntity<>("Fakülte veya öğrenci bulunamadı", HttpStatus.BAD_REQUEST);
        }
        faculty.get().addStudent(student.get());
        facultyService.updateFaculty(faculty.get().getId(), faculty.get());
        return new ResponseEntity<>("Öğrenci başarıyla fakülteye atandı", HttpStatus.OK);
    }




}