package com.e.campus.service;

import com.e.campus.model.Institute;
import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.repository.YukLisansOgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YukLisansOgrenciServiceImpl implements YukLisansOgrenciService{

    private final YukLisansOgrenciRepository yukLisansOgrenciRepository;



    public YukLisansOgrenciServiceImpl(YukLisansOgrenciRepository yukLisansOgrenciRepository) {
        this.yukLisansOgrenciRepository = yukLisansOgrenciRepository;
    }

    public YukseklisansOgrenci addInstituteOgrenci(YukseklisansOgrenci yukseklisansOgrenci) {
        return yukLisansOgrenciRepository.save(yukseklisansOgrenci);

    }

    @Override
    public List<YukseklisansOgrenci> getAllInstituteOgrenci() {
        return null;
    }

    /*public List<YukseklisansOgrenci> getAllInstituteOgrenci() {
        return (List<YukseklisansOgrenci>) yukLisansOgrenciRepository.getAll();
    }*/
    public YukseklisansOgrenci findByID(Long id) {
        YukseklisansOgrenci yukseklisansOgrenci =yukLisansOgrenciRepository.findById(id).get();
        return  yukseklisansOgrenci;
    }
}
