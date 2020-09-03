package assignmentone;

/**
 * Class for any type of vehicle.
 * 
 * @author Alex Vasil
 */
public abstract class Vehicle {

    protected int registrationNum;
    protected double maxVelocity;
    protected double value;

    /**
     * Takes a registration number, the max velocity, and the value of the
     * vehicle.
     *
     * @param registrationNum Registration number.
     * @param maxVelocity Max velocity of the vehicle.
     * @param value Value of the vehicle.
     */
    public Vehicle(int registrationNum, double maxVelocity, double value) {
        this.registrationNum = registrationNum;
        this.maxVelocity = maxVelocity;
        this.value = value;
    }

    /**
     * Getter for registration number.
     *
     * @return Registration number.
     */
    public int getRegistrationNum() {
        return registrationNum;
    }
}
