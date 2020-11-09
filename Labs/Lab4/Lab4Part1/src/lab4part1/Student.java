/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;

import java.util.ArrayList;

/**
 *
 * @author Alex Vasil
 */
public class Student {
    private int studentID;
    private ArrayList<String> courseList;

    public Student(int studentID, ArrayList<String> courseList) {
        this.studentID = studentID;
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", courseList=" + courseList + '}';
    }
    
    public int getStudentID() {
        return studentID;
    }

    public ArrayList<String> getCourseList() {
        return courseList;
    }
}
