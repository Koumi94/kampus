package com.e.campus.service;

import com.e.campus.model.UserRole;
import com.e.campus.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRole saveRole(UserRole role){
        userRoleRepository.save(role);
        return role;
    }

    public List<UserRole> getAll(){
        return userRoleRepository.findAll();
    }
}
