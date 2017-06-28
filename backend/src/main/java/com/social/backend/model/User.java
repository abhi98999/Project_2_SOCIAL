package com.social.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name="C_User")
public class User extends ErrorPage{

	private String uFullName;
	
	@Id
	private String uUsername;
	
	private String uPassword;
	
	private String uEmailId;
	private long uPhoneNumber;
	private String uRole;	
	private char uIsOnline;
	
	private String approveStatus ;
	private char accountStatus;
	
	public String getuFullName() {
		return uFullName;
	}
	public void setuFullName(String uFullName) {
		this.uFullName = uFullName;
	}
	public String getuUsername() {
		return uUsername;
	}
	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuEmailId() {
		return uEmailId;
	}
	public void setuEmailId(String uEmailId) {
		this.uEmailId = uEmailId;
	}
	public long getuPhoneNumber() {
		return uPhoneNumber;
	}
	public void setuPhoneNumber(long uPhoneNumber) {
		this.uPhoneNumber = uPhoneNumber;
	}
	public String getuRole() {
		return uRole;
	}
	public void setuRole(String uRole) {
		this.uRole = uRole;
	}
	public char getuIsOnline() {
		return uIsOnline;
	}
	public void setuIsOnline(char uIsOnline) {
		this.uIsOnline = uIsOnline;
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public char getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(char accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
}
