package com.example.courses.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.courses.model.CourseInstance;
import java.util.List;
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
}