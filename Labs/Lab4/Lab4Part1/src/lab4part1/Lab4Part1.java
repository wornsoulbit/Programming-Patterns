/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author Alex Vasil
 */
public class Lab4Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Question 1 1.
        Highscores highscores = new Highscores();
        
        //<editor-fold defaultstate="collapsed" desc="Adding highscores to the highscore list">
        highscores.insert("Dan", 1000);
        highscores.insert("Evan", 3000);
        highscores.insert("Alex", 2000);
        highscores.insert("George", 2000);
        highscores.insert("some name2", 2100);
        highscores.insert("Sire", 20000);
        highscores.insert("Rando", 500);
        highscores.insert("idk", 500);
        highscores.insert("Good", 100);
        highscores.insert("Bad", 30000);
        highscores.insert("GeorgeNotFound", 30000);
        highscores.insert("Sapnap", 50000);
        highscores.insert("Dream", 60000);
        highscores.insert("some name3", 600);
        highscores.insert("some name4", 2600);
        highscores.insert("some name5", 2800);
        highscores.insert("some name6", 3300);
//</editor-fold>

        System.out.println("\nQuestion 1, 1");
        highscores.printScoreNameList();
        
        //Question 1 2.
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 2; i <= 100; i++) {
            arrayList.add(i);
        }
        
        Iterator<Integer> it = arrayList.iterator();
        
        while (it.hasNext()) {
            Integer number = it.next(); //2,3,4,5,6,7,8,9
            
            if (!IsPrime.isPrime(number)) {
                it.remove();
            }
        }
        
        System.out.println("\nQuestion 1, 2");
        arrayList.stream().forEach(e -> System.out.println(e));
        
        //Question 2.
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(10, new ComparePatient());
        patientQueue.add(new Patient(1, "Patient1", false));
        patientQueue.add(new Patient(2, "Patient2", false));
        patientQueue.add(new Patient(3, "Patient3", true));
        patientQueue.add(new Patient(4, "Patient4", false));
        patientQueue.add(new Patient(5, "Patient5", true));
        
        
        System.out.println("\nQuestion 2");
        System.out.print("Doctors wainting for Patient: ");
        patientQueue.forEach(e -> System.out.print(e.getName() + " <- "));
        System.out.println("");
         
        //Question 3.
        HashSet<Instructor> instructors = new HashSet<>();
        
        instructors.add(new Instructor("John", "Doe", 02));
        instructors.add(new Instructor("Jane", "Doe", 03));
        instructors.add(new Instructor("idk2", "idk2", 04));
        instructors.add(new Instructor("idk3", "idk3", 05));
        instructors.add(new Instructor("idk4", "idk4", 06));
        
        String nameToSearch = "Doe";
        
        System.out.println("\nQuestion 3");
        instructors.stream().filter(e -> nameToSearch.equals(e.getFirstName()) || 
                nameToSearch.equals(e.getLastName())).forEach(e -> System.out.println(e));
        
        //Question 4 1.
        
        HashMap<Integer, Stock> stockMap = new HashMap<>();
        
        Stock s1 = new Stock(10, 256, "Wooden Boxes");
        Stock s2 = new Stock(20, 19, "Iron Boxes");
        Stock s3 = new Stock(30, 6, "Gold Boxes");
        
        stockMap.put(s1.getStockNumber(), s1);
        stockMap.put(s2.getStockNumber(), s2);
        stockMap.put(s3.getStockNumber(), s3);
        
        int stockToFind = 20;
        
        System.out.println("\nQuestion 4, 1");
        System.out.println(stockMap.get(stockToFind));
        
        //Question 4 2.
        
//        HashMap<Integer, ArrayList<String>> students = new HashMap<>();
//        
//        Student student1 = new Student(10000, Arrays.asList("CS102", "CS105"));
//        Student student2 = new Student(20000, Arrays.asList("CS102", "CS105", "Math100"));
//        Student student3 = new Student(1000, Arrays.asList("CS105", "Math100"));
//        students.put(student1.getStudentID(), student1.getCourseList());
//        students.put(student2.getStudentID(), student2.getCourseList());
//        students.put(student3.getStudentID(), student3.getCourseList());
    }
}
