package com.tutorial.crud_demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud_demo.entity.Student;

import jakarta.persistence.EntityManager;

/*
 @Repository annotation is a sub-class of @Component class which will be used
 for component scanning and avoid the checked JDBC errors to un-checked errors
*/
@Repository
public class StudentDaoImpl implements StudentDao{
	
	// Define field for Entity Manager
	// Entity Manager is a JPA special class which is used to manage the Entities
	private EntityManager entityManager;
	
	// Inject Entity Manager using Constuctor Injection
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	//Implement run method 
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	/*
	 @Transactional annotation of Spring Framework is used to manage the current session
	 of the transactions (start and stop) automatically
	 */

}
