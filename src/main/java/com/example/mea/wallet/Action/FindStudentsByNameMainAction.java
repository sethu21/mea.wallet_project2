package com.example.mea.wallet.Action;

import com.example.mea.wallet.Dto.Converter.Repository.Service.StudentService;
import com.example.mea.wallet.Dto.StudentsDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class FindStudentsByNameMainAction implements MainAction {
    private final StudentService studentService;



    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<StudentsDto> students = studentService.findStudentsByName(name);

        if (students.isEmpty()) {
            System.out.println("No students found with the name " + name);
        } else {
            System.out.println("Students with the name " + name + ":");
            for (StudentsDto student : students) {
                System.out.println(student.getName() + " " + student.getLastname() + " (" + student.getId() + ")"+" "+student.getSubjects());
            }
        }
    }
}
