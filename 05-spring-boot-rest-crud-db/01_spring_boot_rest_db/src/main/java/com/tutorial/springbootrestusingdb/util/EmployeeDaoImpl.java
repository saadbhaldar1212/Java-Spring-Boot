package com.tutorial.springbootrestusingdb.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.springbootrestusingdb.dao.EmployeeDao;
import com.tutorial.springbootrestusingdb.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findById(int empId) {
		Employee myId = entityManager.find(Employee.class, empId);
		return myId;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		entityManager.remove(emp);
		
		System.out.println("Deleted emp ID: " + emp);
	}
	
}
