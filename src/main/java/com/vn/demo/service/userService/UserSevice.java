package com.vn.demo.service.userService;

import com.vn.demo.entity.Role;
import com.vn.demo.entity.User;

import java.util.List;

public interface UserSevice {
    User saveUser(User user);
    Role saveRoles(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUser();
}
