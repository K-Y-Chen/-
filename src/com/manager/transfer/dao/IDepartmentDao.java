package com.manager.transfer.dao;

import com.manager.transfer.domain.Department;

public interface IDepartmentDao {
	//ͨ�����Ʊ�����Ʋ��Ҳ�����Ϣ
	public Department queryIdDepartmentsByName(String name);
}
