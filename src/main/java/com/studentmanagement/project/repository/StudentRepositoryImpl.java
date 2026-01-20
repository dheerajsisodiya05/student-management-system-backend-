package com.studentmanagement.project.repository;

import com.studentmanagement.project.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

    private List<Student> studentList = new ArrayList<>();

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        Student student = findById(id);
        if (student != null) {
            studentList.remove(student);
            return true;
        }
        return false;
    }
}
