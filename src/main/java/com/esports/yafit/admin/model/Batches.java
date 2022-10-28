package com.esports.yafit.admin.model;

import java.util.Date;

public class Batches {
	// create sql table fields
	private int batchId;
	private String batchName;
	private String trnrName;
	private int trnrId;
	private String partName;
	private int partId;
	private int partAge;
	private String partGender;
	private int partActive;
	private Date addedOn;

	// default constructor
	public Batches() {
		super();
	}

	// parameterized constructor
	public Batches(int batchId, String batchName, String trnrName, int trnrId, String partName, int partId, int partAge,
			String partGender, int partActive, Date addedOn) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.trnrName = trnrName;
		this.trnrId = trnrId;
		this.partName = partName;
		this.partId = partId;
		this.partAge = partAge;
		this.partGender = partGender;
		this.partActive = partActive;
		this.addedOn = addedOn;
	}

	// getter & setter methods
	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getTrnrName() {
		return trnrName;
	}

	public void setTrnrName(String trnrName) {
		this.trnrName = trnrName;
	}

	public int getTrnrId() {
		return trnrId;
	}

	public void setTrnrId(int trnrId) {
		this.trnrId = trnrId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
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
		return "Batches [batchId=" + batchId + ", batchName=" + batchName + ", trnrName=" + trnrName + ", trnrId="
				+ trnrId + ", partName=" + partName + ", partId=" + partId + ", partAge=" + partAge + ", partGender="
				+ partGender + ", partActive=" + partActive + ", addedOn=" + addedOn + "]";
	}
}
