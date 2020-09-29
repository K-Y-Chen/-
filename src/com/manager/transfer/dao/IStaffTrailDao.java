package com.manager.transfer.dao;

import java.util.ArrayList;

import com.manager.transfer.domain.StaffTrail;

public interface IStaffTrailDao {
	public boolean insertStaffTrail(StaffTrail sc);
	
	public boolean updateStaffTrail(StaffTrail sc);
	public boolean deleteStaffTrail(StaffTrail sc);
	
	public ArrayList<StaffTrail> queryStaffTrailById(int id);
	public ArrayList<StaffTrail> queryStaffTrailByStaffId(int StaffId);
	public ArrayList<StaffTrail> queryStaffTrailBysDate(String sDate);
	public ArrayList<StaffTrail> queryStaffTrailByeDate(String eDate);
	
}
