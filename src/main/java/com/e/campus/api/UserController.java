package com.e.campus.api;

import com.e.campus.model.UserRole;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import com.e.campus.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.e.campus.service.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>>getUsers() {

        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping ("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/users/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping ("/role/save")
    public ResponseEntity<UserRole>saveUserRole(@RequestBody UserRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/users/role/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.saveUserRole(role));
     }

    @PostMapping ("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername() ,form.getRoleName());
        return ResponseEntity.ok("succefull");
    }

}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
