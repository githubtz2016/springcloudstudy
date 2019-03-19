package com.service;

import com.util.MsgResult;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.dao.DoctorDao;
import com.dao.PatientDao;
import com.dao.ReserveDao;
import com.entity.Doctor;
import com.entity.Patient;
import com.entity.Reserve;
@Service
public class PatientServiceImpl implements PatientService{

	@Resource
	private PatientDao patientDao;
	@Resource 
	private DoctorDao doctorDao;
	@Resource
	private ReserveDao reserveDao;
	
	@Override
	public MsgResult register(String userName, String name, String password,
			String age, String sex, String address, String phone) {
			MsgResult result=new MsgResult();
			if(!(patientDao.findByPatientUser(userName)==null)){
				result.setStatus(1);
				result.setMsg("用户名已存在");
				return result;
			}else{
			Patient p=new Patient();
			p.setUserName(userName);
			p.setName(name);
			p.setPassword(password);
			p.setAge(Integer.parseInt(age));
			p.setSex(sex);
			p.setAddress(address);
			p.setPhone(phone);
			patientDao.register(p);
			//回馈结果
			result.setStatus(0);
			result.setMsg("注册成功！");
			return result;
			}
	}

	@Override
	public MsgResult findDoctorByName(String name) {
		MsgResult result=new MsgResult();
		List<Doctor> list= doctorDao.findLikeName(name);
		if(list.size()!=0){
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(list);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("没有找到匹配的名字");
			return result;
		}			
	}

	@Override
	public MsgResult findDoctorBySpecialty(String specialty) {
		MsgResult result=new MsgResult();
		List<Doctor> list=doctorDao.findBySpecialty(specialty);
		if(list.size()!=0){
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(list);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("没有找到匹配的专业");
			return result;
		}
	}

	
	@Override
	public MsgResult findReserve(String pid) {
		MsgResult result=new MsgResult();
		List<Reserve> list=reserveDao.findReserve(Integer.parseInt(pid));
		for(int i=0;i<list.size();i++){
			String rDate=list.get(i).getrDate().toString().substring(0,19);
			String rDay=list.get(i).getrDay().toString().substring(0,19);	
			list.get(i).setDatetime(rDate);
			list.get(i).setDaytime(rDay);
		}
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(list);
		return result;
	}

	@Override
	public MsgResult reservation(String did,String dname, String  pid, String rDay) {
		MsgResult result=new MsgResult();
		Reserve r=new Reserve();
		r.setDid(did);
		r.setDname(dname);
		r.setPid(Integer.parseInt(pid));	
		r.setrDay(Timestamp.valueOf(rDay));	
		//判断预约时间是否大于现在的时间
		if(r.getrDay().before(new Date())){
			result.setMsg("预约时间必须大于当前时间");
			result.setStatus(1);
			return result;
		}
		//判断该时间段是否已有预约
		
		
		reserveDao.reservation(r);
		result.setStatus(0);
		result.setMsg("预约成功");
		result.setData(r);
		return result;
	}

	@Override
	public MsgResult findName(String pid) {
		//查询用户名字并返回
		MsgResult result=new MsgResult();
		Patient patient=patientDao.findName(Integer.parseInt(pid));
		result.setStatus(0);
		result.setData(patient.getName());
		return result;
	}

	@Override
	public MsgResult cancelReserve(String cid) {
		//取消预约
		MsgResult result=new MsgResult();
		reserveDao.cancelReserve(Integer.parseInt(cid));
		result.setMsg("取消成功");
		result.setStatus(0);
		return result;
	}


}
