package com.blogs.service;

import com.blogs.entities.User;

public interface UserService {
	//add method for signin
	User signInUser(String email, String pwd);
}
