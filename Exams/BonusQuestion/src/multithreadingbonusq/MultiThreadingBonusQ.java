
package multithreadingbonusq;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Alex Vasil
 */
public class MultiThreadingBonusQ extends RecursiveTask<Integer>{
    int min, max;
    static Map<Integer, Integer> intMap = new HashMap<>();

    public MultiThreadingBonusQ(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        int num = fjp.invoke(new MultiThreadingBonusQ(1000, 5000));
        addToMap(num);
        num = fjp.invoke(new MultiThreadingBonusQ(5001, 10000));
        addToMap(num);
        num = fjp.invoke(new MultiThreadingBonusQ(10001, 15000));
        addToMap(num);
        num = fjp.invoke(new MultiThreadingBonusQ(15001, 20000));
        addToMap(num);
        System.out.println("The Map result is" + intMap.toString());
        System.out.println(largestInMap());
    }
    
    @Override
    protected Integer compute() {
        return countAllDivisors(min, max);
    }
    
    /**
     * Gets the largest value and key in the back and returns a string.
     * 
     * @return String with the largest value and key in the map.
     */
    public static String largestInMap() {
        return Collections.max(intMap.keySet()) + " has the maximum number of " + Collections.max(intMap.values());
    }
    
    /**
     * Thread safe adding numbers to the map.
     * 
     * @param number Largest number from countDivisors to be added.
     */
    public static void addToMap(int number) {
        intMap.put(number, countDivisors(number));
    }
    
    /**
     * Gets the number of times a number can be divided.
     * 
     * @param n Number to be checked how many times it can be divided.
     * @return How many times that number can be divided.
     */
    static int countDivisors(int n) {
        int divisorCount = 0;

        for (int d = 1; d <= n; d++) {  // Count the divisors of n.
            if (n % d == 0) {
                divisorCount++;
            }
        }
        
        return divisorCount;
    }

    /**
     * Counts the number of times a number can be divided in a range and returns
     * the largest in the range of min, max.
     * 
     * @param min The lowest number in the range.
     * @param max The highest number in the range.
     * @return The number that can be divided the most.
     */
    public int countAllDivisors(int min, int max) {
        int num = -1;
        int temp;
        int biggestNumber = -1;
        for (int i = min; i <= max; i++) {
            temp = countDivisors(i);
            if (temp > num) {
                num = temp;
                biggestNumber = i;
            }
        }
        
        return biggestNumber;
    }
}