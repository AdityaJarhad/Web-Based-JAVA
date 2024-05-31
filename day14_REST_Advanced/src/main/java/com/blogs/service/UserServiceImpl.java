package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.InvalidCredentialsException;
import com.blogs.dto.AuthDTO;
import com.blogs.dto.UserDTO;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO authenticateUser(AuthDTO dto) {
		User user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPwd())
				.orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));
		
		return mapper.map(user, UserDTO.class);
	}

}
