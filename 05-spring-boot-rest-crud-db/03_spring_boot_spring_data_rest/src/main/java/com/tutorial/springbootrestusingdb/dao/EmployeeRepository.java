package com.tutorial.springbootrestusingdb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.springbootrestusingdb.entity.Employee;

// @RepostiryRestResource annotation is used to manually change the path name
//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
