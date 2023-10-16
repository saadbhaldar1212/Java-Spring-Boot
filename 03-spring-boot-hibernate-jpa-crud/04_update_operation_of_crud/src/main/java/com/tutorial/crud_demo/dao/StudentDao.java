package com.tutorial.crud_demo.dao;

import java.util.List;

import com.tutorial.crud_demo.entity.Student;

public interface StudentDao {
	
	public void createStudent(Student student);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
	
	public void update(Student student);

}
