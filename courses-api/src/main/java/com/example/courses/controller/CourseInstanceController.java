package com.example.courses.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.courses.model.CourseInstance;
import com.example.courses.service.CourseInstanceService;
import java.util.List;
@RestController
@RequestMapping("/api/instances")
@CrossOrigin
public class CourseInstanceController {
    @Autowired
    private CourseInstanceService service;
    @PostMapping public CourseInstance create(@RequestParam String courseId,@RequestParam int year,@RequestParam int semester) { return service.create(courseId,year,semester); }
    @GetMapping("/{year}/{semester}") public List<CourseInstance> list(@PathVariable int year,@PathVariable int semester) { return service.list(year,semester); }
    @GetMapping("/{year}/{semester}/{id}") public CourseInstance detail(@PathVariable int year,@PathVariable int semester,@PathVariable Long id) { return service.detail(id); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}