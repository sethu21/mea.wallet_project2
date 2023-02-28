package com.example.mea.wallet.Action;

import com.example.mea.wallet.Dto.Converter.Repository.Service.StudentService;
import com.example.mea.wallet.Dto.StudentsDto;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class GetStudentByIdAction implements MainAction {
    private StudentService studentService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the student to retrieve: ");
        String id = scanner.nextLine();

        StudentsDto student = studentService.getStudentById(id);

        if (student == null) {
            System.out.println("No student found with ID " + id);
        } else {
            System.out.println("Student details:");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Lastname: " + student.getLastname());
            System.out.println("Subjects: " + student.getSubjects());
        }
    }
}
