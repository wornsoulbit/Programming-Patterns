/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment02;


/**
 *
 * @author Alex Vasil
 */
public class Driver {
    
    public static void main(String[] args) {
        MySet<Integer> intMySet = new MySet<>();
        //<editor-fold defaultstate="collapsed" desc="Adding numbers to intMySet">
        intMySet.add(2);
        intMySet.add(2);
        intMySet.add(5);
        intMySet.add(4);
        intMySet.add(3);
        intMySet.add(5);
        intMySet.add(1);
        intMySet.add(4);
//</editor-fold>
        
        System.out.println("Inital Set");
        displaySet(intMySet);
        
        intMySet.remove(3);
        intMySet.remove(2);
        
        System.out.println("Set with removed number");
        displaySet(intMySet);
        
        intMySet.add(30);
        intMySet.add(20);
        System.out.println("Set with added numbers");
        displaySet(intMySet);
        intMySet.remove(20);
        System.out.println("Set with removed number");
        displaySet(intMySet);
    }
    
    public static void displaySet(MySet e) {
        for (int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i));
        }
    }
}
