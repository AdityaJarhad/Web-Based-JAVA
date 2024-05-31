package com.blogs.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

//comment, rating, cmt id, post id
@Getter
@Setter
public class UserDTO extends BaseDTO{
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String phoneNo;
	
}
