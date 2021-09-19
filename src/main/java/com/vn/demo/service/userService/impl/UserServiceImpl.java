package com.vn.demo.service.userService.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vn.demo.entity.Authority;
import com.vn.demo.repository.authority.AuthorityRepo;
import com.vn.demo.repository.role.RoleRepo;
import com.vn.demo.repository.user.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vn.demo.entity.Role;
import com.vn.demo.entity.User;
import com.vn.demo.service.userService.UserSevice;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserSevice, UserDetailsService {
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final AuthorityRepo authorityRepo;
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, Long roleName) {
		// TODO Auto-generated method stub
		Role role = roleRepo.findByName(roleName);
		User user = userRepo.findByUsername(username);
		Authority authority = new Authority();
		authority.setRole(role);;
		authority.setUser(user);
		authorityRepo.save(authority);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null){
			log.error("User not fund in the database");
			throw new UsernameNotFoundException("User not found in the database");
		}else{
			log.info("User: {}", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getAuthority().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
	}
}
