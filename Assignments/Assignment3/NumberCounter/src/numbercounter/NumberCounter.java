package numbercounter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Alex Vasil
 */
public class NumberCounter {
    private ArrayList<Integer> numberList;
    private ArrayList<Integer> maxList;
    private Map<Integer, Integer> numberMap;
    private Random rand;

    public NumberCounter() {
        rand = new Random();
        numberList = new ArrayList<>();
        int number = -1;
        while (number != 0) {
            number = rand.nextInt(20);
            numberList.add(number);
        }
    }
    
    public void countOccurances() {
        numberMap = new HashMap<>();
        for (int i = 0; i < numberList.size(); i++) {
            numberMap.computeIfPresent(numberList.get(i), (key, value) -> ++value);
            numberMap.computeIfAbsent(numberList.get(i), k -> 1);
        }
    }
    
    public void countMaxNum() {
        int num = Collections.max(numberMap.values());
        
        maxList = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
            int k = entry.getValue();
            if (k == num) {
                maxList.add(entry.getKey());
            }
        }
    }
    
    public void display() {
        System.out.println(numberList);
        System.out.println(maxList);
    }
}
