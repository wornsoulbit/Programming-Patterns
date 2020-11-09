
package division;

/**
 * Class for a Division.
 * 
 * @author Alex Vasil
 */
public class Division {
    
    protected String divName;
    protected int accNum;

    /**
     * Default constructor for a Division.
     * 
     * @param divName Name of the division.
     * @param accNum Account number of the division.
     */
    public Division(String divName, int accNum) {
        this.divName = divName;
        this.accNum = accNum;
    }
    
    /**
     * Displays the Name of the division and the Account number of the division.
     */
    public void display() {
        System.out.println("Division Name: " + divName);
        System.out.println("Account Number: " + accNum);
    }
}
