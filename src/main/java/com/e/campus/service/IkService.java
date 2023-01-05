package com.e.campus.service;

import com.e.campus.model.IK;

import java.util.List;
import java.util.Optional;


public interface IkService {


    public  IK addIk(IK ik);


    public Optional<IK> findByID(Long id);

    public  List<IK> getAllIk();
}
