package com.example.mea.wallet.Action.TeacherAction;

import com.example.mea.wallet.Action.MainAction;
import com.example.mea.wallet.Dto.Converter.Repository.Service.TeacherService;
import com.example.mea.wallet.Dto.TeacherDto;

import java.util.Scanner;

public class UpdateTeacher implements MainAction {
    private TeacherService teacherService;

    public UpdateTeacher(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the Teacher to update: ");
        String id = scanner.nextLine();

        System.out.print("Enter the new name of the Teacher: ");
        String name = scanner.nextLine();

        System.out.print("Enter the new last name of the Teacher: ");
        String lastName = scanner.nextLine();

        TeacherDto teacherDTO = new TeacherDto(id,name,lastName,null);
        TeacherDto updateTeacherdto  =  teacherService.updateTeacher(id,teacherDTO);
        if (updateTeacherdto != null) {
            System.out.println("Student updated: " + updateTeacherdto.getName() + " " + updateTeacherdto.getLastname());
        } else {
            System.out.println("Could not update student with ID " + id);
        }
    }

}
