package finalproject2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alex Vasil
 */
public class DBConnection {

    private static Connection connect;

    /**
     * Creates a new instance of a Connection.
     *
     * @return A new connection if there isn't one.
     */
    public static Connection getInstance() {
        if (connect == null) {
            connect = createConnection();
        }

        return connect;
    }

    /**
     * Creates a new connection to the database.
     *
     * @return A new connection.
     */
    private static Connection createConnection() {
        String dbUrl = "jdbc:sqlite:D:\\Computer Science Code&Homework\\SemesterThree\\Programming-Patterns\\Assignments\\FinalProject2\\bookStudent.db";
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(dbUrl);
            System.out.println("Open database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return c;
    }
}
