package com.social.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_Blog")
public class Blog extends ErrorPage{

	@Id
	private String blogId;
	
//	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private User blogUsername; //created by
	private String blogTitle;
	private String blogText;// blog body	
	private Date blogDate; //created on
	
	private boolean approved;

	//@OneToMany(mappedBy="blog",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<BlogComment> blogComments=new ArrayList<BlogComment>();

	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogText() {
		return blogText;
	}
	public void setBlogText(String blogText) {
		this.blogText = blogText;
	}
	public Date getBlogDate() {
		return blogDate;
	}
	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}
	public List<BlogComment> getBlogComments() {
		return blogComments;
	}
	public void setBlogComments(List<BlogComment> blogComments) {
		this.blogComments = blogComments;
	}
	public User getBlogUsername() {
		return blogUsername;
	}
	public void setBlogUsername(User blogUsername) {
		this.blogUsername = blogUsername;
	}
	
}
