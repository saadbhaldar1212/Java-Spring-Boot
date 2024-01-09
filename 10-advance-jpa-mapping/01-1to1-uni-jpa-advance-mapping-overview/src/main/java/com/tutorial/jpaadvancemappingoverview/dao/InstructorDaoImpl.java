package com.tutorial.jpaadvancemappingoverview.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.jpaadvancemappingoverview.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class InstructorDaoImpl implements InstructorDao{
	
	private EntityManager entityManager;

	@Autowired
	public InstructorDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor tempId = entityManager.find(Instructor.class, id);
		entityManager.remove(tempId);
	}
	
}
