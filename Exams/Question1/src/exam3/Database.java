/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex Vasil
 */
public class Database {
    private final Connection connector = DBConnection.getInstance();
    
    /**
     * Creates a student table in the database with StudentID, StudentName, and 
     * StudentContact as values.
     */
    public void createEmployeeTable() {
        try (Statement stmt = connector.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS Employee;");
            stmt.executeUpdate("CREATE TABLE Employee "
                    + "(EmployeeId text PRIMARY KEY,"
                    + "EmployeeName text, "
                    + "Address text, "
                    + "Salary int);");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void AddEmployee(Employee employee) {
        try (Statement stmt = connector.createStatement()) {
            String sql = "INSERT INTO Employee (EmployeeId, EmployeeName, Address, Salary)";
            sql += String.format("Values ('%s', '%s', '%s', %d)", employee.getEmployeeId(), employee.getEmployeeName(), employee.getAddress(), employee.getSalary());

            System.out.println("sql: " + sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public Employee getEmployeeById(String employeeId) {
        Employee employee = null;
        
        try (Statement stmt = connector.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE EmployeeId='" + employeeId + "';");
            
            while (rs.next()) {
                String eId = rs.getString("EmployeeId");
                String employeeName = rs.getString("EmployeeName");
                String address = rs.getString("Address");
                int salary = rs.getInt("Salary");
                
                employee = new Employee(eId, employeeName, address, salary);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return employee;
    }
    
    public Map<String, String> getAllEmployees() {
        Map<String, String> empList = new HashMap<>();
        
        try (Statement stmt = connector.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee ORDER BY EmployeeId ASC;");
            
            while (rs.next()) {
                String eId = rs.getString("EmployeeId");
                String employeeName = rs.getString("EmployeeName");
                String address = rs.getString("Address");
                int salary = rs.getInt("Salary");
                
                String strOut = String.format("%s %s %s %d", eId, employeeName, address, salary);
                
                empList.put(eId, strOut);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
        return empList;
    } 
    
}
