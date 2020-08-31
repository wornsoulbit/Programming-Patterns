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
     * @param p Other point being compared.
     * @return 0 if equals, -1 if Point one is less than Point two, 1 if Point 
     * one is greater Point 2.
     */
    @Override
    public int compareTo(Point p) {
        if (this.x < p.x) {
            return -1;
        } else if (this.x > p.x) {
            return 1;
        } else {
            if (this.y < p.y) {
                return -1;
            } else if (this.y > p.y) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
