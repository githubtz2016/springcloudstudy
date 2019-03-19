package com.controller;

import com.util.MsgResult;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private AdminService adminService;
    
	//修改医生
	@RequestMapping("/upd.do")
	@ResponseBody
	public MsgResult upd(String did){
		MsgResult result=adminService.findByDid(did);
		return result;
	}
	
	//保存修改医生信息
	@RequestMapping("/updateDoctor.do")
	@ResponseBody
	public MsgResult updateDoctor(String did, String password, String level,
			String dept, String specialty, String phone){
		    MsgResult  result=adminService.updateDoctor(did, password, level, dept, specialty, phone);
			return result;		
	}
	
	
	//返回用户名字
	@RequestMapping("/findName.do")
	@ResponseBody
	public MsgResult findName(String aid){
		MsgResult result=adminService.findName(aid);
		return result;
	}
	
	//查询所有医生
	@RequestMapping("/findAllDoctor.do")
	@ResponseBody
	public MsgResult findAllDoctor(){
		MsgResult result=adminService.findAllDoctor();
		return result;
	}
	
	@RequestMapping("/addDoctor.do")
	@ResponseBody
	//添加医生
	public MsgResult addDoctor(String did,String name,String  age,String  sex,
			String  password,String  level,String  dept,String  specialty,String phone){
		MsgResult result=adminService.addDoctorUser(did, name, age, sex, password,
				level, dept, specialty, phone);
		return result;
	}
	
	@RequestMapping("/deleteDoctor.do")
	@ResponseBody
	//删除医生
	public MsgResult deleteDoctor(String did){
		MsgResult result=adminService.deleteDoctor(did);
		return result;
	}
	
}
