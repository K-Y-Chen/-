package com.manager.transfer.service;

import java.util.ArrayList;

import com.manager.transfer.dao.DepartmentManagementDao;
import com.manager.transfer.dao.IDepartmentManagementDao;
import com.manager.transfer.domain.DepartmentTransfer;
import com.manager.transfer.domain.Staff;



public class DepartmentManagementService implements IDepartmentManagementService {

	@Override
	public boolean insertDepartmentTransfer(DepartmentTransfer dt) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.insertDepartmentTransfer(dt);
	}

	@Override
	public boolean updateDepartmentTransfer(DepartmentTransfer dt) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.updateDepartmentTransfer(dt);
	}

	@Override
	public boolean deleteDepartmentTransfer(DepartmentTransfer dt) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.deleteDepartmentTransfer(dt);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtById(int id) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtById(id);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByPreDepName(String preDepName) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtByPreDepName(preDepName);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByDepName(String DepName) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtByDepName(DepName);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByPreDepId(int preDepId) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtByPreDepId(preDepId);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByDepId(int depId) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtByDepId(depId);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByStaffId(int staffId) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtByStaffId(staffId);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByType(String type) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtByType(type);
	}

	@Override
	public ArrayList<DepartmentTransfer> querydtByDate(String date) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.querydtByDate(date);
	}

	@Override
	public ArrayList<Staff> queryDepartmentTransferStaffb(String departmentName) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.queryDepartmentTransferStaffb(departmentName);
	}

	@Override
	public ArrayList<Staff> queryDepartmentTransferStaffa(String departmentName) {
		IDepartmentManagementDao idms = new DepartmentManagementDao();
		return idms.queryDepartmentTransferStaffa(departmentName);
	}

}
