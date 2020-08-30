package assignmentone;

/**
 *
 * @author Alex Vasil
 */
public class Driver {
    
    public static void main(String[] args) {
        Taxable[] taxable = new Taxable[]{new TaxableHouse(10000, "Montreal, Quebec", true, 1000000), 
            new TaxableHouse(1000, "Chambly, Quebec", true, 500000), 
            new TaxableHouse(2000, "Mirabel, Quebec", true, 800000),
            new TaxableBus(100, 20542, 100, 20000),
            new TaxableBus(50, 22542, 60, 10000),
            new TaxableBus(30, 21542, 80, 5000)};
        
        for (Taxable tax : taxable) {
            System.out.println(tax.valueTax());
        }
    }
}
