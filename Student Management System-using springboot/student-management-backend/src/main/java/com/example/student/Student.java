package com.example.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String rollno;

    private double cgpa;

    public Student() {

    }

    public Student(String name,
                   int age,
                   String rollno,
                   double cgpa) {

        this.name = name;
        this.age = age;
        this.rollno = rollno;
        this.cgpa = cgpa;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getRollno() {

        return rollno;
    }

    public void setRollno(String rollno) {

        this.rollno = rollno;
    }

    public double getCgpa() {

        return cgpa;
    }

    public void setCgpa(double cgpa) {

        this.cgpa = cgpa;
    }

    @Override
    public String toString() {

        return "Student [id=" + id
                + ", name=" + name
                + ", age=" + age
                + ", rollno=" + rollno
                + ", cgpa=" + cgpa + "]";
    }

}