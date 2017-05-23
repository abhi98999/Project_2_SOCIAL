package com.social.backend.DAO;

import java.util.List;

import com.social.backend.model.Blog;
import com.social.backend.model.BlogComment;

public interface BlogDAO {

	void saveBlogPost(Blog blog);
	public List<Blog> getBlog(int approved);
	public Blog getBlogById(int blogId);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getBlogComments(int blogId);
	void update(Blog blog);

}
