/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject2;

/**
 *
 * @author Alex Vasil
 */
public class Book {
    private String serialNum;
    private String title;
    private String author;
    private String publisher;
    private int quantity;
    private int issuedQuant;
    private String date;
    
    public Book() {
        
    }
    
    public Book(String serialNum, String title, String author, String publisher, int quantity, int issuedQuant, String dateOfPurchase) {
        this.serialNum = serialNum;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issuedQuant = issuedQuant;
        this.date = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Book{" + "serialNum=" + serialNum + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", quantity=" + quantity + ", issuedQuant=" + issuedQuant + ", dateOfPurchase=" + date + '}';
    }

    public String getSerialNum() {
        return serialNum;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getIssuedQuant() {
        return issuedQuant;
    }

    public void setIssuedQuant(int issuedQuant) {
        this.issuedQuant = issuedQuant;
    }

    public String getDate() {
        return date;
    }
}
