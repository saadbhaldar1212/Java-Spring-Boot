package com.tutorial.crud_demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tutorial.crud_demo.dao.StudentDao;
import com.tutorial.crud_demo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			// Create
//			createStudent(studentDao);
			
			// Read
//			findById(studentDao);
//			findAllStudents(studentDao);
//			findByLastName(studentDao);
			
			// Update
//			updateStudent(studentDao);
			
			// Delete
//			deleteStudent(studentDao);
//			deleteAll(studentDao);
		};
	}

	private void deleteAll(StudentDao studentDao) {
		int numOfRows = studentDao.deleteAll();
		System.out.println(numOfRows + " Rows affected");
	}

	private void deleteStudent(StudentDao studentDao) {
		int id = 1;
		
		studentDao.delete(id);
		System.out.println("Deleted successfully where s_id = " + id);
	}

	private void updateStudent(StudentDao studentDao) {
		int id = 1;
		Student myStudent = studentDao.findById(id);
		
		myStudent.setFirstName("Ramzan");
		studentDao.update(myStudent);
		
		System.out.println("Updated successfully");
	}

	private void findByLastName(StudentDao studentDao) {
		List<Student> getByLastName = studentDao.findByLastName("Bhaldar");
		
		for (Student newStudent : getByLastName) {
			System.out.println(newStudent);
		}
	}

	private void findAllStudents(StudentDao studentDao) {
		List<Student> getAllStudents = studentDao.findAll();
		
		for(Student newStudent : getAllStudents) {
			System.out.println(newStudent);
		}
	}

	private void findById(StudentDao studentDao) {
		Student newStudent = new Student("Aman", "Bhaldar", "aman@gmail.com");
		studentDao.createStudent(newStudent);
		System.out.println("Details are: " + studentDao.findById(newStudent.getId()));
	}

	private void createStudent(StudentDao studentDao) {
		Student newStudent = new Student("Mohammad Saad", "Bhaldar", 
				"saad@gmail.com");
		
		studentDao.createStudent(newStudent);
		
		System.out.println("Student created successfully");
	}

}
