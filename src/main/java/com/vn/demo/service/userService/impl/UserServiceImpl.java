package com.vn.demo.service.userService.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vn.demo.entity.Role;
import com.vn.demo.entity.User;
import com.vn.demo.service.userService.UserSevice;
@Service
public class UserServiceImpl implements UserSevice{

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role saveRoles(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
