package com.manager.department.service;

import java.util.ArrayList;

import com.manager.department.domain.Department;
import com.manager.department.domain.Staff;

public interface IDepartmentService {
	//获取部门表所有信息
	public ArrayList<Department> queryDepartments();
	
	//通过编号名称查找部门信息
	public ArrayList<Department> queryDepartmentsById(int id);
	
	//通过名称编号名称查找部门信息
	public ArrayList<Department> queryDepartmentsByName(String name);
	
	//通过类型查找部门信息
	public ArrayList<Department> queryDepartmentsByType(String type);
	
	//查询指定部门下当前在职员工信息
	public ArrayList<Staff> queryStaffsInDep(String departmentname);
	
	//新建一个部门
	public boolean insertDepartment(Department d);
	
	//修改已有部门的信息
	public boolean updateDepartment(Department d);
	
	//删除一个部门
	public boolean deleteDepartmentByName(Department d);
}
