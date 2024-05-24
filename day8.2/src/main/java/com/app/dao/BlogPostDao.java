package com.app.dao;

import com.app.entities.BlogPost;

public interface BlogPostDao {
	String addBlogPost(BlogPost post, Long categoryId, Long authorId);
}
