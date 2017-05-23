package com.social.backend.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_JobAppliacation")
public class JobApplication extends ErrorPage{
	
	@Id
	private String jobAppId;
	private String jobAppuserId;
	private Date jobAppDateApplied;
	private String jobAppRemark;
	private char jobAppStatus;
	public String getJobAppId() {
		return jobAppId;
	}
	public void setJobAppId(String jobAppId) {
		this.jobAppId = jobAppId;
	}
	public String getJobAppuserId() {
		return jobAppuserId;
	}
	public void setJobAppuserId(String jobAppuserId) {
		this.jobAppuserId = jobAppuserId;
	}
	public Date getJobAppDateApplied() {
		return jobAppDateApplied;
	}
	public void setJobAppDateApplied(Date jobAppDateApplied) {
		this.jobAppDateApplied = jobAppDateApplied;
	}
	public String getJobAppRemark() {
		return jobAppRemark;
	}
	public void setJobAppRemark(String jobAppRemark) {
		this.jobAppRemark = jobAppRemark;
	}
	public char getJobAppStatus() {
		return jobAppStatus;
	}
	public void setJobAppStatus(char jobAppStatus) {
		this.jobAppStatus = jobAppStatus;
	}
	
	
}
