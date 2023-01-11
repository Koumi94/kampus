package com.e.campus.service;

import com.e.campus.model.Bolum;

import java.util.List;

public interface BolumService {
    List<Bolum> getAllBolumler();
    Object getBolumById(Long id);
    Bolum addBolum(Bolum bolum);
    Bolum updateBolum(Long id, Bolum bolum);
    Bolum deleteBolum(Long id);
}