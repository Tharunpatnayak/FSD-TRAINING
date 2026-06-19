package com.example.employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeDAO dao =
        new EmployeeDAO();

        Scanner sc =
        new Scanner(System.in);

        while(true) {

            System.out.println("\n===== EMPLOYEE PAYROLL MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Read All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice =
            sc.nextInt();

            switch(choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name =
                sc.nextLine();

                System.out.print("Enter Department: ");
                String department =
                sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary =
                sc.nextDouble();

                sc.nextLine();

                System.out.print("Enter Joining Date (yyyy-mm-dd): ");
                LocalDate joiningDate =
                LocalDate.parse(sc.nextLine());

                dao.saveEmployee(
                        new Employee(
                                name,
                                department,
                                salary,
                                joiningDate
                        )
                );

                System.out.println(
                        "Employee Inserted Successfully"
                );

                break;

            case 2:

                List<Employee> employees =
                dao.getAllEmployees();

                if(employees.isEmpty()) {

                    System.out.println(
                            "No Employees Found"
                    );

                } else {

                    employees.forEach(System.out::println);

                }

                break;

            case 3:

                System.out.print(
                        "Enter Employee ID To Update: "
                );

                int updateId =
                sc.nextInt();

                Employee emp =
                dao.getEmployee(updateId);

                if(emp == null) {

                    System.out.println(
                            "Employee Not Found"
                    );

                    break;

                }

                sc.nextLine();

                System.out.print("Enter New Name: ");
                emp.setEmployeeName(sc.nextLine());

                System.out.print("Enter New Department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter New Salary: ");
                emp.setSalary(sc.nextDouble());

                sc.nextLine();

                System.out.print("Enter New Joining Date (yyyy-mm-dd): ");
                emp.setJoiningDate(
                        LocalDate.parse(sc.nextLine())
                );

                dao.updateEmployee(emp);

                System.out.println(
                        "Employee Updated Successfully"
                );

                break;

            case 4:

                System.out.print(
                        "Enter Employee ID To Delete: "
                );

                int deleteId =
                sc.nextInt();

                dao.deleteEmployee(deleteId);

                System.out.println(
                        "Employee Deleted Successfully"
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