package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.BlogPost;
import com.app.entities.Category;
import com.app.entities.User;

public class BlogPostDaoImpl implements BlogPostDao {

	@Override
	public String addBlogPost(BlogPost post, Long categoryId, Long authorId) {
		//1.
		Session session = getFactory().getCurrentSession();
		//2.
		Transaction tx = session.beginTransaction();
		try {
			//1. get category from it's id
			Category cat = session.get(Category.class, categoryId);
			//2. get author from it's id
			User author = session.get(User.class, authorId);
			//3. null checking --if not null
			if(cat!=null && author!=null) {
				post.setCategory(cat);
				post.setUsers(author);
			}
			//4. establish asso between post --> author n post --> category
			//setter
			
			
			
		} catch (RuntimeException e) {
			if(tx != null){
				
			}
		}
		return null;
	}

}
