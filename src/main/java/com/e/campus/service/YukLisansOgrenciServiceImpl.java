package com.e.campus.service;

import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.repository.YukLisansOgrenciRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class YukLisansOgrenciServiceImpl implements YukLisansOgrenciService{

    private YukLisansOgrenciRepository yukLisansOgrenciRepository;


    public void YuklisansOgrenciServiceImpl(YukLisansOgrenciRepository yukLisansOgrenciRepository) {

        this.yukLisansOgrenciRepository = yukLisansOgrenciRepository;
    }

    @Override
    public List<YukseklisansOgrenci> getAllYukLisansOgrenci() {
        return yukLisansOgrenciRepository.findAll();
    }

    @Override
    public YukseklisansOgrenci getYukLisansOgrenciById(Long id) {
        return null;
    }

    @Override
    public YukseklisansOgrenci addBolum(YukseklisansOgrenci yukseklisansOgrenci) {
        return null;
    }

    @Override
    public YukseklisansOgrenci updateYukseklisansOgrenci(Long id, YukseklisansOgrenci yukseklisansOgrenci) {
        return null;
    }

    @Override
    public YukseklisansOgrenci deleteYukseklisansOgrenci(Long id) {
        return null;
    }
}
