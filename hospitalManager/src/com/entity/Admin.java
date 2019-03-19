package com.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private int aid;
	private String userName;
	private String name;
	private String password;
	private String email;
	private String phone;
	
	
	public Admin(int aid, String userName, String name, String password,
			String email, String phone) {
		super();
		this.aid = aid;
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public Admin() {

	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", phone=" + phone + ", userName="
				+ userName + "]";
	}
	
	
}
