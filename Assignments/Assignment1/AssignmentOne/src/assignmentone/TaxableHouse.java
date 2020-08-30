
package assignmentone;

/**
 * Class of taxable house's.
 * 
 * @author Alex Vasil
 */
public class TaxableHouse extends House implements Taxable {

    /**
     * House with given area, location, if its in a city, and the estimated
     * value.
     *
     * @param area The area of the house.
     * @param location Location of the house.
     * @param inCity If the house is in the city.
     * @param estimatedValue Estimated value of the house.
     */
    public TaxableHouse(double area, String location, boolean inCity, double estimatedValue) {
        super(area, location, inCity, estimatedValue);
    }
    
    /**
     * Calculates the value tax of the property.
     * 
     * @return Tax amount.
     */
    @Override
    public double valueTax() {
        if (inCity)
            return (estimatedValue / 1000) * 5 + 5 * area;
        else 
            return (estimatedValue / 1000) * 3;
    }
    
    /**
     * To string method of all data members with the House class.
     * 
     * @return A formatted string with all data members.
     */
    @Override
    public String toString() {
        String strOut = String.format("%s%.2f\n%s%s\n%s%b\n%s%.2f\n%s%.2f\n",
                "Area: ", area,
                "Location: ", location,
                "In City: ", inCity,
                "Estimated Value: ", estimatedValue,
                "Taxed Value: ", valueTax());
        return strOut;
    }
}
