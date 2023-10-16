package com.tutorial.crud_demo;

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
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		Student newStudent = new Student("Mohammad Saad", "Bhaldar", 
				"saad@gmail.com");
		
		studentDao.createStudent(newStudent);
		
		System.out.println("Student created successfully");
	}

}
