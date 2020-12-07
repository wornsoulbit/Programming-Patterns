package finalproject2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex Vasil
 */
public class BookController {

    private static final Connection connector = DBConnection.getInstance();
    private static BookController bookController;
    
    public static BookController getInstance() {
        if (bookController == null) {
            bookController = createInstance();
        }
        return bookController;
    }

    private static BookController createInstance() {
        return new BookController();
    }
    
    public void createBookTable() {
        try (Statement stmt = connector.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS Book;");
            stmt.executeUpdate("CREATE TABLE Book "
                    + "(SerialNum text PRIMARY KEY,"
                    + "Title text NOT NULL,"
                    + "Author text NOT NULL,"
                    + "Publisher text NOT NULL,"
                    + "Quantity int,"
                    + "IssuedQuant int,"
                    + "AddedDate DATE);");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Adds a book into the database.
     * 
     * @param book Book to be added into the database.
     */
    public void addBook(Book book) {
        try (Statement stmt = connector.createStatement()) {
            String sql = "INSERT INTO Book (SerialNum, Title, Author, Publisher, Quantity, IssuedQuant, AddedDate)";
            sql += String.format("Values ('%s', '%s', '%s', '%s', %d, %d, '%s')", book.getSerialNum(), book.getTitle(),
                    book.getAuthor(), book.getPublisher(), book.getQuantity(), book.getIssuedQuant(), book.getDate());

            System.out.println("sql: " + sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Gets a book based off of the title of the book.
     * 
     * @param bookTitle The title of the book.
     * @return The book based off of the title.
     */
    public Book getBook(String bookTitle) {
        Book b = null;

        try (Statement stmt = connector.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE Title='" + bookTitle + "';");

            while (rs.next()) {
                String serialNum = rs.getString("SerialNum");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                int quantity = rs.getInt("Quantity");
                int issuedQuant = rs.getInt("IssuedQuant");
                String date = rs.getString("AddedDate");

                b = new Book(serialNum, title, author, publisher, quantity, issuedQuant, date);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return b;
    }

    /**
     * Updates the database to subtract the quantity by 1 and increase the issued
     * quantity by 1.
     * 
     * @param book The book to be updated in the database.
     * @return If the above has succeeded without anything going wrong.
     */
    public boolean borrowBook(Book book) {
        //Will only issue a book if there is more than 0 books available
        if (book.getQuantity() > 0) {
            int newBookQuant = book.getQuantity() - 1;
            book.setQuantity(newBookQuant);
            int newIssuedQuant = book.getIssuedQuant() + 1;
            book.setIssuedQuant(newIssuedQuant);
            try (Statement stmt = connector.createStatement()) {
                stmt.executeUpdate("UPDATE BOOK SET QUANTITY = " + newBookQuant + " WHERE SerialNum = '" + book.getSerialNum() + "'");
                stmt.executeUpdate("UPDATE BOOK SET ISSUEDQUANT = " + newIssuedQuant + " WHERE SerialNum = '" + book.getSerialNum() + "'");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the database to add the quantity by 1 and decrease the issued
     * quantity by 1.
     * 
     * @param book The book to be updated in the database.
     * @return If the above has succeeded without anything going wrong.
     */
    public boolean returnBook(Book book) {
        //Will only issue a book if there is more than 0 books available
        if (book.getIssuedQuant() > 0) {
            int newBookQuant = book.getQuantity() + 1;
            book.setQuantity(newBookQuant);
            int newIssuedQuant = book.getIssuedQuant() - 1;
            book.setIssuedQuant(newIssuedQuant);
            try (Statement stmt = connector.createStatement()) {
                stmt.executeUpdate("UPDATE BOOK SET QUANTITY = " + newBookQuant + " WHERE SerialNum = '" + book.getSerialNum() + "'");
                stmt.executeUpdate("UPDATE BOOK SET ISSUEDQUANT = " + newIssuedQuant + " WHERE SerialNum = '" + book.getSerialNum() + "'");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Shows all the Books in the database.
     *
     * @return A map of all the books in the database.
     */
    public static Map<String, String> viewCatalog() {
        Map<String, String> list = new HashMap();

        try (Statement stmt = connector.createStatement()) {
            ResultSet rs = stmt.executeQuery("Select * from Book ORDER BY SerialNum");

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

    /**
     * Shows all the books that have been borrowed.
     *
     * @return A map of all the books that have been borrowed.
     */
    public static Map<String, String> viewIssuedBooks() {
        Map<String, String> list = new HashMap();

        try (Statement stmt = connector.createStatement()) {
            ResultSet rs = stmt.executeQuery("Select * from IssuedBooks ORDER BY SerialNum");

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String SerialNum = rs.getString("SerialNum");
                String StudentId = rs.getString("StudentId");
                String StudentName = rs.getString("StudentName");
                String StudentCont = rs.getString("StudentContact");
                String issueDate = rs.getString("issueDate");

                list.put(ID + "", SerialNum + " " + StudentId + " " + StudentName 
                        + " " + StudentCont + " " + issueDate);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return list;
    }
}
