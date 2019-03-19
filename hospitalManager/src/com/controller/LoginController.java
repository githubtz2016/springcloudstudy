package com.controller;

import com.util.MsgResult;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.LoginServiceImpl;
@Controller
public class LoginController {
	@Resource
	private LoginServiceImpl loginServiceImpl;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public MsgResult checkLogin(String userName,String password,String did){
		MsgResult result=loginServiceImpl.checkLogin(userName, password, did);
		return result;
	}
}
