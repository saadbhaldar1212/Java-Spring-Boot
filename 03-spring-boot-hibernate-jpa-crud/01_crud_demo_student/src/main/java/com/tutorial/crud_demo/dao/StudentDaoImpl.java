package com.tutorial.crud_demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud_demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	/*
	 @Transactional annotation of Spring Framework is used to manage the current session
	 of the transactions (start and stop) automatically
	 */

	@Override
	public List<Student> findAll() {
		// Create query 
		
		// Note: JPAQL accepts Entity table and Entity parameters
		TypedQuery<Student> query = entityManager.createQuery(
				"FROM Student where lastName='Bhaldar'", Student.class);
		
		/*
		 * WHERE lastName = 'Ahmad'
		 * ORDER BY lastName ASC
		 * ORDER BY lastName DESC
		 * WHERE email = '%gmail.com'
		 */
		
		// Return query results
		return query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		
		// Inside createQuery() we can use simple query and Parameterized query using
		// :(colon) and then pass the variable value through setParameter()
		
		TypedQuery<Student> query = entityManager.createQuery(
				"FROM Student where lastName=:lastName", Student.class);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student myStudent = entityManager.find(Student.class, id);
		entityManager.remove(myStudent);
	}

	@Override
	@Transactional
	public int deleteAllStudent() {
		int numOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numOfRowsDeleted;
	}

}
