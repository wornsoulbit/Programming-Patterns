package finalproject;

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
public class Student {

    private int studentId;
    private String studentName;
    private String contactNum;
    private ControllerDB connector = new ControllerDB();

    public Student() {
        
    }
    
    public Student(int studentId, String studentName, String contactNum) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNum = contactNum;
    }

    public List<Book> SearchBookByTitle(String title) {
        return connector.SearchBookByTitle(title);
    }

    public List<Book> SearchBookByName(String name) {
        return connector.SearchBookByName(name);
    }

    public List<Book> SearchBookByYear(String year) {
        return connector.SearchBookByYear(year);
    }

    public Map<String, String> viewCatalog() {
        return connector.viewCatalog();
    }

    public boolean borrowBook(Book book) {
        return true; //TODO
    }

    public boolean returnBook(Book book) {
        return true; //TODO
    }
}
