package com.manager.transfer.service;

import java.util.ArrayList;

import com.manager.transfer.dao.IStaffDao;
import com.manager.transfer.dao.StaffDao;
import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.Job;
import com.manager.transfer.domain.Staff;



public class StaffService implements IStaffService {

	@Override
	public boolean insertStaff(Staff s) {
		IStaffDao ist = new StaffDao();
		return ist.insertStaff(s);
	}

	@Override
	public ArrayList<Staff> queryStaffByBase() {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffByBase();
	}

	@Override
	public ArrayList<Staff> queryStaffByDis() {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffByDis();
	}

	@Override
	public boolean updateStaffDismissionById(Staff s) {
		IStaffDao ist = new StaffDao();
		return ist.updateStaffDismissionById(s);
	}

	@Override
	public boolean updateStaffDepartmentById(Staff s) {
		IStaffDao ist = new StaffDao();
		return ist.updateStaffDepartmentById(s) ;
	}

	@Override
	public boolean updateStaffJobById(Staff s) {
		IStaffDao ist = new StaffDao();
		return ist.updateStaffJobById(s) ;
	}

	@Override
	public ArrayList<Staff> queryStaffTrailByDepartment(Department dep) {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffTrailByDepartment(dep);
	}

	@Override
	public ArrayList<Staff> queryStaffTrailByJob(Job job) {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffTrailByJob(job) ;
	}

	@Override
	public ArrayList<Staff> queryStaffCheckByDepartment(Department dep) {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffCheckByDepartment(dep);
	}

	@Override
	public ArrayList<Staff> queryStaffCheckByJob(Job job) {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffCheckByJob(job);
	}

	@Override
	public Staff queryStaffByIdNum(String idNum) {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffByIdNum(idNum);
	}

	@Override
	public ArrayList<Staff> queryStaffByDepartment(Department dep) {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffByDepartment(dep);
	}

	@Override
	public ArrayList<Staff> queryStaffByJob(Job job) {
		IStaffDao ist = new StaffDao();
		return ist.queryStaffByJob(job);
	}
}
