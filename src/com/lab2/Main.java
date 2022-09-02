package com.lab2;

import lab2_book.Book;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Entering(books);
        boolean contin = true;
        while (contin) {
            System.out.println("""
                    --------------------------------
                    Choose option:
                    1 - show books by certain author.
                    2 - show books from certain publication.
                    3 - show books published after certain year.
                    Other - close.""");
            switch (Integer.parseInt(scan.nextLine())) {
                case 1 -> PrintbyAuthor(books);
                case 2 -> PrintbyPublication(books);
                case 3 -> PrintbyYear(books);
                default -> contin = false;
            }
        }
    }

    /**
     * method for inputting information about books
     * @param books araay of Book objects
     */
    public static void Entering(ArrayList<Book> books){
        System.out.println("""
            --------------------------------
            Enter information about books:
            (press "enter" to stop)""");
        int count=1;
        while(true) {
            Book temp = new Book();
            System.out.println("--------------------------------");
            System.out.print(count++ + ". ID: ");
            String id = scan.nextLine();
            if (id.isEmpty()) break;
            temp.setId(Integer.parseInt(id));
            System.out.print("Title: ");
            temp.setTitle(scan.nextLine());
            System.out.print("Author: ");
            temp.setAuthor(scan.nextLine());
            System.out.print("Publication: ");
            temp.setPublication(scan.nextLine());
            System.out.print("Year of publishing: ");
            temp.setPub_year(Integer.parseInt(scan.nextLine()));
            if (temp.getPub_year()<=0 || temp.getPub_year()>2022){
                System.out.print("Wrong year, please enter again: ");
                temp.setPub_year(Integer.parseInt(scan.nextLine()));
            }
            System.out.print("Number of pages: ");
            temp.setPages_num(Integer.parseInt(scan.nextLine()));
            if (temp.getPages_num()<=0 ){
                System.out.print("Wrong amount, please enter again: ");
                temp.setPages_num(Integer.parseInt(scan.nextLine()));
            }
            System.out.print("Price: ");
            temp.setPrice(Integer.parseInt(scan.nextLine()));
            if (temp.getPrice()<=0){
                System.out.print("Wrong number, please enter again: ");
                temp.setPrice(Integer.parseInt(scan.nextLine()));
            }
            books.add(temp);
        }
    }

    /**
     * method for printing array elements with certain author
     * @param books array of Book element
     */
    public static void PrintbyAuthor (ArrayList<Book> books){
        System.out.print("Enter preferable author: ");
        String author = scan.nextLine() ;
        System.out.println("Filtered list of books:");
        int count =0;
        for (Book temp: books){
            if (Objects.equals(temp.getAuthor(), author)) {
                System.out.println(temp);
                count++;
            }
        }
        if (count == 0)
            System.out.println("No books found.");
    }

    /**
     * method for printing array elements with certain publication
     * @param books array of Books elements
     */
    public static void PrintbyPublication (ArrayList<Book> books) {
        System.out.print("Enter preferable publication: ");
        String publication = scan.nextLine();
        System.out.println("Filtered list of books:");
        int count = 0;
        for (Book temp: books) {
            if (Objects.equals(temp.getPublication(), publication)) {
                System.out.println(temp);
                count++;
            }
        }
        if (count == 0)
            System.out.println("No books found.");
    }

    /**
     * method for printing array elements published after certain year
     * @param books array of Book objects
     */
    public static void PrintbyYear (ArrayList<Book> books) {
        System.out.print("Enter preferable year: ");
        int year = Integer.parseInt(scan.nextLine());
        if (year<=0 || year>2022){
            System.out.print("Wrong year, please enter again: ");
            year = Integer.parseInt(scan.nextLine());
        }
        int count =0;
        System.out.println("Filtered list of books:");
        for (Book temp: books) {
            if (temp.getPub_year() >= year) {
                System.out.println(temp);
                count++;
            }
        }
        if (count == 0)
            System.out.println("No books found.");
    }

}