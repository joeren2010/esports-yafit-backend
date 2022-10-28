package com.esports.yafit.admin.model;

import java.util.Date;

public class Participants {
	// create sql table fields
	private int partId;
	private String partName;
	private String partEmail;
	private String partPassword;
	private String partStreet;
	private String partCity;
	private String partState;
	private String partCountry;
	private int partZipcode;
	private int partAge;
	private String partGender;
	private String partImage;
	private String partPhone;
	private String emergPhone;
	private String partType;
	private int partActive;
	private Date addedOn;
	
	
	//default constructor
	public Participants() {
		super();
	}


	//parameterized constructor
	public Participants(int partId, String partName, String partEmail, String partPassword, String partStreet,
			String partCity, String partState, String partCountry, int partZipcode, int partAge,
			String partGender, String partImage, String partPhone, String emergPhone, String partType, int partActive,
			Date addedOn) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.partEmail = partEmail;
		this.partPassword = partPassword;
		this.partStreet = partStreet;
		this.partCity = partCity;
		this.partState = partState;
		this.partCountry = partCountry;
		this.partZipcode = partZipcode;
		this.partAge = partAge;
		this.partGender = partGender;
		this.partImage = partImage;
		this.partPhone = partPhone;
		this.emergPhone = emergPhone;
		this.partType = partType;
		this.partActive = partActive;
		this.addedOn = addedOn;
	}


	//getter & setter methods
	public int getPartId() {
		return partId;
	}


	public void setPartId(int partId) {
		this.partId = partId;
	}


	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public String getPartEmail() {
		return partEmail;
	}


	public void setPartEmail(String partEmail) {
		this.partEmail = partEmail;
	}


	public String getPartPassword() {
		return partPassword;
	}


	public void setPartPassword(String partPassword) {
		this.partPassword = partPassword;
	}


	public String getPartStreet() {
		return partStreet;
	}


	public void setPartStreet(String partStreet) {
		this.partStreet = partStreet;
	}


	public String getPartCity() {
		return partCity;
	}


	public void setPartCity(String partCity) {
		this.partCity = partCity;
	}


	public String getPartState() {
		return partState;
	}


	public void setPartState(String partState) {
		this.partState = partState;
	}


	public String getPartCountry() {
		return partCountry;
	}


	public void setPartCountry(String partCountry) {
		this.partCountry = partCountry;
	}


	public int getPartZipcode() {
		return partZipcode;
	}


	public void setPartZipcode(int partZipcode) {
		this.partZipcode = partZipcode;
	}


	public int getPartAge() {
		return partAge;
	}


	public void setPartAge(int partAge) {
		this.partAge = partAge;
	}


	public String getPartGender() {
		return partGender;
	}


	public void setPartGender(String partGender) {
		this.partGender = partGender;
	}


	public String getPartImage() {
		return partImage;
	}


	public void setPartImage(String partImage) {
		this.partImage = partImage;
	}


	public String getPartPhone() {
		return partPhone;
	}


	public void setPartPhone(String partPhone) {
		this.partPhone = partPhone;
	}


	public String getEmergPhone() {
		return emergPhone;
	}


	public void setEmergPhone(String emergPhone) {
		this.emergPhone = emergPhone;
	}


	public String getPartType() {
		return partType;
	}


	public void setPartType(String partType) {
		this.partType = partType;
	}


	public int getPartActive() {
		return partActive;
	}


	public void setPartActive(int partActive) {
		this.partActive = partActive;
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
		return "Participants [partId=" + partId + ", partName=" + partName + ", partEmail=" + partEmail
				+ ", partPassword=" + partPassword + ", partStreet=" + partStreet + ", partCity=" + partCity
				+ ", partState=" + partState + ", partCountry=" + partCountry + ", partZipcode=" + partZipcode
				+ ", partAge=" + partAge + ", partGender=" + partGender + ", partImage=" + partImage
				+ ", partPhone=" + partPhone + ", emergPhone=" + emergPhone + ", partType=" + partType + ", partActive="
				+ partActive + ", addedOn=" + addedOn + "]";
	}
}
