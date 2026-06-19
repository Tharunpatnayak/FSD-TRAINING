package com.example.student;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        StudentDAO dao =
        new StudentDAO();

        Scanner sc =
        new Scanner(System.in);

        while(true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice =
            sc.nextInt();

            switch(choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name =
                sc.nextLine();

                System.out.print("Enter Email: ");
                String email =
                sc.nextLine();

                System.out.print("Enter Course: ");
                String course =
                sc.nextLine();

                System.out.print("Enter Age: ");
                int age =
                sc.nextInt();

                dao.saveStudent(
                        new Student(
                                name,
                                email,
                                course,
                                age
                        )
                );

                System.out.println(
                        "Student Inserted Successfully"
                );

                break;

            case 2:

                List<Student> students =
                dao.getAllStudents();

                if(students.isEmpty()) {

                    System.out.println(
                            "No Students Found"
                    );

                } else {

                    for(Student s : students) {

                        System.out.println(s);

                    }

                }

                break;

            case 3:

                System.out.print(
                        "Enter Student ID to Update: "
                );

                int updateId =
                sc.nextInt();

                Student existing =
                dao.getStudent(updateId);

                if(existing == null) {

                    System.out.println(
                            "Student Not Found"
                    );

                    break;

                }

                sc.nextLine();

                System.out.print(
                        "Enter New Name: "
                );

                existing.setName(
                        sc.nextLine()
                );

                System.out.print(
                        "Enter New Email: "
                );

                existing.setEmail(
                        sc.nextLine()
                );

                System.out.print(
                        "Enter New Course: "
                );

                existing.setCourse(
                        sc.nextLine()
                );

                System.out.print(
                        "Enter New Age: "
                );

                existing.setAge(
                        sc.nextInt()
                );

                dao.updateStudent(existing);

                System.out.println(
                        "Student Updated Successfully"
                );

                break;

            case 4:

                System.out.print(
                        "Enter Student ID to Delete: "
                );

                int deleteId =
                sc.nextInt();

                dao.deleteStudent(deleteId);

                System.out.println(
                        "Student Deleted Successfully"
                );

                break;

            case 5:

                Utility.getFactory().close();

                sc.close();

                System.exit(0);

            default:

                System.out.println(
                        "Invalid Choice"
                );

            }

        }

    }

}