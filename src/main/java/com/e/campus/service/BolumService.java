package com.e.campus.service;

import com.e.campus.model.Bolum;

import java.util.List;
import java.util.Optional;

public interface BolumService {



    public List<Bolum> getAllBlum() ;

    public Bolum addBlum(Bolum bolum);


    public Optional<Bolum> findBlumByID(Long id);
}
