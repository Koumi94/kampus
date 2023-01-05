package com.e.campus.service;

import com.e.campus.model.IK;
import com.e.campus.repository.IkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IkServiceImpl implements IkService{

    private  final IkRepository ikRepository;



    public IkServiceImpl(IkRepository ikRepository) {
        this.ikRepository = ikRepository;
    }

    public IK addIk(IK ik) {
        return ikRepository.save(ik);
    };


    public Optional<IK> findByID(Long id) {
        return ikRepository.findById(id);
    }

    public List<IK> getAllIk() {
        return ikRepository.findAll();
    }
}
