package com.example.test12.controller;

import com.example.test12.entity.Course;
import com.example.test12.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @GetMapping("/all")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

}
