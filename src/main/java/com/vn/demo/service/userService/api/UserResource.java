package com.vn.demo.service.userService.api;

import com.vn.demo.entity.User;
import com.vn.demo.service.userService.UserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Userresource {
    private final UserSevice userSevice;
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userSevice.getUser());
    }
}
