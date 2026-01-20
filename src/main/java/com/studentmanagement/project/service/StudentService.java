package com.studentmanagement.project.service;
import com.studentmanagement.project.entity.Student;
import com.studentmanagement.project.exception.StudentNotFoundException;
import com.studentmanagement.project.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public class StudentService{

//    private StudentRepository repository = new StudentRepository();
//
//    public void addStudent(Student student) {
//        repository.save(student);
//    }
//
//    public List<Student> getAllStudents() {
//        return repository.findAll();
//    }
//
//    public Student getStudentById(int id) {
//        return repository.findById(id);
//    }
//
//    public boolean removeStudent(int id) {
//        return repository.deleteById(id);
//    }

    private StudentRepository repository;

    private Student student;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public void addStudent(Student student) {
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        student = repository.findById(id);
        if(student == null){
            throw new StudentNotFoundException("Student not found with id:" + id);
        }
        return student;
    }

    public boolean removeStudent(int id){
        if (student == null) {
            throw new StudentNotFoundException("Student not exit with id: " + id);
        }
        return repository.deleteById(id);
    }
}
