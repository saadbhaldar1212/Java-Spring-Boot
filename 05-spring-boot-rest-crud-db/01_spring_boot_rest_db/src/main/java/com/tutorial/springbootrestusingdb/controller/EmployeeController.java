package com.tutorial.springbootrestusingdb.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springbootrestusingdb.entity.Employee;
import com.tutorial.springbootrestusingdb.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		
		Employee myEmployee = employeeService.findById(employeeId);
		
		if (myEmployee == null) {
			throw new RuntimeException("Employee id not found" + employeeId);
		}
		
		return myEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setEmpId(0);
		
		Employee employeeDB = employeeService.addEmployee(employee);
		return employeeDB;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{empId}")
	public void deleteEmployee(@PathVariable int empId) {
		
		Employee myEmployee = employeeService.findById(empId);
		
		if (myEmployee == null) {
			throw new RuntimeException("No student found");
		}
		employeeService.deleteEmployeeById(empId);
	}

}
