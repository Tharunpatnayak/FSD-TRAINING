package com.example.employee;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String employeeName;

    private String department;

    private double salary;

    private LocalDate joiningDate;

    public Employee() {

    }

    public Employee(String employeeName,
                    String department,
                    double salary,
                    LocalDate joiningDate) {

        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;

    }

    public int getEmployeeId() {

        return employeeId;

    }

    public void setEmployeeId(int employeeId) {

        this.employeeId = employeeId;

    }

    public String getEmployeeName() {

        return employeeName;

    }

    public void setEmployeeName(String employeeName) {

        this.employeeName = employeeName;

    }

    public String getDepartment() {

        return department;

    }

    public void setDepartment(String department) {

        this.department = department;

    }

    public double getSalary() {

        return salary;

    }

    public void setSalary(double salary) {

        this.salary = salary;

    }

    public LocalDate getJoiningDate() {

        return joiningDate;

    }

    public void setJoiningDate(LocalDate joiningDate) {

        this.joiningDate = joiningDate;

    }

    @Override
    public String toString() {

        return "Employee [employeeId=" + employeeId
                + ", employeeName=" + employeeName
                + ", department=" + department
                + ", salary=" + salary
                + ", joiningDate=" + joiningDate + "]";

    }

}