package com.e.campus.service;

import com.e.campus.model.YukseklisansOgrenci;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface YukLisansOgrenciService {



    public List<YukseklisansOgrenci> getAllYukLisansOgrenci();


    Optional<YukseklisansOgrenci> getYukLisansOgrenciById(Long id);



    YukseklisansOgrenci updateYukLisansOgrenci(Long id, YukseklisansOgrenci yukLisansOgrenci);

    void deleteYukLisansOgrenci(Long id);


    YukseklisansOgrenci addYukLisansOgrenci(YukseklisansOgrenci yukLisansOgrenci);
}
