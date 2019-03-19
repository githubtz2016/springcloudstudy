package com.dao;

import java.util.List;

import com.entity.Doctor;

public interface DoctorDao {
	public void addDoctor(Doctor doctor);
	public List<Doctor> findAllDoctor();
	public void deleteDoctor(String did);
	public Doctor findByDid(String did);
	public Doctor findByDoctorName(String name);
	public void dynamicUpdateDoctor(Doctor doctor);
	public List<Doctor> findBySpecialty(String specialty);
	public List<Doctor> findLikeName(String name);
}
