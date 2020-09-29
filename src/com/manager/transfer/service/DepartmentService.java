package com.manager.transfer.service;

import com.manager.transfer.dao.DepartmentDao;
import com.manager.transfer.dao.IDepartmentDao;
import com.manager.transfer.domain.Department;

public class DepartmentService implements IDepartmentService {

	@Override
	public Department queryIdDepartmentsByName(String name) {
		IDepartmentDao ids = new DepartmentDao ();
		return ids.queryIdDepartmentsByName(name);
	}
//	public static void main(String [] args) {
//		IDepartmentService idd =new DepartmentService();
//		Department ds = idd.queryIdDepartmentsByName("销售部门");
//		System.out.print(ds.getD_id());
//	}
}
