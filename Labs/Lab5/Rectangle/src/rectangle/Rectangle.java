
package rectangle;

/**
 * Class of a Rectangle.
 * 
 * @author Alex Vasil
 */
public class Rectangle extends GeometricFigures {
    
    /**
     * Constructor of a rectangle with height and width.
     * 
     * @param width Width of the rectangle.
     * @param height Height of the rectangle.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    /**
     * Calculates the area of this rectangle.
     * 
     * @return Area of this rectangle.
     */
    @Override
    public double computeArea() {
        return width * height;
    }
}
