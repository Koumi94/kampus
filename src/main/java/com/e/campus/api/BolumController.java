package com.e.campus.api;

import com.e.campus.model.Bolum;

import com.e.campus.repository.BolumRepository;
import com.e.campus.service.BolumService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bolumler")
public class BolumController {

    private final BolumService bolumService;
    private final BolumRepository bolumRepository;
    public BolumController(BolumService bolumService, BolumRepository bolumRepository) {
        this.bolumService = bolumService;
        this.bolumRepository = bolumRepository;
    }
    @GetMapping
    public List<Bolum> getAllBolumler() {
        return bolumService.getAllBolumler();
    }
    @GetMapping("/bolum/{id}")
    public Optional<Bolum> getBolumById(@PathVariable Long id) {
        return bolumService.getBolumById(id);
    }
    @PostMapping("/addbolum")
    public ResponseEntity<Bolum> addBolum(@RequestBody Bolum bolum) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/bolumler/addbolum").toUriString());
        return ResponseEntity.created(uri).body(bolumService.addBolum(bolum));
    }
    @PutMapping("/bolum/{id}")
    public ResponseEntity<Bolum> updateBolum(@PathVariable Long id, @RequestBody Bolum bolum) {
        try {
            bolum.setId(id);
            Bolum updatedBolum = bolumRepository.save(bolum);
            return new ResponseEntity<>(updatedBolum, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/bolum/{id}")
    public ResponseEntity<String> deleteBolum(@PathVariable Long id) {
        try {
            bolumRepository.deleteById(id);
            return new ResponseEntity<>("Bolum has been deleted successfully", HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Bolum not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting bolum", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
