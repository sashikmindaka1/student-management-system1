package com.example.test12.entity;

import com.fasterxml.jackson.annotation.JsonIgnore; // 1. මේ Import එක අනිවාර්යයි
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String credit;

    // මෙතන mappedBy = "courses" හරි (Student එකේ නම 'courses' නිසා)
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore // 2. මේකෙන් තමයි Loop එක කඩන්නේ. නැත්නම් StackOverflow Error එනවා.
    private List<Student> students;
}