
package finalproject;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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
    private String dateOfPurchase;
    
    private ControllerDB conn = new ControllerDB();
    
    public Book() {
        
    }
    
    public Book(String serialNum, String title, String author, String publisher, int quantity, int issuedQuant, String dateOfPurchase) {
        this.serialNum = serialNum;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issuedQuant = issuedQuant;
        this.dateOfPurchase = dateOfPurchase;
    }
    
    public void addBook(Book book) {
        conn.addBook(book);
    }
    
    public boolean issueBook(Book book, Student student) {
        return true;
    }
    
    public boolean returnBook(Book book, Student student) {
        return true;
    }
    
    public static Map<String, String> viewCatalog() {
        Map<String, String> list = new HashMap();
        
        return list;
    }
    
    public static Map<String, String> viewIssuedBooks() {
        Map<String, String> list = new HashMap();
        
        return list;
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

    public int getIssuedQuant() {
        return issuedQuant;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }
    
}
