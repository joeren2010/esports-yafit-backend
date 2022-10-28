package com.esports.yafit.admin.model;

import java.util.Date;

public class Admins {
	// create sql table fields
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	private int loginType;
	private Date addedOn;
	
	
	//default constructor
	public Admins() {
		super();
	}


	//parameterized constructor
	public Admins(int adminId, String adminName, String adminEmail, String adminPassword, int loginType, Date addedOn) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.loginType = loginType;
		this.addedOn = addedOn;
	}


	//getter & setter methods
	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminEmail() {
		return adminEmail;
	}


	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}


	public String getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


	public int getLoginType() {
		return loginType;
	}


	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}


	public Date getAddedOn() {
		return addedOn;
	}


	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}


	//override to-string method
	@Override
	public String toString() {
		return "Admins [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + ", loginType=" + loginType + ", addedOn=" + addedOn + "]";
	}
}