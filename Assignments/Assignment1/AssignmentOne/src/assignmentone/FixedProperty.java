package assignmentone;

/**
 * Class for fixed property such as House's etc...
 * 
 * @author Alex Vasil
 */
public class FixedProperty {

    protected String location;
    protected boolean inCity;
    protected double estimatedValue;

    /**
     * Takes the location, if its in the city, and the estimated value of the
     * property.
     *
     * @param location Location of the property.
     * @param inCity If the property is in the city.
     * @param estimatedValue Estimated value.
     */
    public FixedProperty(String location, boolean inCity, double estimatedValue) {
        this.location = location;
        this.inCity = inCity;
        this.estimatedValue = estimatedValue;
    }

    /**
     * Constructor with default values for if it's in the city, and the
     * estimated value with given location of the property.
     *
     * @param location Location of the property.
     */
    public FixedProperty(String location) {
        this.location = location;
        inCity = true;
        estimatedValue = 1000000;
    }

    /**
     * Getter for location of the house.
     *
     * @return Location of house.
     */
    public String getLocation() {
        return location;
    }
}
