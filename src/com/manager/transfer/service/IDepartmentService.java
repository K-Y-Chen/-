package com.manager.transfer.service;

import com.manager.transfer.domain.Department;

public interface IDepartmentService {
	//通过名称编号名称查找部门信息
		public Department queryIdDepartmentsByName(String name);
}
