package com.dao;

import com.entity.Admin;

public interface AdminDao {
	public Admin findByAdminUser(String userName);
	public Admin findName(int aid);
}
