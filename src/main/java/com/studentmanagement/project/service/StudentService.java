package com.studentmanagement.project.service;
import com.studentmanagement.project.entity.Student;
import com.studentmanagement.project.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository repository = new StudentRepository();

    public void addStudent(Student student) {
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id);
    }

    public boolean removeStudent(int id) {
        return repository.deleteById(id);
    }
}
