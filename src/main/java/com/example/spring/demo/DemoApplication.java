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
        Student student1 = new Student("Sachin", "Phapale", "sachin@gmail.com");
        studentDAO.save(student1);
        Student student2 = new Student("Sachin", "Phapale", "sachin@gmail.com");
        studentDAO.save(student2);
//        studentDAO.findById(1);
//        studentDAO.findAll();
//        studentDAO.findAllWithLastName("Phapale");

        studentDAO.delete(student1.getId());
        studentDAO.deleteAll();
    }
}
