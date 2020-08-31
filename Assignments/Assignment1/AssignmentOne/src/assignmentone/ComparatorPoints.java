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
     * @return 0 if equals, -1 if Point one is less than Point two, 1 if Point 
     * one is greater Point 2.
     */
    @Override
    public int compare(Point o1, Point o2) {
        if (o1.getY() < o2.getY()) {
            return -1;
        } else if (o1.getY() > o2.getY()) {
            return 1;
        } else {
            if (o1.getX() < o2.getX()) {
                return -1;
            } else if (o1.getX() < o2.getX()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
}