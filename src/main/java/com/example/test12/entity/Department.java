package com.example.test12.entity;

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

    private String department_name;
    // private int department_id; // මේක ID එකට පටලැවෙනවා නම් අයින් කරන්න, නැත්නම් තියන්න.

    @OneToMany(mappedBy = "department")
    private List<Student> students; // නම වෙනස් කළා 'students' කියලා
}