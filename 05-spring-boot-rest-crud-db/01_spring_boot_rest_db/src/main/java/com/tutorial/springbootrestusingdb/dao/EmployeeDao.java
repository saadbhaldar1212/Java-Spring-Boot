package com.tutorial.springbootrestusingdb.dao;

import java.util.List;

import com.tutorial.springbootrestusingdb.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployee();
	
	public Employee findById(int empId);
	
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployeeById(int id);

}
