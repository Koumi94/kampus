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

    @GetMapping("/{id}")
    public Bolum getBolumById(@PathVariable Long id) {
        return bolumService.getBolumById(id);
    }

    @PostMapping
    public Bolum addBolum(@RequestBody Bolum bolum) {
        return bolumService.addBolum(bolum);
    }

    @PutMapping("/{id}")
    public Bolum updateBolum(@PathVariable Long id, @RequestBody Bolum bolum) {
        return bolumService.updateBolum(id, bolum);
    }

    @DeleteMapping("/{id}")
    public void deleteBolum(@PathVariable Long id) {
        bolumService.deleteBolum(id);
    }

}
