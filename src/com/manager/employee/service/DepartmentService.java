package com.manager.employee.service;

import java.util.ArrayList;

import com.manager.employee.dao.DepartmentDao;
import com.manager.employee.dao.IDepartmentDao;
import com.manager.employee.domain.Department;

public class DepartmentService implements IDepartmentService {

	@Override
	public ArrayList<Department> queryDepartment() {
		IDepartmentDao de = new DepartmentDao();
		return de.getAllDNames();
	}

}
