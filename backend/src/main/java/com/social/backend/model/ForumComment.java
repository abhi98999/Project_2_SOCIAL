package com.social.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_ForumComment")
public class ForumComment extends ErrorPage {

	@Id
	private String forumCommentId;
	private String forumCommentUsername;
	private String forumCommentDescp;
	
	public String getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(String forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public String getForumCommentUsername() {
		return forumCommentUsername;
	}
	public void setForumCommentUsername(String forumCommentUsername) {
		this.forumCommentUsername = forumCommentUsername;
	}
	public String getForumCommentDescp() {
		return forumCommentDescp;
	}
	public void setForumCommentDescp(String forumCommentDescp) {
		this.forumCommentDescp = forumCommentDescp;
	}
	
}
