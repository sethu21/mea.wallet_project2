package com.example.mea.wallet.Action;

import com.example.mea.wallet.Dto.Converter.Repository.Service.StudentService;
import com.example.mea.wallet.Dto.StudentsDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class UpdateStudentAction implements MainAction {
    private final StudentService studentService;




    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the student to update: ");
        String id = scanner.nextLine();

        System.out.print("Enter the new name of the student: ");
        String name = scanner.nextLine();

        System.out.print("Enter the new last name of the student: ");
        String lastName = scanner.nextLine();

        List<String> subjects = null;
        StudentsDto studentDto = new StudentsDto(name, lastName,id,subjects);
        StudentsDto updatedStudentDto = studentService.updateStudent(id, studentDto);

        if (updatedStudentDto != null) {
            System.out.println("Student updated: " + updatedStudentDto.getName() + " " + updatedStudentDto.getLastname());
        } else {
            System.out.println("Could not update student with ID " + id);
        }
    }
}
