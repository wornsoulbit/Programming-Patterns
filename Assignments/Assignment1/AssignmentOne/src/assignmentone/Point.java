package assignmentone;

/**
 * Class of a point x and y.
 * 
 * @author Alex Vasil
 */
public class Point implements Comparable<Point> {
    private int x;
    private int y;

    /**
     * Constructor for two points.
     * 
     * @param x x-point.
     * @param y y-point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Compares two points. 
     * 
     * @param o Other point being compared.
     * @return -1, 1, 0.
     */
    @Override
    public int compareTo(Point o) {
        if (this.x < o.x) {
            return -1;
        } else if (this.x > o.x) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
