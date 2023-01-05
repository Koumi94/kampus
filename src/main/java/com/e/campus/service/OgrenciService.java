package com.e.campus.service;

import com.e.campus.model.Ogrenci;
import com.e.campus.repository.OgrenciRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


public interface OgrenciService {





    public Ogrenci addOgrenci(Ogrenci ogrenci);

    public String findByID(String id) ;
}
