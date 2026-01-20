package com.studentmanagement.project;

import com.studentmanagement.project.entity.Student;
import com.studentmanagement.project.exception.StudentNotFoundException;
import com.studentmanagement.project.repository.StudentRepository;
import com.studentmanagement.project.repository.StudentRepositoryImpl;
import com.studentmanagement.project.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args)  throws RuntimeException{

		StudentRepository repository = new StudentRepositoryImpl();
		StudentService service = new StudentService(repository);

		Scanner sc = new Scanner(System.in);

		while(true){
			System.out.println("\n1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student by ID");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			int choice = sc.nextInt();
			switch (choice){
				case 1:
					System.out.print("Enter ID: ");
					int id = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Email: ");
					String email = sc.nextLine();

					System.out.print("Enter Age: ");
					int age = sc.nextInt();

					service.addStudent(new Student(id, name, email, age));
					System.out.println("Student added");
					break;

				case 2:
					for (Student s : service.getAllStudents()) {
						System.out.println(s.getId() + " " + s.getName());
					}
					break;

				case 3:
					System.out.print("Enter ID: ");
					int searchId = sc.nextInt();
					try {
						Student s = service.getStudentById(searchId);
						System.out.println(s.getName() + " " + s.getEmail());
					} catch (StudentNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 4:
					System.out.print("Enter ID: ");
					int deleteId = sc.nextInt();
					boolean deleted = service.removeStudent(deleteId);
					System.out.println(deleted ? "Deleted" : "Not Found");
					break;

				case 5:
					System.exit(0);
			}
		}

	}
}
