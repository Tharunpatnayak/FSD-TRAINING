package com.example.student;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

    private static final SessionFactory factory;

    static {

        factory =
        new Configuration()
        .configure()
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();

    }

    public static SessionFactory getFactory() {

        return factory;

    }

}