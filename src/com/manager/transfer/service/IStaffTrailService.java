package com.manager.transfer.service;

import java.util.ArrayList;

import com.manager.transfer.domain.StaffTrail;



public interface IStaffTrailService {
	public boolean insertStaffTrail(StaffTrail st);
	
	public boolean updateStaffTrail(StaffTrail st);
	public boolean deleteStaffTrail(StaffTrail st);
	
	public ArrayList<StaffTrail> queryStaffTrailById(int id);
	public ArrayList<StaffTrail> queryStaffTrailByStaffId(int StaffId);
	public ArrayList<StaffTrail> queryStaffTrailBysDate(String sDate);
	public ArrayList<StaffTrail> queryStaffTrailByeDate(String eDate);
}
