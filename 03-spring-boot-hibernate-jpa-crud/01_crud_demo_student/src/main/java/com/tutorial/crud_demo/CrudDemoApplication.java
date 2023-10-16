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
	
//	CommandLineRunner runs after the Bean are loaded
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			// For Create operation
//			createStudent(studentDao);
			createMultipleStudents(studentDao);
			
			// For Read operation
			 
			/*
			readStudent(studentDao);
			readAllStudent(studentDao);
			queryForFindByLastName(studentDao); 
			*/
			
			// For Update operation
//			updateStudentByFirstName(studentDao);
			
			// For Delete Operation
//			deleteStudent(studentDao);
//			deleteAllStudent(studentDao);
		};
	}

	/*
	private void deleteAllStudent(StudentDao studentDao) {
		int noOfRows = studentDao.deleteAllStudent();
		System.out.println("Deleted rows: " + noOfRows);
	}

	private void deleteStudent(StudentDao studentDao) {
		int myId = 7;
		System.out.println("Deleting ID: " + myId);
		
		studentDao.delete(myId);
		System.out.println("Deleted successfully");
	}

	private void updateStudentByFirstName(StudentDao studentDao) {
		// Retrieve the student based on the ID
		int myId = 1;
		Student myStudent = studentDao.findById(myId);
		
		// Change first name to "Scooby"
		myStudent.setFirstName("Ramzan");
		
		// Update the Student
		studentDao.update(myStudent);
		
		// Display the updated student
		System.out.println("Updated student: " + myStudent);
	}
	
	

	// Read Operation
	private void queryForFindByLastName(StudentDao studentDao) {
		List<Student> allStudents = studentDao.findByLastName("Kadam");
		for(Student newStudent : allStudents) {
			System.out.println(newStudent);
		}
	}

	private void readAllStudent(StudentDao studentDao) {
		
		// List of Student
		List<Student> allStudents = studentDao.findAll();
		
		// Fetch multiple students using foreach loop
		for(Student newStudent : allStudents) {
			System.out.println(newStudent);
		}
	}
	
	*/

	/*
	private void readStudent(StudentDao studentDao) {
		// Create student object
		Student newStudent = new Student("Aman", "Bhaldar", 
				"amanabhaldar1212@gmail.com");
		
		// save student info
		studentDao.save(newStudent);
		
		// Fetch Student info by Id
		System.out.println("Details saved: " + newStudent.getId());
		
		// Find by id
		System.out.println("Details are: " + studentDao.findById(newStudent.getId()));
	}
	
	

	// Create operation
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
	*/
	
	private void createMultipleStudents(StudentDao studentDao) {
		// Create the student object
		System.out.println("Create a new student..");
		Student newStudent1 = new Student("Mohammad Saad", "Bhaldar", 
						"saadbhaldar1212@gmail.com");
		Student newStudent2 = new Student("Mohammad Saad", "Bhaldar", 
				"saadbhaldar1212@gmail.com");
		Student newStudent3 = new Student("Mohammad Saad", "Bhaldar", 
				"saadbhaldar1212@gmail.com");
				
		// Save the student object
		System.out.println("Save a new student..");
		studentDao.save(newStudent1);
		studentDao.save(newStudent2);
		studentDao.save(newStudent3);
		
		System.out.println("Created successfully");
	}

}
