package com.example.order;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        OrderDAO dao =
        new OrderDAO();

        Scanner sc =
        new Scanner(System.in);

        while(true) {

            System.out.println("\n===== ONLINE FOOD ORDER MENU =====");
            System.out.println("1. Place Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice =
            sc.nextInt();

            switch(choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String customerName =
                sc.nextLine();

                System.out.print("Enter Food Item: ");
                String foodItem =
                sc.nextLine();

                System.out.print("Enter Quantity: ");
                int quantity =
                sc.nextInt();

                System.out.print("Enter Total Amount: ");
                double totalAmount =
                sc.nextDouble();

                sc.nextLine();

                System.out.print("Enter Order Date (yyyy-mm-dd): ");
                LocalDate orderDate =
                LocalDate.parse(sc.nextLine());

                System.out.print("Enter Order Status: ");
                String orderStatus =
                sc.nextLine();

                dao.saveOrder(
                        new Order(
                                customerName,
                                foodItem,
                                quantity,
                                totalAmount,
                                orderDate,
                                orderStatus
                        )
                );

                System.out.println(
                        "Order Placed Successfully"
                );

                break;

            case 2:

                List<Order> orders =
                dao.getAllOrders();

                if(orders.isEmpty()) {

                    System.out.println(
                            "No Orders Found"
                    );

                } else {

                    orders.forEach(System.out::println);

                }

                break;

            case 3:

                System.out.print(
                        "Enter Order ID To Update: "
                );

                int updateId =
                sc.nextInt();

                Order order =
                dao.getOrder(updateId);

                if(order == null) {

                    System.out.println(
                            "Order Not Found"
                    );

                    break;

                }

                sc.nextLine();

                System.out.print("Enter New Customer Name: ");
                order.setCustomerName(sc.nextLine());

                System.out.print("Enter New Food Item: ");
                order.setFoodItem(sc.nextLine());

                System.out.print("Enter New Quantity: ");
                order.setQuantity(sc.nextInt());

                System.out.print("Enter New Total Amount: ");
                order.setTotalAmount(sc.nextDouble());

                sc.nextLine();

                System.out.print("Enter New Order Date (yyyy-mm-dd): ");
                order.setOrderDate(
                        LocalDate.parse(sc.nextLine())
                );

                System.out.print("Enter New Order Status: ");
                order.setOrderStatus(sc.nextLine());

                dao.updateOrder(order);

                System.out.println(
                        "Order Updated Successfully"
                );

                break;

            case 4:

                System.out.print(
                        "Enter Order ID To Delete: "
                );

                int deleteId =
                sc.nextInt();

                dao.deleteOrder(deleteId);

                System.out.println(
                        "Order Deleted Successfully"
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