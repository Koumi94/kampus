package com.e.campus.api;

import com.e.campus.model.Ogrenci;
import com.e.campus.service.OgrenciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OgrenciController {
    private OgrenciService ogrenciService;
    
    @GetMapping("../addogrenci")
    public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci){
        return  ogrenciService.addOgrenci(ogrenci);
    }
    
    @GetMapping("../{id}/ogrenci")
    public String findByID(@PathVariable Ogrenci id){
        return  ogrenciService.findByID(String.valueOf(id)).toString();
    }

    


}
