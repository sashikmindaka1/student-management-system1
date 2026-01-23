package com.example.test12.controller;


import com.example.test12.entity.Department;
import com.example.test12.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department){
        return departmentRepository.save(department);

    }

    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
