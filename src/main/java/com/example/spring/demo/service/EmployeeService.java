package com.example.spring.demo.service;

import com.example.spring.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee update(Employee employee);

    void deleteById(int employeeId);
}
