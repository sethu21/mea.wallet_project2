package com.example.mea.wallet.Dto.Converter.Repository.Service.UI;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Scanner;



@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.example.mea.wallet.Dto.Converter")
public class SchoolApp implements CommandLineRunner {

    private final StudentApp studentApp;
    private final TeacherApp teacherApp;


    public SchoolApp(StudentApp studentApp, TeacherApp teacherApp) {
        this.studentApp = studentApp;
        this.teacherApp = teacherApp;
    }


    public static void main(String[] args) {
        SpringApplication.run(SchoolApp.class, args);


    }


    @Override
    public void run(String... args) throws Exception {
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
