package com.vn.demo.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.vn.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.repository.user.UserRepo;

@Controller
public class HomeController {
	@Autowired
	UserRepo userRepo;
	@RequestMapping("index")
	public String index() {
		User user = userRepo.findByUsername("thuan");
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getAuthority().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
			System.out.println(role.getRole().getName());
		});
		return "home/index";
	}

}
