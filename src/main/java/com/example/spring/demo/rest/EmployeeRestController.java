package com.example.spring.demo.rest;

import com.example.spring.demo.dao.EmployeeDao;
import com.example.spring.demo.entity.Employee;
import com.example.spring.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found for id - "+ employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0); // Reset the ID if sent in request - since we are auto-generating IDs
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,@RequestBody Map<String, Object> patchedValue) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found " + employeeId);
        }

        if (patchedValue.containsKey("id")) {
            throw new RuntimeException("Patching ID is not allowed " + employeeId);
        }
        Employee patchValue = jsonMapper.updateValue(employee, patchedValue);

        return employeeService.update(patchValue);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found " + employeeId);
        }
        employeeService.deleteById(employeeId);
    }
}
