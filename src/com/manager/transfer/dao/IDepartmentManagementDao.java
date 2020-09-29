package com.manager.transfer.dao;

import java.util.ArrayList;

import com.manager.transfer.domain.DepartmentTransfer;
import com.manager.transfer.domain.Staff;



public interface IDepartmentManagementDao {
	//向部门调动表插入记录
	public boolean insertDepartmentTransfer(DepartmentTransfer dt);
	public boolean updateDepartmentTransfer(DepartmentTransfer dt);
	public boolean deleteDepartmentTransfer(DepartmentTransfer dt);
	
	//通过流水编号查找部门调动信息。
	//注意这些查询 返回的Department和Staff对象只有编号和名称。
	public ArrayList<DepartmentTransfer> querydtById(int id);
	
	//通过调转前部门的名称查找部门调动信息
	public ArrayList<DepartmentTransfer> querydtByPreDepName(String preDepName);
	public ArrayList<DepartmentTransfer> querydtByDepName(String DepName);
	
	//通过调转前部门的id查找部门调动信息
	public ArrayList<DepartmentTransfer> querydtByPreDepId(int preDepId);
	//通过调转后部门的id查找部门调动信息	
	public ArrayList<DepartmentTransfer> querydtByDepId(int depId);
	//通过调转员工id查找部门调动信息		
	public ArrayList<DepartmentTransfer> querydtByStaffId(int staffId);
	//通过调转类型查找部门调动信息		
	public ArrayList<DepartmentTransfer> querydtByType(String type);
	//通过调转日期查找部门调动信息		
	public ArrayList<DepartmentTransfer> querydtByDate(String date);
	
//	public ArrayList<Staff> queryDepartmentTransferStaffByDate(String date);//查询要的员工
	//定位要调动部门的员工
	public ArrayList<Staff> queryDepartmentTransferStaffb(String departmentName);//查询该部门调走的员工
	public ArrayList<Staff> queryDepartmentTransferStaffa(String departmentName);//查询该部门调入的员工	
}
