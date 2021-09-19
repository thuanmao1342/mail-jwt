package com.vn.demo.service.userService.api;

import com.vn.demo.entity.Role;
import com.vn.demo.entity.User;
import com.vn.demo.service.userService.UserSevice;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {
    private final UserSevice userSevice;
    @GetMapping("/user")
    public ResponseEntity<List<User>>getUser(){
        return ResponseEntity.ok().body(userSevice.getUser());
    }
    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userSevice.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userSevice.saveRole(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm roleToUserForm){
        userSevice.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRoleid());
        return ResponseEntity.ok().build();
    }

}
@Data
class RoleToUserForm{
    private String username;
    private Long roleid;
}