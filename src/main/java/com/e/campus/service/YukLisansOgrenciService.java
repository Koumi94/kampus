package com.e.campus.service;

import com.e.campus.model.Institute;
import com.e.campus.model.YukseklisansOgrenci;
import com.e.campus.repository.InstituteRepository;
import com.e.campus.repository.YukLisansOgrenciRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface YukLisansOgrenciService {

    public YukseklisansOgrenci addInstituteOgrenci(YukseklisansOgrenci yukseklisansOgrenci);

    public List<YukseklisansOgrenci> getAllInstituteOgrenci();
}
