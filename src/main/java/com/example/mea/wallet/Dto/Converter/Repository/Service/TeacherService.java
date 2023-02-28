package com.example.mea.wallet.Dto.Converter.Repository.Service;

import com.example.mea.wallet.Dto.Converter.Repository.TeacherRepository;
import com.example.mea.wallet.Dto.Converter.TeacherDtoConverter;
import com.example.mea.wallet.Dto.TeacherDto;
import com.example.mea.wallet.Entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherDtoConverter teacherDtoConverter;
    private final SessionFactory sessionFactory;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherDtoConverter teacherDtoConverter,
                          SessionFactory sessionFactory) {
        this.teacherRepository = teacherRepository;
        this.teacherDtoConverter = teacherDtoConverter;
        this.sessionFactory = sessionFactory;
    }

    public TeacherDto addTeacher(TeacherDto teacherDTO) {
        // Convert the DTO to a Teacher object
        Teacher teacher = teacherDtoConverter.convertToTeacher(teacherDTO);

        // Save the Teacher object to the repository
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);

        // Convert the saved Teacher object to a DTO and return it
        Teacher savedTeacher = teacherRepository.findById(teacher.getId());
        return teacherDtoConverter.ConvertToDto(savedTeacher);
    }

    public TeacherDto getTeacherById(String id) {
        // Retrieve the Teacher object from the repository
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, id);

        if (teacher != null) {
            // Convert the retrieved Teacher object to a DTO and return it
            return teacherDtoConverter.ConvertToDto(teacher);
        } else {
            // Return null if the Teacher object was not found
            return null;
        }
    }

    public List<TeacherDto> getAllTeachers() {
        // Retrieve all Teacher objects from the repository
        Session session = sessionFactory.getCurrentSession();
        Query<Teacher> query = session.createQuery("FROM Teacher", Teacher.class);
        List<Teacher> teachers = query.list();
        List<TeacherDto> teacherDTOs = new ArrayList<>();

        // Convert each Teacher object to a DTO and add it to the list
        for (Teacher teacher : teachers) {
            teacherDTOs.add(teacherDtoConverter.ConvertToDto(teacher));
        }

        return teacherDTOs;
    }

    public TeacherDto updateTeacher(String id, TeacherDto teacherDTO) {
        // Convert the DTO to a Teacher object
        Teacher teacher = teacherDtoConverter.convertToTeacher(teacherDTO);
        teacher.setId(id);

        // Update the Teacher object in the repository
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
        return teacherDTO;
    }

    public void deleteTeacherById(String id) {
        // Delete the Teacher object from the repository
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, id);

        if (teacher != null) {
            session.delete(teacher);
        }
    }
}
