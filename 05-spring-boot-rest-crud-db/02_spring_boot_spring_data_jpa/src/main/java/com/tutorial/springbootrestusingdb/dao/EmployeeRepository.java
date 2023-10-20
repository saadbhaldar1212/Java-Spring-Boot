package com.tutorial.springbootrestusingdb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.springbootrestusingdb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
