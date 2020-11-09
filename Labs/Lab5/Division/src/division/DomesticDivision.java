
package division;

/**
 * Class of a Domestic Division.
 * 
 * @author Alex Vasil
 */
public class DomesticDivision extends Division {
    protected String state;
    protected int value;

    /**
     * Default constructor for a Domestic Division.
     * 
     * @param state State of the division.
     * @param value Value of the division.
     * @param divName Name of the division.
     * @param accNum Account number of the division.
     */
    public DomesticDivision(String state, int value, String divName, int accNum) {
        super(divName, accNum);
        this.state = state;
        this.value = value;
    }

    /**
     * Displays the Division Name, Account Number, State of the division and
     * Value of the division.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("State: " + state);
        System.out.println("value: " + value);
    }
}
