package com.e.campus.api;

import com.e.campus.model.IK;
import com.e.campus.model.Institute;
import com.e.campus.service.InstituteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/institutes")
public class InstituteController {

    private final InstituteService instituteService;

    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }


    @GetMapping
    public List<Institute> getAllInstitute() {
        return instituteService.getAllInstitute();
    }

    @GetMapping("/institute/{id}")
    public Institute getIkById(@PathVariable Long id) {
        return instituteService.getInstituteById(id);
    }

    @PostMapping("/addinstituty")
    public Institute addInstitute(@RequestBody Institute institute ) {
        return  instituteService.addInstitute(institute);
    }

    @PutMapping("/institute/{id}")
    public Institute updateInstitute(@PathVariable Long id, @RequestBody Institute institute) {
        return instituteService.updateInstitute(id, institute);
    }

    @DeleteMapping("/institute/{id}")
    public void deleteInstitute(@PathVariable Long id) {
        instituteService.deleteInstitute(id);
    }

}
