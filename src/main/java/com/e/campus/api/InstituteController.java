package com.e.campus.api;

import com.e.campus.model.Institute;
import com.e.campus.service.InstituteService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institute/")
public class InstituteController {
    private InstituteService instituteService;

    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @GetMapping()
    public List<Institute> getAllInstitute(){
        return instituteService.getAllInstitute();
    }
    @GetMapping("/addInstitute")
    public Institute addInstitute(@RequestBody Institute institute){
        return  instituteService.addInstitute(institute);
    }

    @GetMapping("/{id}")
    public String findInstituteByID(@PathVariable String id){
        return instituteService.findInstituteByID(Long.valueOf(id)).toString();
    }
}
