package com.manager.department.dao;

import java.util.ArrayList;

import com.manager.department.domain.*;


public interface IDepartmentDao {
	//��ȡ���ű�������Ϣ
	public ArrayList<Department> queryDepartments();
	
	//ͨ����Ų��Ҳ�����Ϣ
	public ArrayList<Department> queryDepartmentsById(int id);
	
	//ͨ�����Ʋ��Ҳ�����Ϣ
	public ArrayList<Department> queryDepartmentsByName(String name);
	
	//ͨ�����Ͳ��Ҳ�����Ϣ
	public ArrayList<Department> queryDepartmentsByType(String type);
	
	//��ѯָ�������µ�ǰ��ְԱ����Ϣ
	public ArrayList<Staff> queryStaffsInDep(String departmentname);
	
	//�½�һ������
	public boolean insertDepartment(Department d);
	
	//�޸����в��ŵ���Ϣ
	public boolean updateDepartment(Department d);
	
	//ɾ��һ������
	public boolean deleteDepartmentByName(Department d);
	
}
