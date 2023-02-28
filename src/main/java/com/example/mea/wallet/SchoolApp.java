package com.example.mea.wallet;

import com.example.mea.wallet.Dto.Converter.Repository.Service.TeacherService;
import com.example.mea.wallet.Dto.Converter.Repository.StudentRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public  class SchoolApp {

    private final StudentApp studentApp;
    private final TeacherApp teacherApp;

    public SchoolApp(StudentApp studentApp, TeacherApp teacherApp) {
        this.studentApp = studentApp;
        this.teacherApp = teacherApp;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateUtil.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        StudentApp studentApp = new StudentApp(sessionFactory,studentRepository);
        TeacherService teacherService = context.getBean(TeacherService.class);
        TeacherApp teacherApp = new TeacherApp(teacherService);

        SchoolApp schoolApp = new SchoolApp(studentApp, teacherApp);
        schoolApp.run();

        context.close();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("Select an action:");
            System.out.println("1. Student app");
            System.out.println("2. Teacher app");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1 -> studentApp.run();
                case 2 -> teacherApp.run();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}


