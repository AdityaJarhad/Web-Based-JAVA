package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {
	public UserHomeController(){
		System.out.println("in ctor of "+getClass());
	}
	//add a method to render login page
	@GetMapping("/")
	public String showLoginForm() {
		System.out.println("in show login form ");
		return "/Users/login"; //handler rets LVN --> D.S. --> V.R. --> AVN
		// AVN : /WEB-INF/views/Users/login.jsp
	}
}
