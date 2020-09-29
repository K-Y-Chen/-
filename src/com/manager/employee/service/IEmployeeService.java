package com.manager.employee.service;

import java.util.ArrayList;

import com.manager.employee.domain.Employee;


public interface IEmployeeService {
	public ArrayList<Employee> queryEmployee(String productname);
	public Employee queryEmployeeByID(int id);
	public boolean updateEmployee(Employee p);

}
