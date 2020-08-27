package vehicle;

/**
 * Class of a MotorCycle
 *
 * @author Alex Vasil
 */
public class MotorCycle extends Vehicle {

    /**
     * Constructor of a motorcycle with 2 wheels and given, average miles per gallon.
     * 
     * @param averageMilesPerGallon average miles per gallon.
     */
    public MotorCycle(double averageMilesPerGallon) {
        super(2, averageMilesPerGallon);
    }
}
