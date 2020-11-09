package numbercounter;

/**
 *
 * @author Alex Vasil
 */
public class Driver {
    public static void main(String[] args) {
        NumberCounter counter = new NumberCounter();
        counter.countOccurances();
        counter.countMaxNum();
        counter.display();
    }
}
