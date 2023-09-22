package com.munira.departmentservice.controller;

import com.munira.departmentservice.client.CourseClient;
import com.munira.departmentservice.client.EmployeeClient;
import com.munira.departmentservice.model.Department;
import com.munira.departmentservice.repository.DepartmentRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private CourseClient courseClient;

    @PostMapping("/add")
    public Department add(@RequestBody Department department) {
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        List<Department> departments =
                departmentRepository.findAll();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(
                                department.getId())));
        return departments;
    }

    @GetMapping("/with-courses")
    public List<Department> findAllWithCourses() {
        List<Department> departments =
                departmentRepository.findAll();
        departments.forEach(department ->
                department.setCourses(
                        courseClient.findByDepartment(
                                department.getId())));
        return departments;
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        return departmentRepository.findById(id);
    }
}
