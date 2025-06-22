package com.example.courses.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.courses.model.Course;
import com.example.courses.service.CourseService;
import java.util.List;
@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService service;
    @PostMapping public Course create(@RequestBody Course course) { return service.addCourse(course); }
    @GetMapping public List<Course> list() { return service.getAllCourses(); }
    @GetMapping("/{courseId}") public Course get(@PathVariable String courseId) { return service.getByCourseId(courseId); }
    @DeleteMapping("/{courseId}") public void delete(@PathVariable String courseId) { service.deleteByCourseId(courseId); }
}