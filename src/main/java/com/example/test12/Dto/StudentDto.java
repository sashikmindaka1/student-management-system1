package com.example.test12.Dto;

import com.example.test12.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private String name;
    private String email;
    private int age;
    private Long deptId;
    private List<Long> courseIds;


}
