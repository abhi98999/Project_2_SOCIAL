package com.social.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_BlogComment")
public class BlogComment extends ErrorPage{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String b_CommentId;
	private Date commentedOn;
	private String blogComment; //body of comment
	
	//@JoinColumn(name="uUsername")
	private User commentedBy;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	private Blog blog;
	
	
	public Date getCommentedOn() {
		return commentedOn;
	}
	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	public User getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(User commentedBy) {
		this.commentedBy = commentedBy;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	
	public String getB_CommentId() {
		return b_CommentId;
	}
	public void setB_CommentId(String b_CommentId) {
		this.b_CommentId = b_CommentId;
	}
	
	public String getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
}
