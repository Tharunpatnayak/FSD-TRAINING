package com.example.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    public void saveEmployee(Employee employee) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.persist(employee);

        tx.commit();

        session.close();

    }

    public List<Employee> getAllEmployees() {

        Session session =
        Utility.getFactory().openSession();

        List<Employee> employees =
        session.createQuery(
                "FROM Employee",
                Employee.class
        ).list();

        session.close();

        return employees;

    }

    public Employee getEmployee(int id) {

        Session session =
        Utility.getFactory().openSession();

        Employee employee =
        session.get(
                Employee.class,
                id
        );

        session.close();

        return employee;

    }

    public void updateEmployee(Employee employee) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        session.merge(employee);

        tx.commit();

        session.close();

    }

    public void deleteEmployee(int id) {

        Session session =
        Utility.getFactory().openSession();

        Transaction tx =
        session.beginTransaction();

        Employee employee =
        session.get(
                Employee.class,
                id
        );

        if(employee != null) {

            session.remove(employee);

        }

        tx.commit();

        session.close();

    }

}