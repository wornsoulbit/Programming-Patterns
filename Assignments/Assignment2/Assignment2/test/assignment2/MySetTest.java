/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex Vasil
 */
public class MySetTest {
    
    private MySet<Integer> intSet;
    private MySet<Integer> intSet2;
    
    public MySetTest() {
    }
    
    @Before
    public void setUp() {      
        //No values in it by default.
        intSet = new MySet<>();
        intSet2 = new MySet<>();
    }

    /**
     * Test of add method, of class MySet.
     */
    @Test
    public void testAdd() {
        intSet.add(5);
        intSet.add(5);
        intSet.add(2);
        
        assertEquals(2, intSet.size());
    }
    
    /**
     * Test of remove method, of class MySet.
     */
    @Test
    public void testRemove() {
        intSet.add(5);
        intSet.add(2);
        intSet.remove(2);
        
        assertEquals(1, intSet.size());
    }

    /**
     * Test of union method, of class MySet.
     */
    @Test
    public void testUnion() {
        intSet.add(2);
        intSet.add(5);
        intSet.add(8);
        intSet.add(9);
        intSet2.add(4);
        intSet2.add(5);
        intSet2.add(6);
        intSet2.add(7);
        intSet2.add(8);
        
        MySet<Integer> expectedMySet = new MySet<>(Arrays.asList(9, 8, 5, 2, 7, 6, 4)); 
        
        for (int i = 0; i < expectedMySet.size(); i++)
            assertEquals(expectedMySet.get(i).intValue(), intSet.union(intSet2).get(i).intValue());
    }

    /**
     * Test of intersection method, of class MySet.
     */
    @Test
    public void testIntersection() {
        intSet.add(2);
        intSet.add(5);
        intSet.add(8);
        intSet.add(9);
        intSet2.add(4);
        intSet2.add(5);
        intSet2.add(6);
        intSet2.add(7);
        intSet2.add(8);
        
        MySet<Integer> expectedMySet = new MySet<>(Arrays.asList(8, 5));
        
        for (int i = 0; i < expectedMySet.size(); i++)
            assertEquals(expectedMySet.get(i).intValue(), intSet.intersection(intSet2).get(i).intValue());
    }

    /**
     * Test of difference method, of class MySet.
     */
    @Test
    public void testDifference() {
        intSet.add(2);
        intSet.add(5);
        intSet.add(8);
        intSet.add(9);
        intSet2.add(4);
        intSet2.add(5);
        intSet2.add(6);
        intSet2.add(7);
        intSet2.add(8);
        
        MySet<Integer> expectedMySet = new MySet<>(Arrays.asList(9, 2));
        
        for (int i = 0; i < expectedMySet.size(); i++)
            assertEquals(expectedMySet.get(i).intValue(), intSet.difference(intSet2).get(i).intValue());
    }

    /**
     * Test of size method, of class MySet.
     */
    @Test
    public void testSize() {
        intSet.add(5);
        intSet.add(5);
        intSet.add(2);
        intSet.add(3);
        
        assertEquals(3, intSet.size());
    }

    /**
     * Test of get method, of class MySet.
     */
    @Test
    public void testGet() {
        intSet.add(5);
        intSet.add(2);
        intSet.add(3);
        
        assertEquals(2, intSet.get(1).intValue());
    }

    /**
     * Test of clear method, of class MySet.
     */
    @Test
    public void testClear() {
        intSet.add(2);
        intSet.add(5);
        intSet.add(3);
        
        intSet.clear();
        
        assertEquals(0, intSet.size());
    }

    /**
     * Test of isEmpty method, of class MySet.
     */
    @Test
    public void testIsEmpty() {
        intSet.add(5);
        assertEquals(false, intSet.isEmpty());
    }

    
    /**
     * Test of isEmpty method, of class MySet.
     */
    @Test
    public void testIsEmpty2() {
        assertEquals(true, intSet.isEmpty());
    }
    
    /**
     * Test of contains method, of class MySet.
     */
    @Test
    public void testContains() {
        intSet.add(5);
        intSet.add(2);
        intSet.add(1);
        
        assertEquals(true, intSet.contains(1));
    }

    /**
     * Test of contains method, of class MySet.
     */
    @Test
    public void testContains2() {
        intSet.add(5);
        intSet.add(2);
        intSet.add(1);
        
        assertEquals(false, intSet.contains(9));
    }
    
    /**
     * Test of indexOf method, of class MySet.
     */
    @Test
    public void testIndexOf() {
        intSet.add(5);
        intSet.add(2);
        intSet.add(1);
        
        assertEquals(0, intSet.indexOf(1));
    }

    /**
     * Test of set method, of class MySet.
     */
    @Test
    public void testSet() {
        intSet.add(5);
        intSet.add(2);
        intSet.add(1);
        
        intSet.set(0, 3);
        assertEquals(3, intSet.get(0).intValue());
    }
    
}
