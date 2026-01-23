package com.example.test12.controller;

import com.example.test12.Dto.StudentDto;
import com.example.test12.Service.StudentService;
import com.example.test12.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }
}
