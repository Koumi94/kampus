package com.e.campus.service;

import com.e.campus.model.Ogrenci;

import java.util.List;
import java.util.Optional;


public interface OgrenciService {
    List<Ogrenci> getAllOgrenci();
    Optional<Ogrenci> getOgrenciById(Long id);
    Ogrenci addOgrenci(Ogrenci bolum);
    Ogrenci updateOgrenci(Long id, Ogrenci bolum);
    void deleteOgrenci(Long id);
}