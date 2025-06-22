package com.example.courses.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String courseId;
    private String description;
    @ManyToMany
    private List<Course> prerequisites;
    // getters & setters
}