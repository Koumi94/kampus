package com.e.campus.service;

import com.e.campus.model.Ogrenci;
import com.e.campus.repository.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OgrenciServiceImpl implements OgrenciService{


    private  final OgrenciRepository ogrenciRepository;


    public OgrenciServiceImpl(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    public Ogrenci addOgrenci(Ogrenci ogrenci) {
        this.ogrenciRepository.save(ogrenci);
        return ogrenci;
    };
    public String findByID(String id) {
        this.ogrenciRepository.findById(id);
        return (id);
    }
}
