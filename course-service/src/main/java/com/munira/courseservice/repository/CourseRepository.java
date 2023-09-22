package com.munira.courseservice.repository;

import com.munira.courseservice.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courseList = new ArrayList<>();

    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    public Course findById(Long id) {
        return courseList.stream()
                .filter(course ->
                        course.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Course> findAll() {
        return courseList;
    }

    public List<Course> findByDepartment(Long departmentId) {
        return courseList.stream()
                .filter(course ->
                        course.departmentId().equals(departmentId))
                .toList();
    }
}
