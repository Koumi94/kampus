package com.e.campus.service;

import com.e.campus.model.Bolum;
import com.e.campus.repository.BolumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BolumServiceImpl implements BolumService{

    private final BolumRepository bolumRepository;


    public BolumServiceImpl(BolumRepository bolumRepository) {
        this.bolumRepository = bolumRepository;
    }

    public List<Bolum> getAllBlum() {

        return bolumRepository.findAll();

    };

    public Bolum addBlum(Bolum bolum) {
        return  bolumRepository.save(bolum);
    };


    public Optional<Bolum> findBlumByID(Long id) {
        return  bolumRepository.findById(id);
    }
}
