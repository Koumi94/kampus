package com.e.campus.service;


import com.e.campus.model.IK;
import com.e.campus.model.Institute;
import com.e.campus.repository.InstituteRepository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


public interface InstituteService {



     List<Institute> getAllInstitute() ;


     Institute addInstitute(Institute institute) ;


     Institute findInstituteByID(Long id) ;

    Institute getInstituteById(Long id);

    Institute updateInstitute(Long id, Institute institute);

    void deleteInstitute(Long id);

}
