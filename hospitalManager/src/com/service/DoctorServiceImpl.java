package com.service;

import com.util.MsgResult;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DoctorDao;
import com.dao.MedicalRecordDao;
import com.dao.PatientDao;
import com.dao.ReserveDao;
import com.entity.Doctor;
import com.entity.MedicalRecord;
import com.entity.Reserve;
@Service
public class DoctorServiceImpl implements DoctorService {

	@Resource
	private DoctorDao doctorDao;
	@Resource
	private ReserveDao reserveDao;
	@Resource
	private MedicalRecordDao medicalRecordDao;
	@Resource
	private PatientDao patientDao;
	
	@Override
	public MsgResult findName(String did) {
		//查询用户名字并返回
		MsgResult result=new MsgResult();
		Doctor doctor=doctorDao.findByDid(did);
		result.setStatus(0);
		result.setData(doctor.getname());
		return result;
	}

	@Override
	public MsgResult findPatient(String did) {
		//查询预约患者的信息
		MsgResult result=new MsgResult();
		List<Reserve> list=reserveDao.findReserveByDid(did);
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
	public MsgResult creatMR(String did, String description, String diagnose,
			String pname, String prescribe) {
		//创建患者病历
		MsgResult result=new MsgResult();
		MedicalRecord mRecord=new MedicalRecord();
		mRecord.setDid(did);
		mRecord.setDescription(description);
		mRecord.setDiagnose(diagnose);
		mRecord.setPname(pname);
		mRecord.setPrescribe(prescribe);
		medicalRecordDao.creatMR(mRecord);
		result.setMsg("创建成功");
		result.setStatus(0);
		return result;
	}

	@Override
	public MsgResult findBypiddid(String pid,String did) {
		MsgResult result=new MsgResult();
		//利用pid查询患者的名字
		String pname=patientDao.findName(Integer.parseInt(pid)).getName();
		//利用did查询医生管理的病历
		List<MedicalRecord> list=medicalRecordDao.findMRBydid(did);
		for(int i=0;i<list.size();i++){
			String name=list.get(i).getPname();
			if(name.equals(pname)){
				MedicalRecord m=list.get(i);
				String fdate=m.getsDate().toString().toString().substring(0,19);
				m.setfDate(fdate);
				result.setData(m);
				result.setMsg("已创建该病历");
				result.setStatus(0);
				return result;
			}
		}
		result.setData(pname);
		result.setMsg("无对应病历，请创建");
		result.setStatus(1);
		return result;
	}

	@Override
	public MsgResult updateMR(String rid, String did, String description,
			String diagnose, String pname, String prescribe) {
		MsgResult result=new MsgResult();
		MedicalRecord mRecord=new MedicalRecord();
		mRecord.setrid(Integer.parseInt(rid));
		mRecord.setDid(did);
		mRecord.setDescription(description);
		mRecord.setDiagnose(diagnose);
		mRecord.setPname(pname);
		mRecord.setPrescribe(prescribe);
		medicalRecordDao.updateMR(mRecord);
		result.setMsg("修改病例成功");
		result.setStatus(0);
		return result;
	}


}
