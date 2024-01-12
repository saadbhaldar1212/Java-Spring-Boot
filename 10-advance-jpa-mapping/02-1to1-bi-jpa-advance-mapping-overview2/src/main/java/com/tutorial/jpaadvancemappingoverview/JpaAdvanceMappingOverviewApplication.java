package com.tutorial.jpaadvancemappingoverview;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tutorial.jpaadvancemappingoverview.dao.InstructorDao;
import com.tutorial.jpaadvancemappingoverview.entity.Instructor;
import com.tutorial.jpaadvancemappingoverview.entity.InstructorDetail;

@SpringBootApplication
public class JpaAdvanceMappingOverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvanceMappingOverviewApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao) {
		return runner -> {
//			createInstructor(instructorDao);
//			findInstructorById(instructorDao);
//			deleteInstructorById(instructorDao);
			findInstructorDetailById(instructorDao);
		};
	}

	
	private void createInstructor(InstructorDao instructorDao) {
		Instructor instructor = new Instructor("Mohammad", "Bhaldar", "saadbhaldar1212@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/watch?v=bcphZPaCuHs",
				"Carrom");
		
		instructor.setInstructorDetails(instructorDetail);
		
		System.out.println("Saving Instruction Details");
		instructorDao.save(instructor);
		System.out.println("Done");

	}
	
	private void findInstructorById(InstructorDao instructorDao) {
		System.out.println(instructorDao.findInstructorById(1));
	}
	
	private void deleteInstructorById(InstructorDao instructorDao) {
		instructorDao.deleteInstructorById(1);
		System.out.println("Entity Deleted");
	}
	
	private void findInstructorDetailById(InstructorDao instructorDao) {
		InstructorDetail tempInstructorDetail = instructorDao.findInstructorDetailById(3);
		System.out.println("Details are: ");
		System.out.println(tempInstructorDetail);
		System.out.println("Associate Instructor are: " + tempInstructorDetail.getInstructor());
	}
}
