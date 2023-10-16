package com.tutorial.crud_demo.dao;

import java.util.List;

import com.tutorial.crud_demo.entity.Student;

public interface StudentDao {
	
	// Function implementation -> for method overriding
	public void save(Student theStudent);
	
	// Find by id
	Student findById(Integer id);
	
	// Find all
	List<Student> findAll();
	
	// Find by lastName
	List<Student> findByLastName(String lastName);
	
	// Update Student
	void update(Student student);
	
	// Delete Student
	void delete(Integer id);
	
	// Delete All
	int deleteAllStudent();
}
