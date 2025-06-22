package com.example.courses.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.courses.model.Course;
import java.util.Optional;
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseId(String courseId);
    boolean existsByCourseId(String courseId);
}