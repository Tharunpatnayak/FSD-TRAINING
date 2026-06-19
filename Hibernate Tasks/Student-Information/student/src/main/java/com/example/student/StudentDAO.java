package com.example.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {

    public void saveStudent(Student student) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.persist(student);

        tx.commit();

        session.close();

    }

    public List<Student> getAllStudents() {

        Session session =
        Utility.getFactory().openSession();

        List<Student> students =
        session.createQuery(
                "FROM Student",
                Student.class
        ).list();

        session.close();

        return students;

    }

    public Student getStudent(int id) {

        Session session =
        Utility.getFactory().openSession();

        @SuppressWarnings("removal")
        Student student =
        session.get(
                Student.class,
                id
        );

        session.close();

        return student;

    }

    public void updateStudent(Student student) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.merge(student);

        tx.commit();

        session.close();

    }

    public void deleteStudent(int id) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        @SuppressWarnings("removal")
        Student student =
        session.get(
                Student.class,
                id
        );

        if(student != null) {

            session.remove(student);

        }

        tx.commit();

        session.close();

    }

}