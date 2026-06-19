package com.example.book;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

    private static final SessionFactory factory;

    static {

        factory =
        new Configuration()
        .configure()
        .buildSessionFactory();

    }

    public static SessionFactory getFactory() {

        return factory;

    }

}