package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reserve implements Serializable{
	private  int cid;
	private String did;
	private String  dname;
	private int pid;
	private Timestamp rDate;
	private Timestamp rDay;
	private String datetime;
	private String daytime;
	public int getcid() {
		return cid;
	}
	public void setcid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	public Timestamp getrDate() {
		return rDate;
	}
	public void setrDay(Timestamp rDay) {
		this.rDay = rDay;
	}
	public Timestamp getrDay() {
		return rDay;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDname() {
		return dname;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDid() {
		return did;
	}

	
}
