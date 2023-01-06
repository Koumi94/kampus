package com.e.campus.service;

import com.e.campus.model.Bolum;

import java.util.List;

public interface BolumService {
    List<Bolum> getAllBolumler();
    Bolum getBolumById(Long id);
    Bolum addBolum(Bolum bolum);
    Bolum updateBolum(Long id, Bolum bolum);
    void deleteBolum(Long id);
}