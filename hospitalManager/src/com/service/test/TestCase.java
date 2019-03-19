package com.service.test;

import com.util.MsgResult;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Doctor;
import com.service.AdminService;
import com.service.DoctorService;
import com.service.PatientService;

public class TestCase {

	
	@Test
	public void admindoctor(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService=ac.getBean("adminServiceImpl",AdminService.class);
		//MsgResult result=adminService.addDoctorUser("1","张三", "40","男", "123", "主治医师","医务部","骨科","123456");
		//MsgResult result1=adminService.addDoctorUser("2","张三", "40","男", "123", "主治医师","医务部","骨科","123456");
		//System.out.println(result1.getStatus()+","+result1.getMsg());
		//MsgResult list=adminService.findAllDoctor();
		//System.out.println(list.getData());
		//MsgResult result2=adminService.deleteDoctor("2");
		//System.out.println(result2.getStatus()+result2.getMsg());
		MsgResult d=adminService.findByDid("2");
		System.out.println(d.getData());
	}
	
	@Test
	public void patientregister(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientService patientService=ac.getBean("patientServiceImpl",PatientService.class);
		MsgResult result=patientService.register("tz","唐峥", "123456", "22", "男","四川成都","15708497452");
		System.out.println(result.getStatus()+","+result.getMsg());
	}
	
	@Test
	public void doctortext(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		DoctorService doctorService=ac.getBean("doctorServiceImpl",DoctorService.class);
		//MsgResult result=doctorService.creatMR("2","咳嗽，发烧，四肢无力","流行性感冒", "5", "感冒颗粒");
		//System.out.println(result.getStatus()+","+result.getMsg());
		//MsgResult result=doctorService.updateMR("2", "2", "只是咳嗽","一般感冒","5","多喝水");
		//System.out.println(result.getStatus()+","+result.getMsg());
        MsgResult result=doctorService.findBypiddid("1", "5");
        System.out.println(result.getMsg());

	}
	
	@Test
	public void reserve(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientService patientService=ac.getBean("patientServiceImpl",PatientService.class);
		MsgResult result=patientService.reservation("2","张三", "5", "2016-05-26 09:12:12");
		System.out.println(result.getData()+","+result.getMsg());
	}
	
	@Test
	public void reservefind(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientService patientService=ac.getBean("patientServiceImpl",PatientService.class);
		MsgResult result=patientService.findReserve("5");
		System.out.println(result.getData()+","+result.getMsg());
	}
	
	@Test
	public void patientfind(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientService patientService=ac.getBean("patientServiceImpl",PatientService.class);
		MsgResult result=patientService.findDoctorBySpecialty("外");
		System.out.println(result.getData()+","+result.getMsg());
	}
	
	@Test
	public void adminUpdateDoctor(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService=ac.getBean("adminServiceImpl",AdminService.class);
		MsgResult result=adminService.updateDoctor("2", "123", "fadf", "dfadf", "fdafe", "eqreaf");
		System.out.println(result.getData()+","+result.getMsg());
	}
	

}
