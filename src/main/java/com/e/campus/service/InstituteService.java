package com.e.campus.service;


import com.e.campus.model.Institute;
import com.e.campus.repository.InstituteRepository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


public interface InstituteService {



    public List<Institute> getAllInstitute() ;


    public Institute addInstitute(Institute institute) ;


    public Institute findInstituteByID(Long id) ;
}
