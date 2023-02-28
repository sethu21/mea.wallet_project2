package com.example.mea.wallet.Action;

import com.example.mea.wallet.Dto.Converter.Repository.Service.StudentService;
import com.example.mea.wallet.Dto.StudentsDto;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllStudentsAction implements MainAction {
    private StudentService studentService;


    @Override
    public void execute() {
        List<StudentsDto> studentDtos = studentService.getAllStudents();
        for (StudentsDto studentDto : studentDtos) {
            System.out.println(studentDto.toString());
        }

    }
}
