package com.entity;

import java.io.Serializable;

public class Patient implements Serializable{
	private int pid;
	private String name;
	private String  userName; 
	private String password;
	private int age;
	private String sex;
	private String address;
	private String phone;
	
	
	public Patient(int pid, String name, String userName, String password,
			int age, String sex, String address, String phone) {
		this.pid = pid;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}
	
	public Patient() {

	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "patient [address=" + address + ", age=" + age + ", name="
				+ name + ", password=" + password + ", phone=" + phone
				+ ", pid=" + pid + ", sex=" + sex + ", userName=" + userName
				+ "]";
	}
	
	
}
