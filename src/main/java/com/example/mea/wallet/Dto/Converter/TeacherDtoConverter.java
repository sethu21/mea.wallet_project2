package com.example.mea.wallet.Dto.Converter;

import com.example.mea.wallet.Dto.TeacherDto;
import com.example.mea.wallet.Entity.Teacher;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TeacherDtoConverter {
    private static  int nextId = 1;

    public  TeacherDto ConvertToDto(Teacher teacher){
        // Generate a unique ID using the first three letters of the teacher's name and a two-digit number
        String id = String.format("%s%02d", teacher.getName().substring(0, 3).toUpperCase(), nextId++);
        TeacherDto teacherDto = new TeacherDto(id, teacher.getName(), teacher.getLastName(), teacher.getSubjects());
        return teacherDto;
    }

    public Teacher  convertToTeacher(TeacherDto teacherDto){
        Teacher teacher = new Teacher(teacherDto.getId(),teacherDto.getName(),teacherDto.getLastname(),teacherDto.getSubjects());
        return teacher;
    }

}
