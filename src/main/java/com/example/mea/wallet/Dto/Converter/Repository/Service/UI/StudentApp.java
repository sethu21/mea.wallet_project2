package com.example.mea.wallet.Dto.Converter.Repository.Service.UI;

import com.example.mea.wallet.Action.*;
import com.example.mea.wallet.Dto.Converter.Repository.Service.StudentService;
import com.example.mea.wallet.Dto.Converter.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@AllArgsConstructor
@Component
@ComponentScan("com.example.mea.wallet.Dto.Converter.Repository")

public class StudentApp {
    private final SessionFactory sessionFactory;
    private final StudentRepository studentRepository;

    public void run() {
        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService(sessionFactory,studentRepository);

        MainAction createStudentAction = new CreateStudentsAction(studentService);
        MainAction getStudentByIdAction = new GetStudentByIdAction(studentService);
        MainAction updateStudentAction = new UpdateStudentAction(studentService);
        MainAction getAllStudentsAction = new GetAllStudentsAction(studentService);
        MainAction deleteStudentAction = new DeleteStudentMainAction(studentService);
        MainAction findStudentsByNameAction = new FindStudentsByNameMainAction(studentService);

        while (true) {
            // Display menu
            System.out.println("Select an action:");
            System.out.println("1. Create a new student");
            System.out.println("2. Get student by ID");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Find students by name");
            System.out.println("6. GET ALL students");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1 -> createStudentAction.execute();
                case 2 -> getStudentByIdAction.execute();
                case 3 -> updateStudentAction.execute();
                case 4 -> deleteStudentAction.execute();
                case 5 -> findStudentsByNameAction.execute();
                case 6 -> getAllStudentsAction.execute();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
