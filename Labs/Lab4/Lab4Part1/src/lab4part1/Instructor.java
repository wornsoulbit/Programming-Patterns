/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;

/**
 *
 * @author Alex Vasil
 */
public class Instructor {
    private String firstName;
    private String lastName;
    private int officeNum;
    
    public Instructor(String firstName, String lastName, int officeNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNum = officeNum;
    }

    @Override
    public String toString() {
        return "Instructor{" + "firstName=" + firstName + ", lastName=" + lastName + ", officeNum=" + officeNum + '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getOfficeNum() {
        return officeNum;
    }
}
