package com.example.mea.wallet;

import com.example.mea.wallet.Action.MainAction;
import com.example.mea.wallet.Action.TeacherAction.AddTeacherAction;
import com.example.mea.wallet.Action.TeacherAction.GetAllTeacher;
import com.example.mea.wallet.Action.TeacherAction.GetTeacherByIdAction;
import com.example.mea.wallet.Action.TeacherAction.UpdateTeacher;
import com.example.mea.wallet.Dto.Converter.Repository.Service.TeacherService;

import java.util.Scanner;

public class TeacherApp {
    private static final String ROLE_TEACHER = "teacher";
    private static final String EXIT_OPTION = "0";

    private final TeacherService teacherService;
    private final MainAction createTeacherAction;
    private final MainAction getTeacherByIdAction;
    private final MainAction updateTeacherAction;
    private final MainAction getAllTeachersAction;

    public TeacherApp(TeacherService teacherService) {
        this.teacherService = teacherService;
        this.createTeacherAction = new AddTeacherAction(this.teacherService);
        this.getTeacherByIdAction = new GetTeacherByIdAction(this.teacherService);
        this.updateTeacherAction = new UpdateTeacher(this.teacherService);
        this.getAllTeachersAction = new GetAllTeacher(this.teacherService);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        // Ask user to enter their role and ID
        System.out.println("Enter your role (student or teacher):");
        String role = scanner.nextLine();

        if (!ROLE_TEACHER.equalsIgnoreCase(role)) {
            System.out.println("Invalid role. This application is for teachers only.");
            return;
        }

        System.out.println("Welcome, teacher!");

        while (true) {
            // Display menu
            System.out.println("Select an action:");
            System.out.println("1. Create a new teacher");
            System.out.println("2. Get teacher by ID");
            System.out.println("3. Update a teacher");
            System.out.println("4. Get all teachers");
            System.out.println("0. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createTeacherAction.execute();
                    break;
                case "2":
                    getTeacherByIdAction.execute();
                    break;
                case "3":
                    updateTeacherAction.execute();
                    break;
                case "4":
                    getAllTeachersAction.execute();
                    break;
                case EXIT_OPTION:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
