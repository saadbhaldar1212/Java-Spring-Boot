package com.tutorial.crud_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.crud_demo.dao.StudentDao;
import com.tutorial.crud_demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void createStudent(Student student) {
		entityManager.persist(student);
	}
	
}
