package vehicle;

/**
 *
 * @author Alex
 */
public class UseVehicule {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(3, 100);
        Vehicle v2 = new Vehicle(4, 150);

        System.out.println(v1.toString());
        System.out.println(v2.toString());
    }
}
