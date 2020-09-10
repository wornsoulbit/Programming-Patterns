package horse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alex
 */
public class AppRunner {
    
    public static void main(String[] args) {
        Horse[] horseObjects = new Horse[5];
        horseObjects[0] = new Horse("Diamond", "White", 3);
        horseObjects[1] = new Horse("Jade", "Black", 5);
        horseObjects[2] = new RaceHorse("Crystal", "White", 0, 10);
        horseObjects[3] = new RaceHorse("Jake", "Brown", 0, 4);
        horseObjects[4] = new RaceHorse("James", "Light Brown", 0, 2);
        
        Arrays.sort(horseObjects, new SortHorseName());
        System.out.println(Arrays.toString(horseObjects));
        
        ArrayList<Horse> horseArrayList = new ArrayList<>();
        horseArrayList.add(new Horse("Diamond", "White", 10));
        horseArrayList.add(new Horse("Jade", "Black", 2));
        horseArrayList.add(new RaceHorse("Crystal", "White", 8, 10));
        horseArrayList.add(new RaceHorse("Jake", "Brown", 15, 4));
        horseArrayList.add(new RaceHorse("James", "Light Brown", 3, 2));

        horseArrayList.sort(new SortHorseAgeAsc());
        System.out.println(horseArrayList.toString());
        
        horseArrayList.sort(new SortHorseAgeAsc().reversed());
        System.out.println(horseArrayList.toString());
        
        String[] strings = {"Hello World", "this is a test of sorting strings", "by length", "woo."};
        
        Arrays.sort(strings, new SortStringLength());
        
        System.out.println(Arrays.toString(strings));
    }
}
