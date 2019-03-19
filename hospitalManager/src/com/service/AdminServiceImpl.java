package com.service;

import com.util.MsgResult;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.dao.DoctorDao;
import com.entity.Admin;
import com.entity.Doctor;
@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	private DoctorDao doctorDao;
	@Resource
	private AdminDao adminDao;
	
	@Override
	public MsgResult updateDoctor(String did, String password, String level,
			String dept, String specialty, String phone) {
	    //动态更新医生数据
		MsgResult result=new MsgResult();
	    Doctor doctor=new Doctor();
	    doctor.setDid(did);
	    doctor.setPassword(password);
		doctor.setLevel(level);
		doctor.setSpecialty(specialty);
		doctor.setDept(dept);
		doctor.setPhone(phone);
		doctorDao.dynamicUpdateDoctor(doctor);
		result.setMsg("修改医生信息成功！");
		result.setStatus(0);
		return result;
	}
	
	@Override
	public MsgResult addDoctorUser(String did,String name,String  age,String sex,String password,String level,
			String dept,String specialty,String phone) {
		//添加医生账号
		MsgResult result=new MsgResult();
		if(!(doctorDao.findByDid(did)==null)){
			result.setMsg("编号不可重复");
			result.setStatus(1);
			return result;
		}else{
		Doctor doctor=new Doctor();
		doctor.setDid(did);
		doctor.setname(name);
		doctor.setAge(Integer.parseInt(age));
		doctor.setSex(sex);
		doctor.setPassword(password);
		doctor.setLevel(level);
		doctor.setSpecialty(specialty);
		doctor.setDept(dept);
		doctor.setPhone(phone);
		doctorDao.addDoctor(doctor);
		result.setMsg("添加医生成功");
		result.setStatus(0);
		return result;
		}
	}

	@Override
	public MsgResult deleteDoctor(String did) {
		//删除医生账号
		MsgResult result=new MsgResult();
		doctorDao.deleteDoctor(did);
		result.setMsg("删除成功");
		result.setStatus(0);
		return result;
	}

	@Override
	public MsgResult findAllDoctor() {
		//查询所有医生并返回
		MsgResult result=new MsgResult();
		List<Doctor> list=doctorDao.findAllDoctor();
		result.setData(list);
		result.setStatus(0);
		result.setMsg("查询成功");
		//System.out.println(list.size());
		return result;
	}

	@Override
	public MsgResult findName(String aid) {
		//查询用户名字并返回
		MsgResult result=new MsgResult();
		Admin admin=adminDao.findName(Integer.parseInt(aid));
		result.setStatus(0);
		result.setData(admin.getName());
		return result;
	}

	@Override
	public MsgResult findByDid(String did) {
		//查询对应医生返回
		MsgResult result=new MsgResult();
		Doctor doctor=doctorDao.findByDid(did);
		result.setData(doctor);
		result.setMsg("查询成功");
		result.setStatus(0);
		return result;
	}


}
