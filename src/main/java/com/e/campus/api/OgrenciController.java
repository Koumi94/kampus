package com.e.campus.api;
import com.e.campus.model.Ogrenci;
import com.e.campus.service.OgrenciService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ogrenciler")
public class OgrenciController {

    private final OgrenciService ogrenciService;

    public OgrenciController(OgrenciService ogrenciService) {
        this.ogrenciService = ogrenciService;
    }


    @GetMapping
    public List<Ogrenci> getAllOgrenci() {
        return ogrenciService.getAllOgrenci();
    }

    @GetMapping("/ogrenci/{id}")
    public Optional<Ogrenci> getOgrenciById(@PathVariable Long id) {
        return ogrenciService.getOgrenciById(id);
    }

    @PostMapping
    public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci ) {
        return  ogrenciService.addOgrenci(ogrenci);
    }

    @PutMapping("/ogrenci/{id}")
    public Ogrenci updateOgrenci(@PathVariable Long id, @RequestBody Ogrenci ogrenci) {
        return ogrenciService.updateOgrenci(id, ogrenci);
    }

    @DeleteMapping("/ogrenci/{id}")
    public void deleteOgrenci(@PathVariable Long id) {
        ogrenciService.deleteOgrenci(id);
    }

}