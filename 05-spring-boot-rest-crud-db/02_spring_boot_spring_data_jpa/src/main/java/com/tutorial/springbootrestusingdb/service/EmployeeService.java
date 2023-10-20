package com.tutorial.springbootrestusingdb.service;

import java.util.List;

import com.tutorial.springbootrestusingdb.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	
	public Employee findById(int empId);
	
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployeeById(int id);
}
