package com.tutorial.jpaadvancemappingoverview.dao;

import com.tutorial.jpaadvancemappingoverview.entity.Instructor;

public interface InstructorDao {
	
	void save(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);

}
