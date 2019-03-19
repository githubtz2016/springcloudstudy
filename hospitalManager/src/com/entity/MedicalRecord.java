package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class MedicalRecord implements Serializable {
	private int  rid;
	private String  did;
	private String  description;
	private String diagnose;
	private String pname;
	private String prescribe;
	private Timestamp sDate;
	private String fDate;
	public int getrid() {
		return rid;
	}
	public void setrid(int rid) {
		this.rid = rid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	public String getPrescribe() {
		return prescribe;
	}
	public void setPrescribe(String prescribe) {
		this.prescribe = prescribe;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPname() {
		return pname;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	public String getfDate() {
		return fDate;
	}
	public void setsDate(Timestamp sDate) {
		this.sDate = sDate;
	}
	public Timestamp getsDate() {
		return sDate;
	}
	
	
}
