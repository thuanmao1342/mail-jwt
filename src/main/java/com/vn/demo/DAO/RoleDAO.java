package com.vn.demo.DAO;

import com.vn.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
