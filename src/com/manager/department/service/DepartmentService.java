package com.manager.department.service;

import java.util.ArrayList;

import com.manager.department.dao.DepartmentDao;
import com.manager.department.dao.IDepartmentDao;
import com.manager.department.domain.Department;
import com.manager.department.domain.Staff;

public class DepartmentService implements IDepartmentService{

	@Override
	public ArrayList<Department> queryDepartments() {

		IDepartmentDao d = new DepartmentDao();
		return d.queryDepartments();
	}

	@Override
	public ArrayList<Department> queryDepartmentsById(int id) {
		IDepartmentDao d = new DepartmentDao();
		return d.queryDepartmentsById(id);
	}

	@Override
	public ArrayList<Department> queryDepartmentsByName(String name) {
		IDepartmentDao d = new DepartmentDao();
		return d.queryDepartmentsByName(name);
	}

	@Override
	public ArrayList<Department> queryDepartmentsByType(String type) {
		IDepartmentDao d = new DepartmentDao();
		return d.queryDepartmentsByType(type);
	}

	@Override
	public ArrayList<Staff> queryStaffsInDep(String departmentname) {
		IDepartmentDao d = new DepartmentDao();
		return d.queryStaffsInDep(departmentname);
	}

	@Override
	public boolean insertDepartment(Department d) {
		IDepartmentDao id = new DepartmentDao();
		return id.insertDepartment(d);
	}

	@Override
	public boolean updateDepartment(Department d) {
		IDepartmentDao id = new DepartmentDao();
		return id.updateDepartment(d);
	}

	@Override
	public boolean deleteDepartmentByName(Department d) {
		IDepartmentDao id = new DepartmentDao();
		return id.deleteDepartmentByName(d);
	}
	
	
//	public static void main(String ar[]) {
//		IDepartmentDao d = new DepartmentDao();
//		Department dep = new Department(2,"≤‚ ‘","≤ø√≈","121","2020-02-23");
//		//d.queryDepartments();
//		d.insertDepartment(dep);
//	}

}
