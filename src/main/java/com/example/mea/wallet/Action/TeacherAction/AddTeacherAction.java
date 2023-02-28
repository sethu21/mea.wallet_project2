package com.example.mea.wallet.Action.TeacherAction;

import com.example.mea.wallet.Action.MainAction;
import com.example.mea.wallet.Dto.Converter.Repository.Service.TeacherService;
import com.example.mea.wallet.Dto.TeacherDto;

import java.util.Scanner;

public class AddTeacherAction implements MainAction {

    private TeacherService teacherService;

    public AddTeacherAction( TeacherService teacherService) {

        this.teacherService = teacherService;
    }

    @Override
    public void execute() {
        System.out.println("Add a new teacher:");
        System.out.print("Enter teacher name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter teacher Lastname: ");
        String lastname = scanner.nextLine();
        System.out.println("Enter a subject");

        // Get other teacher information from user input...

        // Create a new TeacherDTO object with the input information
        TeacherDto teacherDTO = new TeacherDto(null, name,lastname,null);

        // Add the teacher to the repository using the service
        teacherDTO = teacherService.addTeacher(teacherDTO);

        System.out.println("Teacher added with ID: " + teacherDTO.toString());
    }
}