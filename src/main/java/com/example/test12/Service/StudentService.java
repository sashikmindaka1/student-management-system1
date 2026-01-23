package com.example.test12.Service;

import com.example.test12.Dto.StudentDto;
import com.example.test12.entity.Course;
import com.example.test12.entity.Department;
import com.example.test12.entity.Student;
import com.example.test12.repository.CourseRepository;
import com.example.test12.repository.DepartmentRepository;
import com.example.test12.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student saveStudent(StudentDto dto){
        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());


        if (dto.getDeptId() != null) {
            Department dept = departmentRepository.findById(dto.getDeptId())
                    .orElse(null);

            student.setDepartment(dept);
        }

        if (dto.getCourseIds() != null && !dto.getCourseIds().isEmpty()) {


            List<Course> courses = courseRepository.findAllById(dto.getCourseIds());

            student.setCourses(courses); 
        }


        return studentRepository.save(student);



    }
}
