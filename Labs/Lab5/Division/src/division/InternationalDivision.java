
package division;

/**
 * Class of an International Division.
 * 
 * @author Alex Vasil
 */
public class InternationalDivision extends Division {
    protected String country;
    protected String language;

    /**
     * Default constructor for International Division.
     * 
     * @param country Country of the division.
     * @param language Language of the division.
     * @param divName Name of the division.
     * @param accNum Account number of the division.
     */
    public InternationalDivision(String country, String language, String divName, int accNum) {
        super(divName, accNum);
        this.country = country;
        this.language = language;
    }
    
    /**
     * Displays the Division Name, Account Number, Country of the division and
     * Language of the division.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Country: " + country);
        System.out.println("Language: " + language);
    }
}
