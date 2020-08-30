/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone;

import java.util.Comparator;

/**
 * Comparator for the Point class.
 * 
 * @author Alex Vasil
 */
public class ComparatorPoints implements Comparator<Point> { 

    /**
     * Comparable interface for comparing two points.
     * 
     * @param o1 Point 1.
     * @param o2 Point 2.
     * @return 
     */
    @Override
    public int compare(Point o1, Point o2) {
        return o1.getY() - o2.getY();
    }
    
}