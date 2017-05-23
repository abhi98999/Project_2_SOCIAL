package com.social.backend.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_Friend")
public class Friend extends ErrorPage{
	
	@Id
	private String fId;
	private String fUserId;
	private String fStatus; //new,accepted,rejected
	private char fIsonline;
	private Date fLastSeenTime;
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfUserId() {
		return fUserId;
	}
	public void setfUserId(String fUserId) {
		this.fUserId = fUserId;
	}
	public String getfStatus() {
		return fStatus;
	}
	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}
	public char getfIsonline() {
		return fIsonline;
	}
	public void setfIsonline(char fIsonline) {
		this.fIsonline = fIsonline;
	}
	public Date getfLastSeenTime() {
		return fLastSeenTime;
	}
	public void setfLastSeenTime(Date fLastSeenTime) {
		this.fLastSeenTime = fLastSeenTime;
	}
	
	


}
