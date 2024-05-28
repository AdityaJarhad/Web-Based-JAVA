package com.blogs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.customexceptions.InvalidCredentials;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;

@Service //mandatory --> SB contain B.L.
@Transactional //for auto tansxion suprt
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User signInUser(String email, String pwd) {
		Optional<User> optional = userRepository.findByEmailAndPassword(email, pwd);
		return optional.orElseThrow(
				() -> new InvalidCredentials("Invalid Email and password !!!"));
	}

}
