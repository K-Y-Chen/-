package com.manager.transfer.dao;

import java.util.ArrayList;

import com.manager.transfer.domain.StaffCheck;

public interface IStaffCheckDao {
	public boolean insertStaffCheck(StaffCheck st);
	
	public boolean updateStaffCheck(StaffCheck st);
	public boolean deleteStaffCheck(StaffCheck st);
	
	public ArrayList<StaffCheck> queryStaffCheckById(int id);
	public ArrayList<StaffCheck> queryStaffCheckByNum(int scId);
	public ArrayList<StaffCheck> queryStaffCheckByResult(String result);
	public ArrayList<StaffCheck> queryStaffCheckByDate(String date);
}
