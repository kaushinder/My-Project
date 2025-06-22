package com.example.courses.model;
import jakarta.persistence.*;

@Entity
public class CourseInstance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private int semester;
    @ManyToOne
    private Course course;
    // getters & setters
}