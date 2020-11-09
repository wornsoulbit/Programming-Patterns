package division;

/**
 *
 * @author Alex Vasil
 */
public class UseDivision {

    public static void main(String[] args) {
        InternationalDivision company1 = new InternationalDivision("Cannuk", "EN-CA", "Cannuks", 1005);
        DomesticDivision company2 = new DomesticDivision("New York", 500, "Rangers", 1010);

        company1.display();
        company2.display();
    }
}
