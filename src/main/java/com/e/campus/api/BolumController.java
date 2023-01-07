package com.e.campus.api;

import com.e.campus.model.Bolum;

import com.e.campus.service.BolumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bolumler")
public class BolumController {

    private final BolumService bolumService;

    public BolumController(BolumService bolumService) {
        this.bolumService = bolumService;
    }

    @GetMapping
    public List<Bolum> getAllBolumler() {
        return bolumService.getAllBolumler();
    }

    @GetMapping("/bolum/{id}")
    public Bolum getBolumById(@PathVariable Long id) {
        return bolumService.getBolumById(id);
    }

    @PostMapping("/addbolum")
    public Bolum addBolum(@RequestBody Bolum bolum) {
        return bolumService.addBolum(bolum);
    }

    @PutMapping("/bolum/{id}")
    public Bolum updateBolum(@PathVariable Long id, @RequestBody Bolum bolum) {
        return bolumService.updateBolum(id, bolum);
    }

    @DeleteMapping("/bolum/{id}")
    public String deleteBolum(@PathVariable Long id) {
        return "succesul";
    }

}
