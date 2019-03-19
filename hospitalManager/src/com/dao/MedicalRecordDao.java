package com.dao;

import java.util.List;

import com.entity.MedicalRecord;

public interface MedicalRecordDao {
	public void creatMR(MedicalRecord mRecord);
	public List<MedicalRecord> findMRBydid(String  did);
	public void updateMR(MedicalRecord mRecord);
}
