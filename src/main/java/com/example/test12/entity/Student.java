package com.example.test12.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    private int age;
    private String email;

    // private String course; // මේක අයින් කරන්න. අපිට පහළ තියෙන List එක ඕනේ.

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    // --- මචං මේ කෑල්ල අනිවාර්යයෙන් ඕනේ ---
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses; // නම බහුවචන (courses) වෙන්න ඕනේ
}