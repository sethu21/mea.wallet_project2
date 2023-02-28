package com.example.mea.wallet.Dto.Converter.Repository.Service;

import com.example.mea.wallet.Dto.Converter.Repository.StudentRepository;
import com.example.mea.wallet.Dto.Converter.StudentDtoConverter;
import com.example.mea.wallet.Dto.StudentsDto;
import com.example.mea.wallet.Entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private SessionFactory sessionFactory;
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(SessionFactory sessionFactory, StudentRepository studentRepository) {
        this.sessionFactory = sessionFactory;
        this.studentRepository = studentRepository;
    }

    public StudentsDto createStudent(StudentsDto studentsDto) {
        Students student = StudentDtoConverter.toEntity(studentsDto);
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return StudentDtoConverter.toDto(student);
    }

    public StudentsDto getStudentById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Students student = session.get(Students.class, id);
        if (student != null) {
            return StudentDtoConverter.toDto(student);
        }
        return null;
    }

    public List<StudentsDto> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Students";
        Query<Students> query = session.createQuery(hql, Students.class);
        List<Students> students = query.getResultList();
        return StudentDtoConverter.toDtoList(students);
    }

    public StudentsDto updateStudent(String id, StudentsDto studentDto) {
        Students existingStudent = studentRepository.findById(id);
        if (existingStudent != null) {
            Students updatedStudent = StudentDtoConverter.toEntity(studentDto);
            updatedStudent.setId(existingStudent.getId());
            Session session = sessionFactory.getCurrentSession();
            session.merge(updatedStudent);
            return StudentDtoConverter.toDto(updatedStudent);
        }
        return null;
    }

    public void deleteStudent(String id) {
        Session session = sessionFactory.getCurrentSession();
        Students student = session.get(Students.class, id);
        if (student != null) {
            session.delete(student);
        }
    }

    public List<StudentsDto> findStudentsByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Students> query = session.createQuery("FROM Students WHERE name LIKE :name", Students.class)
                .setParameter("name", "%" + name + "%");
        List<Students> students = query.list();
        return StudentDtoConverter.toDtoList(students);
    }
}
