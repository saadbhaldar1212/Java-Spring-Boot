package com.tutorial.jpaadvancemappingoverview.dao;

import com.tutorial.jpaadvancemappingoverview.entity.Instructor;
import com.tutorial.jpaadvancemappingoverview.entity.InstructorDetail;

public interface InstructorDao {
	
	void save(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
	
	InstructorDetail findInstructorDetailById(int id);

}
