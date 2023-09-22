package com.munira.employeeservice.controller;

import com.munira.employeeservice.model.Employee;
import com.munira.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {

        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        return employeeRepository.findByDepartment(departmentId);
    }

}
