package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.AuthDTO;
import com.blogs.dto.UserDTO;
import com.blogs.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody AuthDTO dto)
	{
		System.out.println("in user Sign in "+getClass());
		try {
			UserDTO respDto = userService.authenticateUser(dto);
			return ResponseEntity.ok(respDto);
		
		} catch (RuntimeException e) {
			System.out.println(e);
			
			ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(new ApiResponse(e.getMessage()));
		}
		return null;
	}

}
