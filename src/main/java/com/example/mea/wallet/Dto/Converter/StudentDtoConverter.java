package com.example.mea.wallet.Dto.Converter;

import com.example.mea.wallet.Dto.StudentsDto;
import com.example.mea.wallet.Entity.Students;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@NoArgsConstructor
public class StudentDtoConverter {
    private static int nextId = 1;

    public static StudentsDto toDto(Students students) {
        return new StudentsDto(students.getId(), students.getName(), students.getLastname(), students.getSubjects());

    }

    public static Students toEntity(StudentsDto studentsDto) {
        if (studentsDto.getId() == null) {
            String Id = String.format("%s%02d",studentsDto.getName().substring(0,3),nextId++);
            studentsDto.setId(Id);

        }
        return new Students(studentsDto.getId(), studentsDto.getName(), studentsDto.getLastname(), studentsDto.getSubjects());

    }
    public static List<StudentsDto> toDtoList(List<Students> students) {
        List<StudentsDto> studentDtos = new ArrayList<>();
        for (Students student : students) {
            studentDtos.add(toDto(student));
        }
        return studentDtos;
    }
}
