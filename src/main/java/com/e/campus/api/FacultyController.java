package com.e.campus.api;

import com.e.campus.model.Faculty;
import com.e.campus.model.Ogrenci;
import com.e.campus.service.FacultyService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/faculty/")
@RequiredArgsConstructor
public class FacultyController {
    private FacultyService facultyService;

    @GetMapping()
    public List<Faculty> getAllFaculty(){
        return facultyService.getAllFaculty();
    }
    @GetMapping("/addfaculty")
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return  facultyService.addFaculty(faculty);
    }

    @GetMapping("/{id}")
    public String findByID(@PathVariable String id){
        return facultyService.findFacultyByID(Long.valueOf(id)).toString();
    }

}
