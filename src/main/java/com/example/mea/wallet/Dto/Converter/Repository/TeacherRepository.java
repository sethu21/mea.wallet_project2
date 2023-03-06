package com.example.mea.wallet.Dto.Converter.Repository;

import com.example.mea.wallet.Entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TeacherRepository {

    private final SessionFactory sessionFactory;
@Autowired
    public TeacherRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Teacher save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
        return teacher;
    }

    public Teacher findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Teacher", Teacher.class).list();
    }

    public Teacher update(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
        return teacher;
    }

    public void delete(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(teacher);
    }
}
