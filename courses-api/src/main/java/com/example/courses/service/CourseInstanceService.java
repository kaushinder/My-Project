package com.example.courses.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.courses.repository.CourseInstanceRepository;
import com.example.courses.repository.CourseRepository;
import com.example.courses.model.CourseInstance;
import java.util.List;
@Service
public class CourseInstanceService {
    @Autowired
    private CourseInstanceRepository repo;
    @Autowired
    private CourseRepository courseRepo;
    public CourseInstance create(String courseId, int year, int semester) {
        var course = courseRepo.findByCourseId(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        var instance = new CourseInstance();
        instance.setYear(year); instance.setSemester(semester); instance.setCourse(course);
        return repo.save(instance);
    }
    public List<CourseInstance> list(int year, int semester) { return repo.findByYearAndSemester(year, semester); }
    public CourseInstance detail(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Instance not found")); }
    public void delete(Long id) { repo.deleteById(id); }
}