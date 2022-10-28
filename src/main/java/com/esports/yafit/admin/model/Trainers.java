package com.esports.yafit.admin.model;

import java.util.Date;

public class Trainers {
	// create sql table fields
	private int trnrId;
	private String trnrName;
	private String trnrEmail;
	private String trnrPassword;
	private String trnrStreet;
	private String trnrCity;
	private String trnrState;
	private int trnrZipcode;
	private int trnrAge;
	private String trnrGender;
	private String trnrImage;
	private String trnrPhone;
	private String trnrTitle;
	private int trnrRating;
	private int trnrActive;
	private Date addedOn;
	
	
	//default constructor
	public Trainers() {
		super();
	}


	//parameterized constructor
	public Trainers(int trnrId, String trnrName, String trnrEmail, String trnrPassword, String trnrStreet,
			String trnrCity, String trnrState, int trnrZipcode, int trnrAge, String trnrGender, String trnrImage,
			String trnrPhone, String trnrTitle, int trnrRating, int trnrActive, Date addedOn) {
		super();
		this.trnrId = trnrId;
		this.trnrName = trnrName;
		this.trnrEmail = trnrEmail;
		this.trnrPassword = trnrPassword;
		this.trnrStreet = trnrStreet;
		this.trnrCity = trnrCity;
		this.trnrState = trnrState;
		this.trnrZipcode = trnrZipcode;
		this.trnrAge = trnrAge;
		this.trnrGender = trnrGender;
		this.trnrImage = trnrImage;
		this.trnrPhone = trnrPhone;
		this.trnrTitle = trnrTitle;
		this.trnrRating = trnrRating;
		this.trnrActive = trnrActive;
		this.addedOn = addedOn;
	}


	//getter & setter methods
	public int getTrnrId() {
		return trnrId;
	}


	public void setTrnrId(int trnrId) {
		this.trnrId = trnrId;
	}


	public String getTrnrName() {
		return trnrName;
	}


	public void setTrnrName(String trnrName) {
		this.trnrName = trnrName;
	}


	public String getTrnrEmail() {
		return trnrEmail;
	}


	public void setTrnrEmail(String trnrEmail) {
		this.trnrEmail = trnrEmail;
	}


	public String getTrnrPassword() {
		return trnrPassword;
	}


	public void setTrnrPassword(String trnrPassword) {
		this.trnrPassword = trnrPassword;
	}


	public String getTrnrStreet() {
		return trnrStreet;
	}


	public void setTrnrStreet(String trnrStreet) {
		this.trnrStreet = trnrStreet;
	}


	public String getTrnrCity() {
		return trnrCity;
	}


	public void setTrnrCity(String trnrCity) {
		this.trnrCity = trnrCity;
	}


	public String getTrnrState() {
		return trnrState;
	}


	public void setTrnrState(String trnrState) {
		this.trnrState = trnrState;
	}


	public int getTrnrZipcode() {
		return trnrZipcode;
	}


	public void setTrnrZipcode(int trnrZipcode) {
		this.trnrZipcode = trnrZipcode;
	}


	public int getTrnrAge() {
		return trnrAge;
	}


	public void setTrnrAge(int trnrAge) {
		this.trnrAge = trnrAge;
	}


	public String getTrnrGender() {
		return trnrGender;
	}


	public void setTrnrGender(String trnrGender) {
		this.trnrGender = trnrGender;
	}


	public String getTrnrImage() {
		return trnrImage;
	}


	public void setTrnrImage(String trnrImage) {
		this.trnrImage = trnrImage;
	}


	public String getTrnrPhone() {
		return trnrPhone;
	}


	public void setTrnrPhone(String trnrPhone) {
		this.trnrPhone = trnrPhone;
	}


	public String getTrnrTitle() {
		return trnrTitle;
	}


	public void setTrnrTitle(String trnrTitle) {
		this.trnrTitle = trnrTitle;
	}


	public int getTrnrRating() {
		return trnrRating;
	}


	public void setTrnrRating(int trnrRating) {
		this.trnrRating = trnrRating;
	}


	public int getTrnrActive() {
		return trnrActive;
	}


	public void setTrnrActive(int trnrActive) {
		this.trnrActive = trnrActive;
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
		return "Trainers [trnrId=" + trnrId + ", trnrName=" + trnrName + ", trnrEmail=" + trnrEmail + ", trnrPassword="
				+ trnrPassword + ", trnrStreet=" + trnrStreet + ", trnrCity=" + trnrCity + ", trnrState=" + trnrState
				+ ", trnrZipcode=" + trnrZipcode + ", trnrAge=" + trnrAge + ", trnrGender=" + trnrGender
				+ ", trnrImage=" + trnrImage + ", trnrPhone=" + trnrPhone + ", trnrTitle=" + trnrTitle + ", trnrRating="
				+ trnrRating + ", trnrActive=" + trnrActive + ", addedOn=" + addedOn + "]";
	}
}
