package com.e.campus.service;

import com.e.campus.model.IK;
import com.e.campus.model.StudentAffairs;
import com.e.campus.repository.IkRepository;
import com.e.campus.repository.StudentAffairsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAffServiceImpl implements StudentAffService{
    private  final StudentAffairsRepository studentAffairsRepository;



    public StudentAffServiceImpl(StudentAffairsRepository studentAffairsRepository) {
        this.studentAffairsRepository = studentAffairsRepository;
    }


    @Override
    public List<StudentAffairs> getAllStudentAffairs() {
        return null;
    }

    @Override
    public Optional<StudentAffairs> getStudentAffairsById(Long id) {
        return Optional.empty();
    }

    @Override
    public StudentAffairs addStudentAffairs(StudentAffairs studentAffairs) {
        return null;
    }

    @Override
    public StudentAffairs updateStudentAffairs(Long id, StudentAffairs studentAffairs) {
        return null;
    }

    @Override
    public void deleteStudentAffairs(Long id) {

    }
}
