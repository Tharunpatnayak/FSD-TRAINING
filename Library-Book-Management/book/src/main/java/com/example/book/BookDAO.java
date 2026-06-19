package com.example.book;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO {

    public void saveBook(Book book) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.persist(book);

        tx.commit();

        session.close();

    }

    public List<Book> getAllBooks() {

        Session session =
        Utility.getFactory().openSession();

        List<Book> books =
        session.createQuery(
                "FROM Book",
                Book.class
        ).list();

        session.close();

        return books;

    }

    public Book getBook(int id) {

        Session session =
        Utility.getFactory().openSession();

        Book book =
        session.get(
                Book.class,
                id
        );

        session.close();

        return book;

    }

    public void updateBook(Book book) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.merge(book);

        tx.commit();

        session.close();

    }

    public void deleteBook(int id) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        Book book =
        session.get(
                Book.class,
                id
        );

        if(book != null) {

            session.remove(book);

        }

        tx.commit();

        session.close();

    }

}