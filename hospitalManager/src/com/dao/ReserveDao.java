package com.dao;

import java.util.List;

import com.entity.Reserve;

public interface ReserveDao {
	public void reservation(Reserve reserve);
	public List<Reserve> findReserve(int pid);
	public Reserve findReserveByCid(int cid);
	public void cancelReserve(int cid);
	public List<Reserve> findReserveByDid(String did);
}
