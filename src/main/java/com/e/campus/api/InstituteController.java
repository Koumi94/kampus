package com.e.campus.api;

import com.e.campus.model.Course;
import com.e.campus.model.Institute;
import com.e.campus.model.YuksekCourse;
import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.repository.InstituteRepository;
import com.e.campus.service.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/institutes")
public class InstituteController {

    private final InstituteService instituteService;
    private final YukLisansOgrenciService yukLisansOgrenciService;
    private final YuksekCourseService yuksekCourseService;
    private final FacultyService facultyService;

    private final InstituteRepository instituteRepository;

    public InstituteController(InstituteService instituteService, YukLisansOgrenciService yukLisansOgrenciService , YuksekCourseService yuksekCourseService, FacultyService facultyService, FacultyService facultyService1, InstituteRepository instituteRepository) {
        this.instituteService = instituteService;
        this.yukLisansOgrenciService = yukLisansOgrenciService;
        this.yuksekCourseService = yuksekCourseService;
        this.facultyService = facultyService1;
        this.instituteRepository = instituteRepository;
    }


    @GetMapping
    public List<Institute> getAllInstitute() {
        return instituteService.getAllInstitute();
    }

    @GetMapping("/institute/{id}")
    public Institute getInstituteById(@PathVariable Long id) {
        return instituteService.getInstituteById(id);
    }

    @PostMapping("/addinstituty")
    public Institute addInstitute(@RequestBody Institute institute ) {
        return  instituteService.addInstitute(institute);
    }

    @PutMapping("/institute/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable Long id, @RequestBody Institute institute) {
        try {
            institute.setId(id);
            Institute updatedInstitute = instituteRepository.save(institute);
            return new ResponseEntity<>(updatedInstitute, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/institute/{id}")
    public ResponseEntity<String> deleteInstitute(@PathVariable Long id) {
        try {
            instituteRepository.deleteById(id);
            return new ResponseEntity<>("Course has been deleted successfully", HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting course", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/student/{studentId}/course/{courseId}/approve")
    public String approveCourseRegistration(@PathVariable Long yukStudentId, @PathVariable Long yukCourseId) {
        Optional<YukseklisansOgrenci> yukOgrenci = yukLisansOgrenciService.getYukLisansOgrenciById(yukStudentId);
        Optional<YuksekCourse> course = yuksekCourseService.getYukCourseById(yukCourseId);
        if(!yukOgrenci.isPresent() || !course.isPresent()){
            return "Öğrenci veya kurs bulunamadı";
        }
        //Checking if student is undergraduate or graduate
        if(yukOgrenci.get().getYukOgrenciType().equals("Undergraduate")){
            //Routing request to faculty for approval
            boolean isApproved = facultyService.approveCourseRegistration(yukOgrenci.get(), course.get());
            if(isApproved)
                return "Fakülte tarafından onaylanan ders kaydı.";
            else
                return "Fakülte tarafından onaylanmayan ders kaydı.";
        }
        else if(yukOgrenci.get().getYukOgrenciType().equals("Graduate")){
            //Routing request to institute for approval
            boolean isApproved = instituteService.approveYukCourseRegistration(yukOgrenci.get(), course.get());
            if(isApproved)
                return "Enstitü tarafından onaylanan ders kaydı.";
            else
                return "Enstitü tarafından onaylanmayan ders kaydı";
        }
        else
            return "Geçersiz öğrenci türü";
    }


}
