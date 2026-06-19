package com.example.order;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO {

    public void saveOrder(Order order) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.persist(order);

        tx.commit();

        session.close();

    }

    public List<Order> getAllOrders() {

        Session session =
        Utility.getFactory().openSession();

        List<Order> orders =
        session.createQuery(
                "FROM Order",
                Order.class
        ).list();

        session.close();

        return orders;

    }

    public Order getOrder(int id) {

        Session session =
        Utility.getFactory().openSession();

        Order order =
        session.get(
                Order.class,
                id
        );

        session.close();

        return order;

    }

    public void updateOrder(Order order) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.merge(order);

        tx.commit();

        session.close();

    }

    public void deleteOrder(int id) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        Order order =
        session.get(
                Order.class,
                id
        );

        if(order != null) {

            session.remove(order);

        }

        tx.commit();

        session.close();

    }

}