package com.e.campus.service;

import com.e.campus.model.Ogrenci;
import com.e.campus.repository.OgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OgrenciServiceImpl implements OgrenciService{

    private  final OgrenciRepository ogrenciRepository;



    public OgrenciServiceImpl(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    public Ogrenci addIk(Ogrenci ogrenci) {
        return ogrenciRepository.save(ogrenci);
    }

    @Override
    public Ogrenci updateOgrenci(Long id, Ogrenci ogrenci) {
        return null;
    }

    @Override
    public void deleteOgrenci(Long id) {

    }

    ;


    public Optional<Ogrenci> findByID(Long id) {
        return ogrenciRepository.findById(id);
    }

    public List<Ogrenci> getAllOgrenci() {
        return ogrenciRepository.findAll();
    }

    @Override
    public Optional<Ogrenci> getOgrenciById(Long id) {
        return Optional.empty();
    }

    @Override
    public Ogrenci addOgrenci(Ogrenci bolum) {
        return null;
    }
}

