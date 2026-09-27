package com.example.spring.demo.dao;

import com.example.spring.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllWithLastName(String lastName);
}
