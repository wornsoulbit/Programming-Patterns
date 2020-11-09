
package rectangle;

/**
 * Class of a square.
 * 
 * @author Alex Vasil
 */
public class Square extends Rectangle {
    
    /**
     * Constructor of a square, always takes the largest of the two for both values.
     * 
     * @param width Width of the square.
     * @param height Height of the square.
     */
    public Square(double width, double height) {
        super(width, height);
        
        if (width > height) {
            super.width = width;
            super.height = width;
        } else {
            super.width = height;
            super.height = height;
        }
    }
    
    /**
     * Constructor of a square with one given side.
     * 
     * @param width Width of the square.
     */
    public Square(double width) {
        super(width, width);
    }

    /**
     * Calculates the area of the Square.
     * 
     * @return Area of the square.
     */
    @Override
    public double computeArea() {
        return super.computeArea();
    }
}
