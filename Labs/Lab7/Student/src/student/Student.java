
package student;

/**
 * Basic student class.
 * 
 * @author Alex Vasil
 */
public class Student {
    private int studentId;
    private String name;
    private String address;
    
    /**
     * Default constructor of a student.
     * 
     * @param studentId Student id.
     * @param name Student name.
     * @param address Student address.
     */
    public Student(int studentId, String name, String address) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
    }

    /**
     * To string method with student id, name, and address.
     * @return a formatted string.
     */
    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name=" + name + ", address=" + address + '}';
    }

    /**
     * Student Id
     * @return student id.
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Student Name
     * @return Student Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Student address.
     * 
     * @return Student address.
     */
    public String getAddress() {
        return address;
    }
}
