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
        //<editor-fold defaultstate="collapsed" desc="Tests out removing, adding, union, intersection and difference methods.">
        MySet<Integer> intMySet = new MySet<>();
        //<editor-fold defaultstate="collapsed" desc="Adding numbers to intMySet">
        intMySet.add(2);
        intMySet.add(5);
        intMySet.add(8);
        intMySet.add(9);
        //</editor-fold>

        MySet<Integer> intMySet2 = new MySet<>();
        //<editor-fold defaultstate="collapsed" desc="Adding numbers to intMySet2">
        intMySet2.add(4);
        intMySet2.add(5);
        intMySet2.add(6);
        intMySet2.add(7);
        intMySet2.add(8);
        //</editor-fold>

        System.out.println("Union of set 1 and 2");
        displaySet(intMySet.union(intMySet2)); //2, 4, 5, 6, 7, 8, 9
        
        System.out.println("\nIntersection of set 1 and 2");
        displaySet(intMySet.intersection(intMySet2)); //5, 8

        System.out.println("\nDifference of set 1 and 2");
        displaySet(intMySet.difference(intMySet2)); //2, 9

        System.out.println("\nInital Set");
        displaySet(intMySet);
        intMySet.remove(1);
        intMySet.remove(3);
        intMySet.remove(2);

        System.out.println("\nSet with removed number");
        displaySet(intMySet);

        intMySet.add(30);
        intMySet.add(20);
        System.out.println("\nSet with added numbers");
        displaySet(intMySet);
        intMySet.remove(20);
        System.out.println("\nSet with removed number");
        displaySet(intMySet);
        //</editor-fold>

        Integer intArr[] = {1, 2, 3, 4, 5};
        MySet<Integer> intSet = new MySet<>(intArr);
        System.out.println("\nInt set with a array.");
        displaySet(intSet);
    }

    public static void displaySet(MySet e) {
        for (int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i));
        }
    }
}
