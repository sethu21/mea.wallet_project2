package com.example.mea.wallet.Action;

import com.example.mea.wallet.Dto.Converter.Repository.Service.StudentService;
import com.example.mea.wallet.Dto.StudentsDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class CreateStudentsAction implements MainAction {
    private StudentService studentService;



    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name:");
        String name = scanner.nextLine();


        System.out.println("Enter student Lastname:");
        String Lastname = scanner.nextLine();


        List<String> subjects=new ArrayList<>();
        StudentsDto studentDto = new StudentsDto(null,name,Lastname,new ArrayList<>());
        studentDto = studentService.createStudent(studentDto);

        System.out.println("Student created with ID: " + studentDto.toString());
    }



}
