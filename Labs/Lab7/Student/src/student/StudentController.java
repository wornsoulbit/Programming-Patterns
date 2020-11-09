package student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Student Controller.
 * 
 * @author Alex Vasil
 */
public class StudentController {

    private List<Student> studentModel;
    private StudentView studentView;
    private final Connection connector = DBConnection.createConnection();
    
    /**
     * Default constructor for a student controller.
     * 
     * @param studentModel Student model.
     * @param studentView Student view.
     */
    public StudentController(List<Student> studentModel, StudentView studentView) {
        this.studentModel = studentModel;
        this.studentView = studentView;
    }

    /**
     * Creates a new table.
     * 
     * @param sqlStatement The statement String.
     */
    public void createStudentTable(String sqlStatement) {
        try (Statement stmt = connector.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS Students;");
            stmt.executeUpdate(sqlStatement);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Adds a new student into the table.
     * 
     * @param st Student to be added.
     * @throws SQLException If something goes wrong.
     */
    public void addStudent(Student st) throws SQLException {
        try (Statement stmt = connector.createStatement()) {
            String sql = "INSERT INTO Students (id, name, address) VALUES ("
                    + st.getStudentId() + ", '" + st.getName() + "','" + st.getAddress() + "');";
            System.out.println("sql: " + sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
    }
    
    /**
     * Deletes a student from the table based on the Id.
     * 
     * @param studentId Id to be removed.
     */
    public void deleteStudentID(int studentId) {
        try (Statement smth = connector.createStatement()) {
            String sql = "DELETE FROM STUDENTS WHERE ID = " + studentId + ";";
            System.out.println("sql: " + sql);
            smth.execute(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Gets all the students in the db and returns a map.
     * 
     * @return Map of students.
     */
    public Map<Integer, Student> getAllStudents() {
        Map<Integer, Student> list = new HashMap();
        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM STUDENTS;");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                
                list.put(id, new Student(id, name, address));
            }
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return list;
    }
    
    /**
     * Gets a student based on id.
     * 
     * @param studentId Id of the student.
     * @return Student Id.
     */
    public Student getStudentId(int studentId) {
        Student st = null;
        
        try (Statement smth = connector.createStatement()) {
            ResultSet rs = smth.executeQuery("SELECT * FROM STUDENTS WHERE id = " + studentId + ";");
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                
                st = new Student(id, name, address);
            }
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return st;
    }
    
    /**
     * Updates view.
     * 
     * @param studentModel Student model.
     */
    public void updateView(Map studentModel) {
        StudentView.display(studentModel);
    }
}
