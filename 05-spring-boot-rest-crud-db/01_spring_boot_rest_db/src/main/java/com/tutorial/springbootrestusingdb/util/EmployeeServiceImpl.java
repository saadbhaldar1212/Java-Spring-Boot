package com.tutorial.springbootrestusingdb.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.springbootrestusingdb.dao.EmployeeDao;
import com.tutorial.springbootrestusingdb.entity.Employee;
import com.tutorial.springbootrestusingdb.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
 	}
	
	@Transactional
	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee findById(int empId) {
		return employeeDao.findById(empId);
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Transactional
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeDao.deleteEmployeeById(id);
	}

}
