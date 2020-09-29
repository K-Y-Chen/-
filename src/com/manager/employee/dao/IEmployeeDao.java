package com.manager.employee.dao;

import java.util.ArrayList;

import com.manager.employee.domain.Employee;


public interface IEmployeeDao {
	public ArrayList<Employee> queryEmployee(String Employeename);
	public Employee queryEmployee(int id);
	public boolean updateEmployee(Employee es);
	public boolean deleteEmployee(int eid);
	
}
