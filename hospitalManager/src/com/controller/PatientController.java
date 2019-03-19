package com.controller;

import com.util.MsgResult;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Resource
	private PatientService patientService;
	
	
	//取消预约
	@RequestMapping("/cancelReserve.do")
	@ResponseBody
	public MsgResult cancelReserve(String cid){
		MsgResult result=patientService.cancelReserve(cid);
		return result; 
	}
	
	//添加预约
	@RequestMapping("/reservation.do")
	@ResponseBody
	public MsgResult reservation(String did,String dname, String  pid, String rDay){
		MsgResult result=patientService.reservation(did,dname, pid, rDay);
		return result; 
	}
	
	//查看预约
	@RequestMapping("/findReserve.do")
	@ResponseBody
	public MsgResult findReserve(String pid){
		MsgResult result=patientService.findReserve(pid);
		return result; 
	}

	//返回用户名字
	@RequestMapping("/findName.do")
	@ResponseBody
	public MsgResult findName(String pid){
		MsgResult result=patientService.findName(pid);
		return result;
	}
	
	//注册
	@RequestMapping("/register.do")
	@ResponseBody
	public  MsgResult register(String userName, String name, String password,
			String age, String sex, String address, String phone){
		MsgResult result=patientService.register(userName, name, password, age, sex, address, phone);
		return result;
	}
	
	@RequestMapping("/findLikeName.do")
	@ResponseBody
	//查询医生名字
	public MsgResult findLikeName(String name){
		MsgResult result=patientService.findDoctorByName(name);
		return result;
	}
	
	//查询专业名字
	@RequestMapping("/findLikeSpecialty.do")
	@ResponseBody
	public MsgResult findLikeSpecialty(String specialty){
		MsgResult result=patientService.findDoctorBySpecialty(specialty);
		return result;
	}
	
}
