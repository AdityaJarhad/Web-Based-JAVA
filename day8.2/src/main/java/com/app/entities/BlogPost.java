package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//title, description, content
@Entity
@Table(name = "posts")
public class BlogPost extends BaseEntity {
	@Column(length = 50,unique = true)
	private String title;
	@Column(length = 100)
	private String description;
	@Column(length = 500)
	private String content;
	//BlogPost *-->1 Category
	@ManyToOne
	//optional but recommended
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	//posts *-->1 user
	@ManyToOne
	@JoinColumn(name = "auth_id", nullable = false)
	private User users;

	public BlogPost() {
		// TODO Auto-generated constructor stub
	}

	public BlogPost(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	// Tip - Never add any association based properties in toString
	//o.w. bidirectional association -- it may cause stack overflow

	@Override
	public String toString() {
		return "BlogPost [title=" + title + ", description=" + description + ", content=" + content + "]";
	}
	
	
}
