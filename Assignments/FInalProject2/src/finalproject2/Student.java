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
public class Student {
    private int studentId;
    private String studentName;
    private String contactNum;

    public Student() {
        
    }
    
    public Student(int studentId, String studentName, String contactNum) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.contactNum = contactNum;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getContactNum() {
        return contactNum;
    }
}
