package com.entity;

import java.io.Serializable;

public class Doctor implements Serializable {
	private String  did;
	private String name;
	private String password;
	private String sex;
	private int age;
	private String level;
	private String dept;
	private String specialty;
	private String phone;
	
	
	public Doctor(String did, String name, String password, String sex,
			int age, String level, String dept, String specialty, String phone) {
		this.did = did;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.level = level;
		this.dept = dept;
		this.specialty = specialty;
		this.phone = phone;
	}
	
	public Doctor() {

	}
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Doctor [age=" + age + ", dept=" + dept + ", did=" + did
				+ ", level=" + level + ", password=" + password + ", phone="
				+ phone + ", sex=" + sex + ", specialty=" + specialty
				+ ", name=" + name + "]";
	}
		
	
}
