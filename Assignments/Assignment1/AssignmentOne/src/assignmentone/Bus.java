package assignmentone;

/**
 * Class of a bus.
 * 
 * @author Alex Vasil
 */
public class Bus extends Vehicle {

    protected int numSeats; //number of seats on the bus.

    /**
     * Bus with given number of seats, registration number, max velocity and
     * it's value.
     *
     * @param numSeats Number of seats in the bus.
     * @param registrationNum Registration number of the bus.
     * @param maxVelocity Max velocity of the bus.
     * @param value Value of the bus.
     */
    public Bus(int numSeats, int registrationNum, double maxVelocity, double value) {
        super(registrationNum, maxVelocity, value);
        this.numSeats = numSeats;
    }

    /**
     * Getter for number of seats on the bus.
     *
     * @return Number of seats.
     */
    public int getNumSeats() {
        return numSeats;
    }
}
