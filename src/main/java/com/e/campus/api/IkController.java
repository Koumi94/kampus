package com.e.campus.api;


import com.e.campus.model.IK;
import com.e.campus.service.IkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/iks")
public class IkController {

    private final IkService ikService;

    public IkController(IkService ikService) {
        this.ikService = ikService;
    }


    @GetMapping
    public List<IK> getAllIk() {
        return ikService.getAllIk();
    }

    @GetMapping("/ik/{id}")
    public Optional<IK> getIkById(@PathVariable Long id) {
        return ikService.getIkById(id);
    }

    @PostMapping("/addik")
    public IK addIk(@RequestBody IK ik) {
        return ikService.addIk(ik);
    }

    @PutMapping("/ik/{id}")
    public IK updateIk(@PathVariable Long id, @RequestBody IK ik) {
        return ikService.updateIk(id, ik);
    }

    @DeleteMapping("/ik/{id}")
    public void deleteIk(@PathVariable Long id) {
        ikService.deleteIk(id);
    }

}
