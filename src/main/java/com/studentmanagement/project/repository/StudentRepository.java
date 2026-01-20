package com.studentmanagement.project.repository;
import com.studentmanagement.project.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository {

    void save(Student student);

    List<Student> findAll();

    Student findById(int id);

    boolean deleteById(int id);
}
