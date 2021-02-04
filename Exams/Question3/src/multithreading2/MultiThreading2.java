package multithreading2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alex Vasil
 */
public class MultiThreading2 implements Runnable{
    
    int min, max;
    static Map<Integer, Integer> intMap = new HashMap<>();
    
    public MultiThreading2(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Part A: Done with one thread.
        System.out.println("Part A:");
        System.out.println("Alex is starting DivisorsDemo");
        Thread t0 = new Thread(new MultiThreading2(1000, 20000));
        
        t0.start();
        
        try {
            while (t0.isAlive()) { t0.join(); }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("The Map result is" + intMap.toString());
        System.out.println(largestInMap());
        
        //Part B: Done with 4 Threads
        System.out.println("\nPart B:");
        System.out.println("Alex is starting DivisorsDemo");
        t0 = new Thread(new MultiThreading2(1000, 5000));
        Thread t1 = new Thread(new MultiThreading2(5001, 10000));
        Thread t2 = new Thread(new MultiThreading2(10001, 15000));
        Thread t3 = new Thread(new MultiThreading2(15001, 20000));
        
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        
        try {
            while (t0.isAlive()) { t0.join(); }
            while (t1.isAlive()) { t1.join(); }
            while (t2.isAlive()) { t2.join(); }
            while (t3.isAlive()) { t3.join(); }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("The Map result is" + intMap.toString());
        System.out.println(largestInMap());
        
        //Part C: Done with a Thread Pool.
        System.out.println("\nPart C:");
        System.out.println("Alex is starting DivisorsDemo");
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(new MultiThreading2(1000, 5000));
        executor.execute(new MultiThreading2(5001, 10000));
        executor.execute(new MultiThreading2(10001, 15000));
        executor.execute(new MultiThreading2(15001, 20000));
        
        executor.shutdown();
        
        while (!executor.isTerminated()) {
            
        }
        System.out.println("The Map result is" + intMap.toString());
        System.out.println(largestInMap());
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
    public synchronized void addToMap(int number) {
        intMap.put(number, countDivisors(number));
    }
    
    /**
     * Gets the number of times a number can be divided.
     * 
     * @param n Number to be checked how many times it can be divided.
     * @return How many times that number can be divided.
     */
    int countDivisors(int n) {
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
    
    @Override
    public void run() {
        int num = countAllDivisors(min, max);
        System.out.println(Thread.currentThread().getName() + " : " + num);
        addToMap(num);
    }

}
