package com.example.mea.wallet.Action.TeacherAction;

import com.example.mea.wallet.Action.MainAction;
import com.example.mea.wallet.Dto.Converter.Repository.Service.TeacherService;
import com.example.mea.wallet.Dto.TeacherDto;

import java.util.Scanner;

public class GetTeacherByIdAction implements MainAction {

    private final TeacherService teacherService;

    public GetTeacherByIdAction( TeacherService teacherService) {

        this.teacherService = teacherService;
    }

    @Override
    public void execute() {

        System.out.print("Enter teacher ID: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        // Get the teacher with the given ID using the service
        TeacherDto teacherDTO = teacherService.getTeacherById(id);

        if (teacherDTO != null) {
            System.out.println("Teacher Details:");
            System.out.println("ID: " + teacherDTO.getId());
            System.out.println("Name: " + teacherDTO.getName());
            System.out.println("Email: " + teacherDTO.getLastname());
            System.out.println("Address: " + teacherDTO.getSubjects());
        } else {
            System.out.println("Teacher not found with ID: " + id);
        }
    }
}
