package vehicle;

/**
 * Class of a Vehicule.
 *
 * @author Alex Vasil
 */
public class Vehicle {

    private int numWheels;
    private double averageMilesPerGallon;

    /**
     * Vehicule with given number of wheels, and average miles per gallon.
     *
     * @param numWheels Number of wheels.
     * @param averageMilesPerGallon Average miles per gallon.
     */
    public Vehicle(int numWheels, double averageMilesPerGallon) {
        this.numWheels = numWheels;
        this.averageMilesPerGallon = averageMilesPerGallon;
    }

    /**
     * ToString method, returning number of wheels and average miles per gallon.
     *
     * @return A formatted string.
     */
    @Override
    public String toString() {
        String strOut = String.format("%s %d\n", "Number of Wheels:", numWheels);
        strOut += String.format("%s %.2f\n", "Average miles per gallon:", averageMilesPerGallon);
        return strOut;
    }

}
