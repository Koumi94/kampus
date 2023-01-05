package com.e.campus.api;

import com.e.campus.model.Institute;
import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.service.InstituteService;
import com.e.campus.service.YukLisansOgrenciService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/master_degree/")
@RequiredArgsConstructor
public class YukLisansOgrenciController {
    private YukLisansOgrenciService yukLisansOgrenciService;

    public YukLisansOgrenciController(YukLisansOgrenciService yukLisansOgrenciService) {
        this.yukLisansOgrenciService = yukLisansOgrenciService;
    }

    @GetMapping()
    public List<YukseklisansOgrenci> getAllInstituteOgrenci(){
        return yukLisansOgrenciService.getAllInstituteOgrenci();
    }
    @GetMapping("/addinstituteogrenci")
    public YukseklisansOgrenci addInstituteOgrenci(@RequestBody YukseklisansOgrenci yukseklisansOgrenci){
        return  yukLisansOgrenciService.addInstituteOgrenci(yukseklisansOgrenci);
    }
}
