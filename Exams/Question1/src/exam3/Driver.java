
package exam3;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex Vasil
 */
public class Driver {
    private static Database database = new Database();
    
    public static void main(String[] args) {
        database.createEmployeeTable();
        //Create and save a list of employees to be added into the db.
        List<Employee> empList = createEmployees();
        System.out.println("Inserting Employees into the database\n");
        for (int i = 0; i < empList.size(); i++) {
            database.AddEmployee(empList.get(i));
        }
        
        System.out.println("\nGetting Employee by Id: 123a\n");
        System.out.println(database.getEmployeeById("123a"));
        
        System.out.println("\nPrinting out all employees in a map:");
        Map<String, String> employeeMap = database.getAllEmployees();
        
        employeeMap.entrySet().forEach((employeeEntry) -> { System.out.println(employeeEntry.getValue()); });
        
    }
    
    public static List<Employee> createEmployees() {
        List<Employee> empList = new ArrayList<>();
        
        empList.add(new Employee("123a", "Alex", "1234 6th drive", 100000));
        empList.add(new Employee("133b", "Jason", "7667 6th avenue", 150000));
        empList.add(new Employee("143c", "Christian", "1231 6th drive", 140000));
        empList.add(new Employee("223f", "Nico", "9802 6th drive", 120000));
        empList.add(new Employee("423a", "Lyn", "2346 8th drive", 100000));
        
        return empList;
    }
}
