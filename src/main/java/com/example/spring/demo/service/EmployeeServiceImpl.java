package com.example.spring.demo.service;

import com.example.spring.demo.dao.EmployeeDao;
import com.example.spring.demo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Transactional
    @Override
    public void deleteById(int employeeId) {
        employeeDao.deleteById(employeeId);
    }
}
