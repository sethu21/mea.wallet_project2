package com.example.mea.wallet.Dto.Converter.Repository.Service.UI;

import com.example.mea.wallet.Action.MainAction;
import com.example.mea.wallet.Action.TeacherAction.AddTeacherAction;
import com.example.mea.wallet.Action.TeacherAction.GetAllTeacher;
import com.example.mea.wallet.Action.TeacherAction.GetTeacherByIdAction;
import com.example.mea.wallet.Action.TeacherAction.UpdateTeacher;
import com.example.mea.wallet.Dto.Converter.Repository.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@AllArgsConstructor
@Component
public class TeacherApp {
    private final SessionFactory sessionFactory;
    private final TeacherService teacherService;

    public void run() {
        Scanner scanner = new Scanner(System.in);

        MainAction createTeacherAction = new AddTeacherAction(teacherService);
        MainAction getTeacherByIdAction = new GetTeacherByIdAction(teacherService);
        MainAction updateTeacherAction = new UpdateTeacher(teacherService);
        MainAction getAllTeachersAction = new GetAllTeacher(teacherService);

        while (true) {
            // Display menu
            System.out.println("Select an action:");
            System.out.println("1. Create a new teacher");
            System.out.println("2. Get teacher by ID");
            System.out.println("3. Update a teacher");
            System.out.println("4. Get all teachers");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1 -> createTeacherAction.execute();
                case 2 -> getTeacherByIdAction.execute();
                case 3 -> updateTeacherAction.execute();
                case 4 -> getAllTeachersAction.execute();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}