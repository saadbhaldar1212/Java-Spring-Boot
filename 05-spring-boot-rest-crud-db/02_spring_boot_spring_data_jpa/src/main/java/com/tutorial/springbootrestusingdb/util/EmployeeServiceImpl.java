package com.tutorial.springbootrestusingdb.util;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.springbootrestusingdb.dao.EmployeeRepository;
import com.tutorial.springbootrestusingdb.entity.Employee;
import com.tutorial.springbootrestusingdb.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
 	}
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int empId) {
		Optional<Employee> result = employeeRepository.findById(empId);
		
		Employee myEmployee = null;
		
		if (result.isPresent()) {
			myEmployee = result.get();
		} else {
			throw new RuntimeException("Invalid Employee ID");
		}
		return myEmployee;
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Transactional
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

}
