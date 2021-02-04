package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class for calculating primes with and without multi-threading.
 * 
 * @author Alex Vasil
 */
public class MultiThreading implements Runnable {

    static int total = 0;
    int count = 0;
    int min, max;
    
    /**
     * Constructor that takes a min and a max number.
     * 
     * @param min The lowest number.
     * @param max The highest number.
     */
    public MultiThreading(int min, int max) {
        this.max = max;
        this.min = min;
    }
    
    /**
     * Runs when a thread runs. Printing out the thread name, the number of 
     * prime numbers there are between the min and max numbers in that thread.
     */
    @Override
    public void run() {
        count = countAllPrimes(min, max);
        System.out.println(Thread.currentThread().getName() + "--->There are " +
                count + " prime number between " + min + " and " + max);
        addToTotal(count);
    }
    
    /**
     * Counts the number of primes between the min and max.
     * 
     * @param min The lowest number.
     * @param max The highest number.
     * @return The number of primes between the range.
     */
    private int countAllPrimes(int min, int max) {
        int primeNumberCount = 0;
        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {
                primeNumberCount++;
            }
        }
        
        return primeNumberCount;
    }
    
    /**
     * Thread safe prime number counter.
     * 
     * @param x Number of primes to add.
     */
    synchronized private void addToTotal(int x) {
        total += x;
        System.out.println(total + " primes found so far");
    }
    
    /**
     * Checks to see if a number is prime or not.
     * 
     * @param x Number to be checked if it's a prime number.
     * @return If a given number is a prime number.
     */
    public static boolean isPrime(int x) {
        int top = (int) Math.sqrt(x);
        for (int i = 2; i <= top; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        //Part A: --------------------------------------------------------------
//        
//        System.out.println("Part A: \n");
//        
//        //Gets processors available.
//        int processors = Runtime.getRuntime().availableProcessors();
//        
//        //Starts a timer.
//        long startTime = System.currentTimeMillis();
//        int localTotal = 0;
//        
//        for (int i = 2000000; i <= 6000000; i++) {
//            if (isPrime(i)) {
//                localTotal++;
//            }
//        }
//        
//        //Calculates the total time it took to calculate primes between 2,000,000 - 6,000,000
//        long elaspedTime = System.currentTimeMillis() - startTime;
//        
//        System.out.println("Processors: " + processors);
//        System.out.println("Elapsed Time: " + elaspedTime + 
//                "\tPrime Numbers (from 2,000,000-6,000,000): " + localTotal);
//        
//        //Part B: ------------------------------------------------------------
//        
//        System.out.println("Part B: \n");
//        
//        //Starts a timer.
//        long startTime1 = System.currentTimeMillis();
//        
//        //Spawns 4 threads to calculate primes, dividing the tasks between them.
//        Thread t0 = new Thread(new MultiThreading(2000000, 3000000));
//        Thread t1 = new Thread(new MultiThreading(3000001, 4000000));
//        Thread t2 = new Thread(new MultiThreading(4000001, 5000000));
//        Thread t3 = new Thread(new MultiThreading(5000001, 6000000));
//        
//        //Starts the threads.
//        t0.start();
//        t1.start();
//        t2.start();
//        t3.start();
//        
//        //Looks to see when a thread is done then moves onto the next one.
//        try {
//            while (t0.isAlive()) t0.join();
//            while (t1.isAlive()) t1.join();
//            while (t2.isAlive()) t2.join();
//            while (t3.isAlive()) t3.join();
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//        
//        //Calculates the total time it took to calculate primes between 2,000,000 - 6,000,000
//        long elaspedTime1 = System.currentTimeMillis() - startTime1;
//        
//        System.out.println("Total number with Join(): " + MultiThreading.total);
//        System.out.println("\nTotal time elapsed time: " + (elaspedTime1/1000.0) + " seconds.\n");
//        
//        //Part C: ---------------------------------------------------------------
//        
//        System.out.println("\nPart C:\n");
//        
//        //Starts a thread pool of 4 threads.
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        //Resets the total counter to 0.
//        total = 0;
//        
//        //Starts a timer.
//        long startTime2 = System.currentTimeMillis();
//        
//        //Executes the task of calculating the prime numbers.
//        executor.execute(new MultiThreading(2000000, 3000000));
//        executor.execute(new MultiThreading(3000001, 4000000));
//        executor.execute(new MultiThreading(4000001, 5000000));
//        executor.execute(new MultiThreading(5000001, 6000000));
//        
//        //Turns the thread pool off.
//        executor.shutdown();
//        
//        while (!executor.isTerminated()) {
//            
//        }
//        
//        //Calculates the total time it took to calculate primes between 2,000,000 - 6,000,000
//        long elaspedTime2 = System.currentTimeMillis() - startTime2;
//        System.out.println("Total primes using executor " + MultiThreading.total);
//        System.out.println("\nTotal elapsed: " + (elaspedTime2/1000.0) + " seconds.\n");
    }
}