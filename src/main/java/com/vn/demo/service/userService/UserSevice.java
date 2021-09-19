package com.vn.demo.service.userService;

import com.vn.demo.entity.Role;
import com.vn.demo.entity.User;

import java.util.List;

public interface UserSevice {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, Long roleName);
    User getUser(String username);
    List<User> getUser();
}
