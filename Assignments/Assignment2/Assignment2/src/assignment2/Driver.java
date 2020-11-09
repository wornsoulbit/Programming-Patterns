/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alex Vasil
 */
public class Driver {

//    public static void main(String[] args) {
//        //<editor-fold defaultstate="collapsed" desc="Tests out removing, adding, union, intersection and difference methods.">
//        MySet<Integer> intMySet = new MySet<>();
//        //<editor-fold defaultstate="collapsed" desc="Adding numbers to intMySet">
//        intMySet.add(2);
//        intMySet.add(5);
//        intMySet.add(8);
//        intMySet.add(9);
//        //</editor-fold>
//
//        MySet<Integer> intMySet2 = new MySet<>();
//        //<editor-fold defaultstate="collapsed" desc="Adding numbers to intMySet2">
//        intMySet2.add(4);
//        intMySet2.add(5);
//        intMySet2.add(6);
//        intMySet2.add(7);
//        intMySet2.add(8);
//        //</editor-fold>
//
//        System.out.println("Union of set 1 and 2");
//        displaySet(intMySet.union(intMySet2)); //2, 4, 5, 6, 7, 8, 9
//        
//        System.out.println("\nIntersection of set 1 and 2");
//        displaySet(intMySet.intersection(intMySet2)); //5, 8
//
//        System.out.println("\nDifference of set 1 and 2");
//        displaySet(intMySet.difference(intMySet2)); //2, 9
//
//        System.out.println("\nInital Set");
//        displaySet(intMySet);
//        intMySet.remove(1);
//        intMySet.remove(3);
//        intMySet.remove(2);
//
//        System.out.println("\nSet with removed number");
//        displaySet(intMySet);
//
//        intMySet.add(30);
//        intMySet.add(20);
//        System.out.println("\nSet with added numbers");
//        displaySet(intMySet);
//        intMySet.remove(20);
//        System.out.println("\nSet with removed number");
//        displaySet(intMySet);
//        //</editor-fold>
//
//        Integer intArr[] = {1, 2, 3, 4, 5};
//        MySet<Integer> intSet = new MySet<>(intArr);
//        System.out.println("\nInt set with a array.");
//        displaySet(intSet);
//    }
    public static void main(String[] args) {
        String[] array1 = {"one", "two", "three"};
        String[] array2 = {"three", "four", "five"};
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(array2));
        MySet<String> set1 = new MySet<>();
        MySet<String> set2 = new MySet<>(array1);
        MySet<String> set3 = new MySet<>(list1);
        set1.add("zero");
        set1.add("two");
        set1.add("two");
        displaySet("\nset1 adding duplicate two", set1);
        set1.set("one", 1);
        set1.set("one", 0);
        displaySet("\nset1 replacing two with one", set1);
        displaySet("\nset2 a set from an array", set2);
        displaySet("\nset3 a set from a list", set3);
        displaySet("\nset1 intersect set2", set1.intersection(set2));
        displaySet("\n set1 after intersection", set1);
        displaySet("\n set2 intersect set3", set2.intersection(set3));
        displaySet("\n set2 after intersection", set2);
        displaySet("\n set2 union set3 ", set2.union(set3));
        displaySet("\n set2 after union", set2);
        System.out.println("\nset2 difference set3 ");
        displaySet("\nset2 difference set3 ", set2.difference(set3));
        displaySet("\n set2 after difference", set2);
    }

    public static void displaySet(String msg, MySet list) {
        System.out.println(msg);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
    }

    public static void displaySet(MySet e) {
        for (int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i));
        }
    }
}
