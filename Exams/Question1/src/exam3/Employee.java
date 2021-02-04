/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3;

/**
 *
 * @author Alex Vasil
 */
public class Employee {
    private String employeeId;
    private String employeeName;
    private String address;
    private int salary;

    public Employee() {
        
    }
    
    public Employee(String employeeId, String employeeName, String address, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Employee Id: %s Employee Name: %s Address: %s Salary: %s\n", employeeId, employeeName, address, salary);
    }
    
    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }
}
