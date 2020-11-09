package assignment3;

/**
 *
 * @author Alex Vasil
 */
public class Driver {
    public static void main(String[] args) {
        AntonymMap.addAntonym("Big", "Small");
        AntonymMap.addAntonym("Tall", "Wide");
        AntonymMap.addAntonym("Smart", "Stupid");
        AntonymMap.printMap();
        AntonymMap.find("Small");
        AntonymMap.find("Stupid");
        AntonymMap.printMap();
    }
}
