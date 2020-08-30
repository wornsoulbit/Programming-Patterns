package assignmentone;

/**
 * Class of a house.
 * 
 * @author Alex Vasil
 */
public class House extends FixedProperty {

    protected double area; //Area of the given house.

    /**
     * House with given area, location, if its in a city, and the estimated
     * value.
     *
     * @param area The area of the house.
     * @param location Location of the house.
     * @param inCity If the house is in the city.
     * @param estimatedValue Estimated value of the house.
     */
    public House(double area, String location, boolean inCity, double estimatedValue) {
        super(location, inCity, estimatedValue);
        this.area = area;
    }

    /**
     * Getter for area of the house.
     *
     * @return Area of the house.
     */
    public double getArea() {
        return area;
    }
}
