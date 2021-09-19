package com.vn.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.repository.user.UserRepo;

@Controller
public class HomeController {
	@Autowired
	UserRepo userRepo;
	@RequestMapping("index")
	public String index() {
		Optional<com.vn.demo.entity.User> user = userRepo.findById("thuan");
		System.out.println("da chay"+user.get().getName());
		return "home/index";
	}

}
