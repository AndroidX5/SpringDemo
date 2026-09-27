package com.example.spring.demo.rest;

import com.example.spring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        students.add(new Student("Sachin", "Phapale"));
        students.add(new Student("Megha", "Phapale"));
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return students.get(studentId);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
}
