package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogs.entities.Role;
import com.blogs.entities.User;
import com.blogs.service.UserService;
import com.blogs.service.UserServiceImpl;

@Controller
@RequestMapping("/Users")
public class UserController {
	@Autowired
	public UserService userService;
	
	//add a user method for processing login form
	@PostMapping("/login")
	/*
	 * @RequestParam : method arg level annotation
	 * to  bind request param name  to method args
	 * Done auto by SC
	 * 
	*/
	public String processLoginForm(@RequestParam String email, 
			@RequestParam String password, Model map, HttpSession session) {
		System.out.println("in process login form"+email+" "+password);
		try {
		//invoke service layer method
		User user = userService .signInUser(email, password);
		session.setAttribute("message", "Login Successful");
		session.setAttribute("user_details",user);
		
		if(user.getRole() == Role.ADMIN)
			return "redirect:/admin/home";
		return "redirect:/blogger/home";
		}catch (RuntimeException e) {
			System.out.println("err "+e);
			session.setAttribute("message",e.getMessage());
			return "/Users/login";
		}
	}

}
