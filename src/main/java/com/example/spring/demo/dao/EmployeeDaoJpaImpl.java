package com.example.spring.demo.dao;

import com.example.spring.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee update(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);;
        entityManager.remove(employee);
    }
}
