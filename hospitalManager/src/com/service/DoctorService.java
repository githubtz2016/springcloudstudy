package com.service;

import com.util.MsgResult;

public interface DoctorService {
	public MsgResult findName(String did);
	public MsgResult findPatient(String dname);
	public MsgResult findBypiddid(String  pid,String did);
	public MsgResult updateMR(String rid,String did,String description,String diagnose,
			String pname,String prescribe);
	public MsgResult creatMR(String did,String description,String diagnose,
			String pname,String prescribe);
}
