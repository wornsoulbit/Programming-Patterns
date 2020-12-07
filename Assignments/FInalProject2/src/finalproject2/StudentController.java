/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject2;

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
public class StudentController {

    private final Connection connector = DBConnection.getInstance();
    private static StudentController studentController;
    private BookController bc = BookController.getInstance();
    
    /**
     * Creates a new instance of StudentController if there isn't one already.
     * 
     * @return Instance of student controller.
     */
    public static StudentController getInstance() {
        if (studentController == null) {
            studentController = createInstance();
        }
        return studentController;
    }

    /**
     * Creates a new instance of StudentController.
     * 
     * @return Instance of student controller.
     */
    private static StudentController createInstance() {
        return new StudentController();
    }

    /**
     * Creates a student table in the database with StudentID, StudentName, and 
     * StudentContact as values.
     */
    public void createStudentTable() {
        try (Statement stmt = connector.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS Student;");
            stmt.executeUpdate("CREATE TABLE STUDENT "
                    + "(StudentId int PRIMARY KEY,"
                    + "StudentName text, "
                    + "StudentContact text);");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Creates a Issued Books table in the database with a Id, SerialNum, StudentId,
     * StudentName, StudentContact, and a IssueDate.
     */
    public void createIssuedBooksTable() {
        try (Statement stmt = connector.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS IssuedBooks;");
            stmt.executeUpdate("CREATE TABLE IssuedBooks "
                    + "(ID INTEGER PRIMARY KEY,"
                    + "SerialNum text,"
                    + "StudentId int,"
                    + "StudentName text, "
                    + "StudentContact text, "
                    + "IssueDate DATE,"
                    + "FOREIGN KEY (SerialNum) REFERENCES Book (SerialNum),"
                    + "FOREIGN KEY (StudentId) REFERENCES Student (StudentId));");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Adds a new Student into the database.
     * 
     * @param student A student to be added.
     */
    public void addStudent(Student student) {
        try (Statement stmt = connector.createStatement()) {
            String sql = "INSERT INTO Student (StudentId, StudentName, StudentContact)";
            sql += String.format("Values (%d, '%s', '%s')", student.getStudentId(), student.getStudentName(), student.getContactNum());

            System.out.println("sql: " + sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Gets a student from a specified StudentId.
     * 
     * @param studentId Id of the student to be gotten.
     * @return The specified student.
     */
    public Student getStudent(int studentId) {
        Student s = null;
        
        try (Statement stmt = connector.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT WHERE StudentId=" + studentId + ";");
            
            while (rs.next()) {
                int sId = rs.getInt("StudentId");
                String sName = rs.getString("StudentName");
                String sCont = rs.getString("StudentContact");
                
                s = new Student(sId, sName, sCont);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return s;
    }
    
    /**
     * Searches for a given book title that may be within the database.
     *
     * @param title The title of the book.
     * @return A list of books with the same title.
     */
    public List<Book> SearchBookByTitle(String title) {
        List<Book> list = new ArrayList<>();

        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM BOOK WHERE Title='" + title + "' ORDER BY SerialNum");
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

    /**
     * Searches for a given author that may be within the database.
     *
     * @param name The name of the author of the book.
     * @return A list of books with the same author name.
     */
    public List<Book> SearchBookByName(String name) {
        List<Book> list = new ArrayList<>();

        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM BOOK WHERE Author='" + name + "' ORDER BY SerialNum ASC");
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

    /**
     * Searches for a book by the year it was released.
     *
     * @param year Date when the book was released.
     * @return A list of books released that year.
     */
    public List<Book> SearchBookByYear(String year) {
        List<Book> list = new ArrayList<>();

        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM BOOK WHERE "
                    + "strftime('%Y', AddedDate)='" + year + "' " //Searches for any book with the given year.
                    + "ORDER BY SerialNum");

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

    /**
     * Shows all the books in the database.
     *
     * @return A map of all the books in the database.
     */
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

                String strOut = String.format("Serial Num: '%s', Book Title: '%s', Author: '%s', "
                        + "Publisher: '%s', Quantity: %d, Issued Quant: %d, Date Published: '%s'\n",
                        serialNum, bookTitle, author, publisher, quantity, issuedQuantity, datePublished);

                list.put(serialNum, strOut);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return list;
    }

    public boolean issueBook(Book book, Student student) {
        //Checks to see if the Student or the book is null.
        if (student == null || book == null) {
            return false;
        }

        //If the student is in the database it'll attempt to borrow the book 
        //granted if there is sufficient books in the library.
        if (bc.borrowBook(book)) {
            //Updates the IssuedBooks Table in the database.
            try (Statement stmt = connector.createStatement()) {
                String sql = "INSERT INTO IssuedBooks (ID, SerialNum, StudentId, StudentName, StudentContact, IssueDate)";
                sql += String.format("Values (null, '%s', %d, '%s', '%s', '%s')",
                        book.getSerialNum(), student.getStudentId(), student.getStudentName(),
                        student.getContactNum(), book.getDate());

                System.out.println("sql: " + sql);
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(Book book, Student student) {
        //Checks to see if the Student or the book is null.
        if (student == null || book == null) {
            return false;
        }

        //If the student is in the database it'll attempt to borrow the book 
        //granted if there is sufficient books in the library.
        //Updates the IssuedBooks Table in the database.
        try (Statement stmt = connector.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM IssuedBooks WHERE StudentId=" + student.getStudentId() + " AND SerialNum='" + book.getSerialNum() + "';");
            if (rs.next()) {
                String sql = "DELETE FROM IssuedBooks WHERE StudentId="
                        + student.getStudentId() + " AND SerialNum='" + book.getSerialNum() + "';";
                System.out.println("sql: " + sql);
                stmt.executeUpdate(sql);
                bc.returnBook(book);
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return false;
    }
}
