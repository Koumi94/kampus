package com.e.campus.service;

import com.e.campus.model.Bolum;
import com.e.campus.repository.BolumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BolumServiceImpl implements BolumService {
    private final BolumRepository bolumRepository;

    public BolumServiceImpl(BolumRepository bolumRepository) {
        this.bolumRepository = bolumRepository;
    }

    @Override
    public List<Bolum> getAllBolumler() {
        return bolumRepository.findAll();
    }
    @Override
    public Optional<Bolum> getBolumById(Long id) {
        return bolumRepository.findById(id);
    }
    @Override
    public Bolum addBolum(Bolum bolum) {
        return bolumRepository.save(bolum);
    }
    @Override
    public Bolum updateBolum(long id, Bolum bolum) {
        return bolumRepository.save(bolum);
    }
    @Override
    public Bolum  deleteBolum(Long id) {
        return null;
    }




    //@Override
    //public List<Bolum> getAllBolumsForFaculty(Faculty faculty) {
     //  return bolumRepository.findByFaculty(faculty);
    //}

    //@Override
   // public List<Bolum> getAllBolumsForFaculty(Faculty faculty) {
     //   if (faculty == null) {
     //       throw new IllegalArgumentException("Faculty object cannot be null");
       // }
     //   List<Bolum> bolumList = bolumRepository.findByFaculty(faculty);
     //   if (bolumList == null) {
      //      throw new NullPointerException("No bolum found for the given faculty");
      //  }
        //return bolumList;
   // }


}
