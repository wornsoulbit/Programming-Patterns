package assignmentone;

/**
 * Class of taxable buses.
 * 
 * @author Alex Vasil
 */
public class TaxableBus extends Bus implements Taxable {

    /**
     * Bus with given number of seats, registration number, max velocity and
     * it's value.
     *
     * @param numSeats Number of seats in the bus.
     * @param registrationNum Registration number of the bus.
     * @param maxVelocity Max velocity of the bus.
     * @param value Value of the bus.
     */
    public TaxableBus(int numSeats, int registrationNum, double maxVelocity, double value) {
        super(numSeats, registrationNum, maxVelocity, value);
    }

    /**
     * Calculates the value tax of the vehicle.
     *
     * @return Tax amount.
     */
    @Override
    public double valueTax() {
        return value / 10 + 100 * numSeats;
    }
    
    /**
     * To string method of all data members in the Vehicle class.
     * 
     * @return A formatted string of all data members.
     */
    @Override
    public String toString() {
        String strOut = String.format("%s%d\n%s%d\n%s%.2f\n%s%.2f\n%s%.2f\n",
                "Number of Seats: ", numSeats,
                "Registration Number: ", registrationNum,
                "Max Velocity: ", maxVelocity,
                "Value: ", value,
                "Taxed Value: ", valueTax());
        return strOut;
    }
}
