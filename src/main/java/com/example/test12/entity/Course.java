package com.example.test12.entity;

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

    // මෙතන mappedBy = "courses" වෙන්න ඕනේ (Student එකේ අපි දැම්මේ 'courses' නේ)
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}