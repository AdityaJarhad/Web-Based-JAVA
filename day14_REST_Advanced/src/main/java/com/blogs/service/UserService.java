package com.blogs.service;

import com.blogs.dto.AuthDTO;
import com.blogs.dto.UserDTO;

public interface UserService {

	UserDTO authenticateUser(AuthDTO dto);

}
