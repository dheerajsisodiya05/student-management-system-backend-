package com.studentmanagement.project;

import com.studentmanagement.project.entity.Student;
import com.studentmanagement.project.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {

		StudentService service = new StudentService();

		service.addStudent(new Student(1, "Dheeraj", "dheeraj@gmail.com", 22));
		service.addStudent(new Student(2, "Amit", "amit@gmail.com", 21));

		for (Student s : service.getAllStudents()) {
			System.out.println(s.getId() + " " + s.getName());
		}
	}

}
