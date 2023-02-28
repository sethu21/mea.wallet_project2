package com.example.mea.wallet.Dto.Converter.Repository;

import com.example.mea.wallet.Entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class StudentRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Students save(Students students) {
        Session session = sessionFactory.getCurrentSession();
        session.save(students);
        return students;
    }

    public Students findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Students.class, id);
    }

    public List<Students> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Students", Students.class).list();
    }

    public Students update(Students students) {
        Session session = sessionFactory.getCurrentSession();
        session.update(students);
        return students;
    }

    public void deleteById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Students students = session.get(Students.class, id);
        if (students != null) {
            session.delete(students);
        }
    }

    public List<Students> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Students WHERE name = :name", Students.class)
                .setParameter("name", name)
                .list();
    }
}