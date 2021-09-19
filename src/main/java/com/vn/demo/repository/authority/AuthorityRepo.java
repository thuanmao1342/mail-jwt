package com.vn.demo.repository.authority;

import com.vn.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepo extends JpaRepository<Authority, Integer> {
}
