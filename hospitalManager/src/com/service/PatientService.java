package com.service;

import com.util.MsgResult;

public interface PatientService {
	public MsgResult register(String userName,String name,String password,
			String age,String sex,String address,String phone);
	public MsgResult findDoctorByName(String name);
	public MsgResult findDoctorBySpecialty(String specialty);
	public MsgResult reservation(String did,String dname,String pid,String rDay);
	public MsgResult findReserve(String pid);
	public MsgResult findName(String pid);
	public MsgResult cancelReserve(String cid);
}
