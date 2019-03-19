package com.service;

import com.util.MsgResult;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.dao.AdminDao;
import com.dao.DoctorDao;
import com.dao.PatientDao;
import com.entity.Admin;
import com.entity.Doctor;
import com.entity.Patient;
@Service
public class LoginServiceImpl {
	@Resource
	private AdminDao adminDao;
	@Resource
	private PatientDao patientDao;
	@Resource
	private DoctorDao doctorDao;
	
	public MsgResult checkLogin(String userName,String password,String did){
		//判断登录用户权限
		MsgResult result=new MsgResult();
		Admin admin=adminDao.findByAdminUser(userName);
		Doctor doctor=doctorDao.findByDid(did);
		Patient patient=patientDao.findByPatientUser(userName);
		//管理员判断
		if(admin!=null){
			if(!admin.getPassword().equals(password)){
				result.setStatus(1);
				result.setMsg("密码错误");
				return result;
			}
			result.setStatus(0);
			result.setMsg("管理员登录成功");
			result.setData(admin.getAid());
			return result;
		}
		//医生判断
		if(doctor!=null){
			if(!doctor.getPassword().equals(password)){
				result.setStatus(1);
				result.setMsg("密码错误");
				return result;
			}
			result.setStatus(0);
			result.setMsg("医生登录成功");
			result.setData(doctor.getDid());
			return result;
		}
		//患者判断
		if(patient!=null){
			if(!patient.getPassword().equals(password)){
				result.setStatus(1);
				result.setMsg("密码错误");
				return result;
			}
			result.setStatus(0);
			result.setMsg("客户登录成功");
			result.setData(patient.getPid());
			return result;
		}
		result.setStatus(2);
		result.setMsg("用户名不存在");
		return result;
	}
}
