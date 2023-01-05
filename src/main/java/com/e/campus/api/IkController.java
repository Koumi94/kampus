package com.e.campus.api;


import com.e.campus.model.IK;
import com.e.campus.service.IkService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ik/")
public class IkController {
    private IkService ikService;

    public IkController(IkService ikService) {
        this.ikService = ikService;
    }
    @GetMapping()
    public List<IK> getAllIk(){
        return ikService.getAllIk();
    }
    @GetMapping("/addik")
    public IK addIk(@RequestBody IK ik){
        return  ikService.addIk(ik);
    }

    @GetMapping("/{id}")
    public String findByID(@PathVariable String id){
        return ikService.findByID(Long.valueOf(id)).toString();
    }
}
