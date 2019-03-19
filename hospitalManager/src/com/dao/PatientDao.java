package com.dao;

import com.entity.Patient;

public interface PatientDao {
	public void register(Patient patient);
	public Patient findByPatientUser(String userName);
	public Patient findByName(String name);
	public Patient findName(int pid);
}
