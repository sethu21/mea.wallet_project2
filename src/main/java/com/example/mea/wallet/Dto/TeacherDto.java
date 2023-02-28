package com.example.mea.wallet.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class TeacherDto {
    private String id;
    private String Name;
    private String Lastname;
    private List<String> Subjects;
}
