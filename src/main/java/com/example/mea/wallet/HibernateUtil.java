package com.example.mea.wallet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    @Bean
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public static void shutdown() {
        // Close caches and connection pools
        sessionFactory.close();
    }

}
