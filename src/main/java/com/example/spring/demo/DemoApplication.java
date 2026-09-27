package com.example.spring.demo;

import com.example.spring.demo.dao.StudentDAO;
import com.example.spring.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runnable -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student..");
        Student student = new Student("Megha", "Phapale", "megha@gmail,com");

        System.out.println("Saving student into DB..");
        studentDAO.save(student);

        int id = student.getId();
        System.out.println("Generated student ID " + student.getId());

        System.out.println("Retrieving student from DB..");
        Student retrieved = studentDAO.findById(id);

        System.out.println("Retrieved student: " + retrieved);

        System.out.println("Finding all students..");
        List<Student> students = studentDAO.findAll();

        for (Student s: students) {
            System.out.println(s);
        }

        System.out.println("Finding all students by lastName..");

        List<Student> students2 = studentDAO.findAllWithLastName("Phapale");
        for (Student s: students2) {
            System.out.println(s);
        }
    }
}
