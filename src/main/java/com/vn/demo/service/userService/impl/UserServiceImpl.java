package com.vn.demo.service.userService.impl;

import com.vn.demo.repository.role.RoleRepo;
import com.vn.demo.repository.user.UserRepo;
import com.vn.demo.entity.Role;
import com.vn.demo.entity.User;
import com.vn.demo.service.userService.UserSevice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserSevice {
    private final UserRepo userDAO;
    private final RoleRepo roleDAO;
    @Override
    public User saveUser(User user) {
        log.info("may da luu them nguoi dung {}", user.getName());
        return userDAO.save(user);
    }

    @Override
    public Role saveRoles(Role role) {
        log.info("may da luu them quyen dung {}", role.getName());
        return roleDAO.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("may da luu them nguoi dung {} va {}", username,roleName);
        User user = userDAO.findByUsername(username);
        Role role = roleDAO.findByName(roleName);
    }

    @Override
    public User getUser(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public List<User> getUser() {
        return userDAO.findAll();
    }
}
