package com.example.spring.demo.rest;

import com.example.spring.demo.entity.Student;
import com.example.spring.demo.entity.StudentNotFoundErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFountException("Student not found - " + studentId);
        }
        return students.get(studentId);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
}
