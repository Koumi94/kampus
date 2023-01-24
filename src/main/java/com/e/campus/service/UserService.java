package com.e.campus.service;

import com.e.campus.model.User;
import com.e.campus.model.UserRole;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User saveUser (User user);


    void addRoleToUser(String username, String roleName);
    User getUser( String username);
    List<User> getUsers();

    UserRole saveUserRole(UserRole role);


}