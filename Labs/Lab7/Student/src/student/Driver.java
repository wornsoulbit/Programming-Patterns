
package student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Vasil
 */
public class Driver {
    
    private static StudentController studentController;
    private static StudentView view;
    
    
    public static void main(String[] args) throws SQLException {
        view = new StudentView();
        studentController = new StudentController(listOfStudents(), view);
        
        String studentTable = "CREATE TABLE Students "
                + "(id INT PRIMARY KEY      NOT NULL, "
                + " name       NVARCHAR(30) NOT NULL, "
                + " address    NVARCHAR(40) NOT NULL) ";
        
        studentController.createStudentTable(studentTable);
        
        for (Student student : listOfStudents()) {
            studentController.addStudent(student);
        }
        
        studentController.updateView(studentController.getAllStudents());
        studentController.deleteStudentID(2);
        studentController.updateView(studentController.getAllStudents());
        System.out.println(studentController.getStudentId(2));
        
        studentController.addStudent(new Student(100, "Alex", "5004 blah street"));
        studentController.updateView(studentController.getAllStudents());
    }
    
    /**
     * Creates a list of students.
     * 
     * @return A list of students.
     */
    public static List<Student> listOfStudents() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            studentList.add(new Student(i, "cool name " + i, 2000 + i + "stupid street"));
        }
        
        return studentList;
    }
}
