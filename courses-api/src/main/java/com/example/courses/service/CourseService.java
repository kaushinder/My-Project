package com.example.courses.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.courses.repository.CourseRepository;
import com.example.courses.model.Course;
import java.util.ArrayList;
import java.util.List;
@Service
public class CourseService {
    @Autowired
    private CourseRepository repo;
    public Course addCourse(Course course) {
        List<Course> valid = new ArrayList<>();
        for(Course c: course.getPrerequisites()) {
            valid.add(repo.findByCourseId(c.getCourseId()).orElseThrow(() -> new RuntimeException("Invalid prerequisite: " + c.getCourseId())));
        }
        course.setPrerequisites(valid);
        return repo.save(course);
    }
    public List<Course> getAllCourses() { return repo.findAll(); }
    public Course getByCourseId(String courseId) { return repo.findByCourseId(courseId).orElseThrow(() -> new RuntimeException("Not found")); }
    public void deleteByCourseId(String courseId) {
        Course course = getByCourseId(courseId);
        for(Course c: repo.findAll()) {
            for(Course pre : c.getPrerequisites()) {
                if(pre.getId().equals(course.getId())) throw new RuntimeException("Cannot delete. Prerequisite for " + c.getCourseId());
            }
        }
        repo.delete(course);
    }
}