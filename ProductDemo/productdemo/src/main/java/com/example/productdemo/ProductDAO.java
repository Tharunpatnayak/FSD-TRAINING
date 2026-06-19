package com.example.productdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

    private static final SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    public void saveProduct(Product product) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(product);
        tx.commit();
        session.close();
    }

    public List<Product> getAllProducts() {
        Session session = factory.openSession();
        List<Product> products =
                session.createQuery("FROM Product", Product.class).list();
        session.close();
        return products;
    }

    public Product getProduct(int id) {
        Session session = factory.openSession();
        @SuppressWarnings("removal")
		Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public void updateProduct(Product product) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(product);
        tx.commit();
        session.close();
    }

    public void deleteProduct(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        @SuppressWarnings("removal")
		Product product = session.get(Product.class, id);
        if (product != null) {
            session.remove(product);
        }
        tx.commit();
        session.close();
    }
}