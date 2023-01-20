package com.e.campus.api;

import com.e.campus.model.Institute;
import com.e.campus.model.YuksekCourse;
import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.service.*;
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

    public InstituteController(InstituteService instituteService, YukLisansOgrenciService yukLisansOgrenciService , YuksekCourseService yuksekCourseService, FacultyService facultyService,  FacultyService facultyService1) {
        this.instituteService = instituteService;
        this.yukLisansOgrenciService = yukLisansOgrenciService;
        this.yuksekCourseService = yuksekCourseService;
        this.facultyService = facultyService1;
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
    public Institute updateInstitute(@PathVariable Long id, @RequestBody Institute institute) {
        Institute updateInstitute =instituteService.updateInstitute(id, institute);
        return updateInstitute;
    }

    @DeleteMapping("/institute/{id}")
    public String deleteInstitute(@PathVariable Long id) {
        instituteService.deleteInstitute(id);
        return "messqge deleted";
    }

    @PostMapping("/student/{studentId}/course/{courseId}/approve")
    public String approveCourseRegistration(@PathVariable Long yukStudentId, @PathVariable Long yukCourseId) {
        Optional<YukseklisansOgrenci> yukOgrenci = yukLisansOgrenciService.getYukLisansOgrenciById(yukStudentId);
        Optional<YuksekCourse> course = yuksekCourseService.getYukCourseById(yukCourseId);
        if(!yukOgrenci.isPresent() || !course.isPresent()){
            return "Student or course not found";
        }
        //Checking if student is undergraduate or graduate
        if(yukOgrenci.get().getYukOgrenciType().equals("Undergraduate")){
            //Routing request to faculty for approval
            boolean isApproved = facultyService.approveCourseRegistration(yukOgrenci.get(), course.get());
            if(isApproved)
                return "Course registration approved by faculty";
            else
                return "Course registration not approved by faculty";
        }
        else if(yukOgrenci.get().getYukOgrenciType().equals("Graduate")){
            //Routing request to institute for approval
            boolean isApproved = instituteService.approveYukCourseRegistration(yukOgrenci.get(), course.get());
            if(isApproved)
                return "Course registration approved by institute";
            else
                return "Course registration not approved by institute";
        }
        else
            return "Invalid student type";
    }


}
