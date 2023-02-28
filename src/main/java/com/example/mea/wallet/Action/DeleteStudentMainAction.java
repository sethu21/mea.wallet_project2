package com.example.mea.wallet.Action;

import com.example.mea.wallet.Dto.Converter.Repository.Service.StudentService;
import lombok.AllArgsConstructor;

import java.util.Scanner;
@AllArgsConstructor
public class DeleteStudentMainAction implements MainAction{
    private final StudentService studentService;



    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student id to delete: ");
        String id = scanner.nextLine();

        studentService.deleteStudent(id);

        System.out.println("Student with id " + id + " has been deleted.");
    }

}
