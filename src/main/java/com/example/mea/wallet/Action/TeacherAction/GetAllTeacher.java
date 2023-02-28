package com.example.mea.wallet.Action.TeacherAction;

import com.example.mea.wallet.Action.MainAction;
import com.example.mea.wallet.Dto.Converter.Repository.Service.TeacherService;
import com.example.mea.wallet.Dto.TeacherDto;

import java.util.List;

public class GetAllTeacher implements MainAction {
    private final TeacherService teacherService;

    public GetAllTeacher(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void execute() {
        List<TeacherDto> teacherDTOS = teacherService.getAllTeachers();
        for (TeacherDto teacherDTO : teacherDTOS) {
            System.out.println(teacherDTO.toString());
        }
    }
}
