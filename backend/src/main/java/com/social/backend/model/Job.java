package com.social.backend.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_Job")

public class Job extends ErrorPage{
	
	@Id
	private String jobId;
	private String jobTitle;
	private String jobDescp;
	private Date jobDateTime;
	private String jobQualification;
	private String jobStatus;
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescp() {
		return jobDescp;
	}
	public void setJobDescp(String jobDescp) {
		this.jobDescp = jobDescp;
	}
	public Date getJobDateTime() {
		return jobDateTime;
	}
	public void setJobDateTime(Date jobDateTime) {
		this.jobDateTime = jobDateTime;
	}
	public String getJobQualification() {
		return jobQualification;
	}
	public void setJobQualification(String jobQualification) {
		this.jobQualification = jobQualification;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	

}
