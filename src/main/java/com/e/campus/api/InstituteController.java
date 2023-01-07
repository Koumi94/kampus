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
    public Optional<IK> getIkById(@PathVariable Long id) {
        return instituteService.getInstituteById(id);
    }

    @PostMapping
    public InstituteService addInstitute(@RequestBody Institute institute ) {
        return (InstituteService) instituteService.addInstitute(institute);
    }

    @PutMapping("/institute/{id}")
    public IK updateIk(@PathVariable Long id, @RequestBody IK ik) {
        return instituteService.updateInstitute(id, ik);
    }

    @DeleteMapping("/institute/{id}")
    public void deleteInstitute(@PathVariable Long id) {
        instituteService.deleteInstitute(id);
    }

}
