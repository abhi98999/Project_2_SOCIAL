package com.social.backend.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_Forum")
public class Forum extends ErrorPage {

	@Id
	private String forumId;
	private String forumTitile;
	private String forumUsername;
	private String forumDescp;
	private Date forumDate;
	private int forumLikes;
	private int forumComments;
	public String getForumId() {
		return forumId;
	}
	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	public String getForumTitile() {
		return forumTitile;
	}
	public void setForumTitile(String forumTitile) {
		this.forumTitile = forumTitile;
	}
	public String getForumUsername() {
		return forumUsername;
	}
	public void setForumUsername(String forumUsername) {
		this.forumUsername = forumUsername;
	}
	public String getForumDescp() {
		return forumDescp;
	}
	public void setForumDescp(String forumDescp) {
		this.forumDescp = forumDescp;
	}
	public Date getForumDate() {
		return forumDate;
	}
	public void setForumDate(Date forumDate) {
		this.forumDate = forumDate;
	}
	public int getForumLikes() {
		return forumLikes;
	}
	public void setForumLikes(int forumLikes) {
		this.forumLikes = forumLikes;
	}
	public int getForumComments() {
		return forumComments;
	}
	public void setForumComments(int forumComments) {
		this.forumComments = forumComments;
	}
	
}
