package com.example.mea.wallet;

import com.example.mea.wallet.Dto.Converter.Repository.StudentRepository;



import com.example.mea.wallet.Dto.Converter.TeacherDtoConverter;
import lombok.SneakyThrows;
import org.h2.Driver;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.example.mea.wallet.Dto.Converter.Repository.StudentRepository",
        "com.example.mea.wallet.Dto.Converter","com.example.mea.wallet.Dto.Converter.Repository.Service"})


public class DatabaseConfig {

    @Bean
    public StudentRepository studentRepository(SessionFactory sessionFactory) {
        return new StudentRepository(sessionFactory);
    }
    @Bean
    public TeacherDtoConverter teacherDtoConverter() {
        return new TeacherDtoConverter();
    }

    @Bean

    public DataSource dataSource() {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public SessionFactory getSessionFactory() throws IOException {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
        hibernateProperties.put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");


        bean.setHibernateProperties(hibernateProperties);
        bean.setDataSource(dataSource());
        bean.setPackagesToScan("com.example.mea.wallet");
        bean.afterPropertiesSet();
        return bean.getObject();
    }


    @SneakyThrows
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory());
        return transactionManager;
    }


}

