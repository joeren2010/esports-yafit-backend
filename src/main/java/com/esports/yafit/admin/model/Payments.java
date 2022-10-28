package com.esports.yafit.admin.model;

import java.util.Date;

public class Payments {
	// create sql table fields
	private int paymentId;
	private int partId;
	private String partName;
	private String partEmail;
	private String partPhone;
	private String partType;
	private String paymentPlan;
	private int billingDay;
	private String paymentStatus;
	private int paymentAmount;
	private int partActive;
	private Date addedOn;

	// default constructor
	public Payments() {
		super();
	}

	// parameterized constructor
	public Payments(int paymentId, int partId, String partName, String partEmail, String partPhone, String partType,
			String paymentPlan, int billingDay, String paymentStatus, int paymentAmount, int partActive,
			Date addedOn) {
		super();
		this.paymentId = paymentId;
		this.partId = partId;
		this.partName = partName;
		this.partEmail = partEmail;
		this.partPhone = partPhone;
		this.partType = partType;
		this.paymentPlan = paymentPlan;
		this.billingDay = billingDay;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
		this.partActive = partActive;
		this.addedOn = addedOn;
	}

	// getter & setter methods
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

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

	public String getPartPhone() {
		return partPhone;
	}

	public void setPartPhone(String partPhone) {
		this.partPhone = partPhone;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(String paymentPlan) {
		this.paymentPlan = paymentPlan;
	}

	public int getBillingDay() {
		return billingDay;
	}

	public void setBillingDay(int billingDay) {
		this.billingDay = billingDay;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
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

	// override to-string method
	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", partId=" + partId + ", partName=" + partName + ", partEmail="
				+ partEmail + ", partPhone=" + partPhone + ", partType=" + partType + ", paymentPlan=" + paymentPlan
				+ ", billingDay=" + billingDay + ", paymentStatus=" + paymentStatus + ", paymentAmount=" + paymentAmount
				+ ", partActive=" + partActive + ", addedOn=" + addedOn + "]";
	}
}
