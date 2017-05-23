package com.social.backend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.backend.model.Blog;
import com.social.backend.model.BlogComment;

@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveBlogPost(Blog blog) {
		Session session=sessionFactory.openSession();
		session.save(blog);
		session.flush();
		session.close();
		
	}

	public List<Blog> getBlog(int approved) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogPost where approved="+approved);
		List<Blog> blog=query.list();
		session.close();
		return blog;
	}

	public Blog getBlogById(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	public void addBlogComment(BlogComment blogComment) {
		Session session=sessionFactory.openSession();
		session.save(blogComment);
		session.flush();
		session.close();
	}

	public List<BlogComment> getBlogComments(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class, blogId);
		List<BlogComment> blogComments=blog.getBlogComments();
		session.close();
		return blogComments;
	}

	public void update(Blog blog) {
		Session session=sessionFactory.openSession();
		session.update(blog);
		session.flush();
		session.close();
	}

}
