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
	
//	CommandLineRunner runs after the Bean are loaded
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		
		// Create the student object
		System.out.println("Create a new student..");
		Student newStudent = new Student("Mohammad Saad", "Bhaldar", 
				"saadbhaldar1212@gmail.com");
		
		// Save the student object
		System.out.println("Save a new student..");
		studentDao.save(newStudent);
		
		// Display the generated Id
		System.out.println("Student id: " + newStudent.getId());
		
	}

}
