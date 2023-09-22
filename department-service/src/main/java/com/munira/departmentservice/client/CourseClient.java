package com.munira.departmentservice.client;

import com.munira.departmentservice.model.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface CourseClient {
    @GetExchange("/course/department/{departmentId}")
    public List<Course> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
