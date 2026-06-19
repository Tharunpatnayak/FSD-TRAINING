package com.example.book;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        BookDAO dao =
        new BookDAO();

        Scanner sc =
        new Scanner(System.in);

        while(true) {

            System.out.println("\n===== LIBRARY BOOK MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice =
            sc.nextInt();

            switch(choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Title: ");
                String title =
                sc.nextLine();

                System.out.print("Enter Author: ");
                String author =
                sc.nextLine();

                System.out.print("Enter Category: ");
                String category =
                sc.nextLine();

                System.out.print("Enter Price: ");
                double price =
                sc.nextDouble();

                System.out.print("Enter Available Copies: ");
                int copies =
                sc.nextInt();

                dao.saveBook(
                        new Book(
                                title,
                                author,
                                category,
                                price,
                                copies
                        )
                );

                System.out.println(
                        "Book Added Successfully"
                );

                break;

            case 2:

                List<Book> books =
                dao.getAllBooks();

                if(books.isEmpty()) {

                    System.out.println(
                            "No Books Found"
                    );

                } else {

                    books.forEach(System.out::println);

                }

                break;

            case 3:

                System.out.print(
                        "Enter Book ID To Update: "
                );

                int updateId =
                sc.nextInt();

                Book book =
                dao.getBook(updateId);

                if(book == null) {

                    System.out.println(
                            "Book Not Found"
                    );

                    break;

                }

                sc.nextLine();

                System.out.print("Enter New Title: ");
                book.setTitle(sc.nextLine());

                System.out.print("Enter New Author: ");
                book.setAuthor(sc.nextLine());

                System.out.print("Enter New Category: ");
                book.setCategory(sc.nextLine());

                System.out.print("Enter New Price: ");
                book.setPrice(sc.nextDouble());

                System.out.print("Enter Available Copies: ");
                book.setAvailableCopies(sc.nextInt());

                dao.updateBook(book);

                System.out.println(
                        "Book Updated Successfully"
                );

                break;

            case 4:

                System.out.print(
                        "Enter Book ID To Delete: "
                );

                int deleteId =
                sc.nextInt();

                dao.deleteBook(deleteId);

                System.out.println(
                        "Book Deleted Successfully"
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