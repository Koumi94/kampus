package com.e.campus.api;

import com.e.campus.model.Bolum;
import com.e.campus.service.BolumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bolum/")
@RequiredArgsConstructor
public class BolumController {
    private BolumService bolumService;

    @GetMapping()
    public List<Bolum> getAllBlum(){
        return bolumService.getAllBlum();
    }
    @GetMapping("addbolum")
    public Bolum addFaculty(@RequestBody Bolum bolum){
        return  bolumService.addBlum(bolum);
    }

    @GetMapping("{id}")
    public String findBlumByID(@PathVariable String id){
        return bolumService.findBlumByID(Long.valueOf(id)).toString();
    }
}
