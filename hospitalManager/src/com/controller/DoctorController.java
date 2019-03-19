package com.controller;

import com.util.MsgResult;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Resource
	private DoctorService doctorService;
	
	//修改患者病历
	@RequestMapping("/updateMR.do")
	@ResponseBody
	public MsgResult updateMR(String rid, String did, String description,
			String diagnose, String pname, String prescribe){
		MsgResult result=doctorService.updateMR(rid, did, description, diagnose, pname, prescribe);
		return result;
	}
	
	//创建患者病历
	@RequestMapping("/creatMR.do")
	@ResponseBody
	public MsgResult creatMR(String did, String description, String diagnose,
			String pname, String prescribe){
		MsgResult result=doctorService.creatMR(did, description, diagnose, pname, prescribe);
		return result;
	}
	
	//返回用户病历
	@RequestMapping("/returnMR.do")
	@ResponseBody
	public MsgResult returnMR(String pid,String did){
		MsgResult result=doctorService.findBypiddid(pid, did);
		return result;
	}
	
	//返回用户名字
	@RequestMapping("/findName.do")
	@ResponseBody
	public MsgResult findName(String did){
		MsgResult result=doctorService.findName(did);
		return result;
	}
	
	//查看预约患者
	@RequestMapping("/findReserve.do")
	@ResponseBody
	public MsgResult findReserve(String did){
		MsgResult result=doctorService.findPatient(did);
		return result;
	}

}
