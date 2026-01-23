package com.example.test12.entity;

import com.fasterxml.jackson.annotation.JsonIgnore; // 1. මේ Import එක අනිවාර්යයි
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 2. නම හරියට හැදුවා (Java Standard එකට)
    private String departmentName;

    @OneToMany(mappedBy = "department")
    @JsonIgnore // 3. මේක අනිවාර්යයෙන් දාන්න! (නැත්නම් System එක Loop වෙලා හිර වෙනවා)
    private List<Student> students;
}