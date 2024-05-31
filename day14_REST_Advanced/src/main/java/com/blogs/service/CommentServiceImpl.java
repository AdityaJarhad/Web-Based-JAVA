package com.blogs.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.controller.CommentController;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommentDTO;
import com.blogs.entities.BlogPost;
import com.blogs.entities.User;
import com.blogs.repository.BlogPostRepository;
import com.blogs.repository.CommentRepository;
import com.blogs.repository.UserRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private BlogPostRepository blogPostRepository;
	@Autowired
	private UserRepository repository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addComment(CommentDTO dto) {

		
		return null;
	}
	
}
