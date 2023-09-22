package com.munira.courseservice.controller;

import com.munira.courseservice.model.Course;
import com.munira.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/add")
    public Course add(@RequestBody Course course) {
        return courseRepository.addCourse(course);
    }

    @GetMapping("/all")
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Course> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        return courseRepository.findByDepartment(departmentId);
    }
}
