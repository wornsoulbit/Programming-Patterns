package vehicle;

/**
 * Class of a car.
 *
 * @author Alex Vasil
 */
public class Car extends Vehicle {
    
    /**
     * Constructor of a Car with 4 wheels and given, average miles per gallon.
     * 
     * @param averageMilesPerGallon average miles per gallon.
     */
    public Car(double averageMilesPerGallon) {
        super(4, averageMilesPerGallon);
    }

}
