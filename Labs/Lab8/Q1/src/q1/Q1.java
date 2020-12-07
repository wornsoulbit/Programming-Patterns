
package q1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class of 1000 threads to do the simple task of adding 1, 1000 times with threads.
 * 
 * @author Alex Vasil
 */
public class Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creates a thread list with 1000 threads.
        Thread[] threadList = new Thread[1000];
        
        //Initializes the 1000 threads and starts a task to add one.
        for (int i = 0; i < 1000; i++) {
            threadList[i] = new Thread(new AddOneTask());
            threadList[i].start();
        }
        
        //Waits for the thread to be finished then it joins the threads together.
        for (int i = 0; i < 1000; i++) {
            while (threadList[i].isAlive()) {
                try {
                    threadList[i].join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("The sum is: " + AddOneTask.sum);
    }
    
}

/**
 * Class of a 1000 large thread pool to do the simple task of adding 1, 1000 times 
 * with threads.
 * 
 * @author Alex Vasil
 */
class Q1b {
    public static void main(String[] args) {
        //Spawns a thread pool of 1000 threads.
        ExecutorService executor = Executors.newFixedThreadPool(1000);

        //Iterates 1000 times of the task of adding one.
        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddOneTask());
        }
        
        //Shuts down when finished and all tasks are done on the thread pool.
        executor.shutdown();
        while (!executor.isTerminated()) {}

        System.out.println("The sum is : " + AddOneTask.sum);
    }
}

class AddOneTask implements Runnable {
    
    private static Lock lock = new ReentrantLock();
    static Integer sum = 0;
    
    //Using lock to make it thread safe.
    @Override
    public void run() {
        lock.lock();
        sum++;
        lock.unlock();
    }
}
