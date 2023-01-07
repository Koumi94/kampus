package com.e.campus.service;


import com.e.campus.model.IK;
import com.e.campus.model.Institute;
import com.e.campus.repository.InstituteRepository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


public interface InstituteService {



    public List<Institute> getAllInstitute() ;


    public Institute addInstitute(Institute institute) ;


    public Institute findInstituteByID(Long id) ;

    Optional<IK> getInstituteById(Long id);

    IK updateInstitute(Long id, IK ik);

    void deleteInstitute(Long id);
}
