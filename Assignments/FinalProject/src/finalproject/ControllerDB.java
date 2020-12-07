/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex Vasil
 */
public class ControllerDB {
    private Connection connector = DBConnection.createConnection();
    
    public void resetDB() {
        try (Statement stmt = connector.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS IssuedBooks");
            stmt.executeUpdate("DROP TABLE IF EXISTS Books");
            stmt.executeUpdate("DROP TABLE IF EXISTS Student");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void addBook(Book book) {
        try (Statement stmt = connector.createStatement()) {
            String sql = "INSERT INTO Book (SerialNum, Title, Author, Publisher, Quantity, IssuedQuant, AddedDate)";
            sql += String.format("Values ('%s', '%s', '%s', '%s', '%d', '%d', '%s')", book.getSerialNum(), book.getTitle(),
                    book.getAuthor(), book.getPublisher(), book.getQuantity(), book.getIssuedQuant(), book.getDateOfPurchase());
            
            System.out.println("sql: " + sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public List<Book> SearchBookByTitle(String title) {
        List<Book> list = new ArrayList<>();

        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM BOOK WHERE Title=" + title + " ORDER BY SerialNum");
            while (rs.next()) {
                String serialNum = rs.getString("SerialNum");
                String bookTitle = rs.getString("Title");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                int quantity = rs.getInt("Quantity");
                int issuedQuantity = rs.getInt("IssuedQuant");
                String datePublished = rs.getString("AddedDate");

                list.add(new Book(serialNum, bookTitle, author, publisher, quantity, issuedQuantity, datePublished));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return list;   
    }
    
    public List<Book> SearchBookByName(String name) {
        List<Book> list = new ArrayList<>();

        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM BOOK WHERE Author=" + name + " ORDER BY SerialNum ASC");
            while (rs.next()) {
                String serialNum = rs.getString("SerialNum");
                String bookTitle = rs.getString("Title");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                int quantity = rs.getInt("Quantity");
                int issuedQuantity = rs.getInt("IssuedQuant");
                String datePublished = rs.getString("AddedDate");

                list.add(new Book(serialNum, bookTitle, author, publisher, quantity, issuedQuantity, datePublished));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return list;
    }
    
    public List<Book> SearchBookByYear(String year) {
        List<Book> list = new ArrayList<>();

        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM BOOK WHERE AddedDate=" + year + " ORDER BY SerialNum");
            while (rs.next()) {
                String serialNum = rs.getString("SerialNum");
                String bookTitle = rs.getString("Title");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                int quantity = rs.getInt("Quantity");
                int issuedQuantity = rs.getInt("IssuedQuant");
                String datePublished = rs.getString("AddedDate");

                list.add(new Book(serialNum, bookTitle, author, publisher, quantity, issuedQuantity, datePublished));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return list;
    }
    
    public Map<String, String> viewCatalog() {
        Map<String, String> list = new HashMap();

        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM BOOK ORDER BY SerialNum");
            while (rs.next()) {
                String serialNum = rs.getString("SerialNum");
                String bookTitle = rs.getString("Title");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                int quantity = rs.getInt("Quantity");
                int issuedQuantity = rs.getInt("IssuedQuant");
                String datePublished = rs.getString("AddedDate");

                list.put(serialNum, bookTitle + " " + author + " " + publisher + " " + quantity + " " + datePublished);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return list;
    }
}
