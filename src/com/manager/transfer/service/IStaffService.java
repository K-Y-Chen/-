package com.manager.transfer.service;

import java.util.ArrayList;

import com.manager.transfer.domain.Department;
import com.manager.transfer.domain.Job;
import com.manager.transfer.domain.Staff;



public interface IStaffService {
	public boolean insertStaff(Staff s);//插入员工记录。
	
	public ArrayList<Staff> queryStaffByBase();//查询所有在人才库中的员工
	public ArrayList<Staff> queryStaffByDis();//查询所有在职的员工
	
	public Staff queryStaffByIdNum(String idNum);//通过身份证号查询id
	
	public boolean updateStaffDismissionById(Staff s);//更新员工的离职与否，只要id属性和离职属性
	public boolean updateStaffDepartmentById(Staff s);//更新员工的部门信息，只要id属性和部门属性
	public boolean updateStaffJobById(Staff s);//更新员工的岗位信息，只要id属性和岗位属性
	
	public ArrayList<Staff> queryStaffTrailByDepartment(Department dep);//通过部门名称查找试 用员工
	public ArrayList<Staff> queryStaffTrailByJob(Job job);//通过岗位名称查找试 用员工

	public ArrayList<Staff> queryStaffByDepartment(Department dep);//通过部门名称查找员工, 模糊查询
	public ArrayList<Staff> queryStaffByJob(Job job);//通过岗位名称查找员工, 模糊查询
	
	public ArrayList<Staff> queryStaffCheckByDepartment(Department dep);//通过部门名称查找转正员工
	public ArrayList<Staff> queryStaffCheckByJob(Job job);//通过岗位名称查找转正员工
}
