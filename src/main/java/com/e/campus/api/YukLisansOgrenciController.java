package com.e.campus.api;


import com.e.campus.model.YukseklisansOgrenci;


import com.e.campus.service.YukLisansOgrenciService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/YukLisansOgrenci")
public class YukLisansOgrenciController {

    private final YukLisansOgrenciService yukLisansOgrenciService;

    public YukLisansOgrenciController(YukLisansOgrenciService yukLisansOgrenciService) {
        this.yukLisansOgrenciService = yukLisansOgrenciService;
    }


    @GetMapping
    public List<YukseklisansOgrenci> getAllYukLisansOgrenci() {
        return yukLisansOgrenciService.getAllYukLisansOgrenci();
    }

    @GetMapping("/YukLisansOgrenci/{id}")
    public Optional<YukseklisansOgrenci> getYukLisansOgrenciById(@PathVariable Long id) {
        return yukLisansOgrenciService.getYukLisansOgrenciById(id);
    }

    @PostMapping("/addYukLisansOgrenci")
    public YukseklisansOgrenci addYukLisansOgrenci(@RequestBody YukseklisansOgrenci yukLisansOgrenci ) {
        return  yukLisansOgrenciService.addYukLisansOgrenci(yukLisansOgrenci);
    }



    @PutMapping("/addYukLisansOgrenci/{id}")
    public YukseklisansOgrenci updateYukLisansOgrenci(@PathVariable Long id, @RequestBody YukseklisansOgrenci yukseklisansOgrenci) {
        return yukLisansOgrenciService.updateYukLisansOgrenci(id, yukseklisansOgrenci);
    }

    @DeleteMapping("/YukLisansOgrenci/{id}")
    public String deleteYukLisansOgrenci(@PathVariable Long id) {
        yukLisansOgrenciService.deleteYukLisansOgrenci(id);
        return "messqge suprimer";
    }

}

