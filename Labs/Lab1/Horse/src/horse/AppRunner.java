package horse;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class AppRunner {
    
    public static void main(String[] args) {
        Horse[] horseObjects = new Horse[5];
        horseObjects[0] = new Horse("Diamond", "White", 0);
        horseObjects[1] = new Horse("Jade", "Black", 0);
        horseObjects[2] = new RaceHorse("Crystal", "White", 0, 10);
        horseObjects[3] = new RaceHorse("Jake", "Brown", 0, 4);
        horseObjects[4] = new RaceHorse("James", "Light Brown", 0, 2);
        
        ArrayList<Horse> horseArrayList = new ArrayList<>();
        horseArrayList.add(new Horse("Diamond", "White", 0));
        horseArrayList.add(new Horse("Jade", "Black", 0));
        horseArrayList.add(new RaceHorse("Crystal", "White", 0, 10));
        horseArrayList.add(new RaceHorse("Jake", "Brown", 0, 4));
        horseArrayList.add(new RaceHorse("James", "Light Brown", 0, 2));
    }
}
