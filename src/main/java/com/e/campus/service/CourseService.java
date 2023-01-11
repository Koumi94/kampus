package com.e.campus.service;

import com.e.campus.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourse();

    Optional<Course> getCourseById(Long id);

    Course addCourse(Course course);

    Course updateCourse(Long id, Course course);
}
