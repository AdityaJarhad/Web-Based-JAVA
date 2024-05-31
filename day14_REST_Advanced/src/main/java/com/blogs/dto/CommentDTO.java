package com.blogs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO extends BaseDTO {
//	comment, rating, cmt id, post id
	private String commentText;
	private String rating;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long bloggerId;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long categoryId;
	
}
