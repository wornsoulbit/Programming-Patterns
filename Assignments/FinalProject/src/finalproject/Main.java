/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.List;

/**
 *
 * @author Alex Vasil
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        Student student = new Student();
        
        //book.addBook(new Book("1236", "Title", "Author", "Publisher", 1, 2, "1999-01-01"));
        //book.addBook(new Book("1231", "Title", "Author2", "Publisher", 11, 5, "1999-01-01"));
        
        List<Book> bookList = student.SearchBookByTitle("Title");
        
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i).getAuthor());
            System.out.println(bookList.get(i).getTitle());
            System.out.println(bookList.get(i).getSerialNum());
            System.out.println(bookList.get(i).getQuantity());
            System.out.println(bookList.get(i).getIssuedQuant());
            System.out.println(bookList.get(i).getDateOfPurchase());
            System.out.println(bookList.get(i).getPublisher());
        }
    }
}
