package com.service;

import com.util.MsgResult;

public interface AdminService {
	public MsgResult addDoctorUser(String did,String name,String  age,
			String sex,String password,String level,String dept,String specialty,String phone);
	public MsgResult findAllDoctor();
	public MsgResult deleteDoctor(String did);
	public MsgResult findName(String aid);
	public MsgResult updateDoctor(String did,String password,String level,
			String dept,String specialty,String phone);
	public MsgResult findByDid(String did);
}
