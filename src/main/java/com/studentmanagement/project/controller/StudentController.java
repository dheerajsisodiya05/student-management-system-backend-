package com.studentmanagement.project.controller;

import com.studentmanagement.project.entity.Student;
import com.studentmanagement.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

}
