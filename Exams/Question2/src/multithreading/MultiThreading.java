package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alex Vasil
 */
public class MultiThreading {

    Task task = new Task();
    int number = -1;

    public static void main(String[] args) {
        //Part A:
        System.out.println("Part A: Done by a Task class");
        Thread t0 = new Thread(new Task());
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        Thread t3 = new Thread(new Task());
        Thread t4 = new Thread(new Task());

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            while (t0.isAlive()) { t0.join(); }
            while (t1.isAlive()) { t1.join(); }
            while (t2.isAlive()) { t2.join(); }
            while (t3.isAlive()) { t3.join(); }
            while (t4.isAlive()) { t4.join(); }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Countdown terminated by all\n");

        //Part B:
        System.out.println("Part B: Task done by Lambda expression");
        
        //<editor-fold defaultstate="collapsed" desc="Threads done with Lamda Expression">
        t0 = new Thread(() -> {
            int i = 7;
            while (i > 0) {
                i--;
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        t1 = new Thread(() -> {
            int i = 7;
            while (i > 0) {
                i--;
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        t2 = new Thread(() -> {
            int i = 7;
            while (i > 0) {
                i--;
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        t3 = new Thread(() -> {
            int i = 7;
            while (i > 0) {
                i--;
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        t4 = new Thread(() -> {
            int i = 7;
            while (i > 0) {
                i--;
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
//</editor-fold>
        
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            while (t0.isAlive()) { t0.join(); }
            while (t1.isAlive()) { t1.join(); }
            while (t2.isAlive()) { t2.join(); }
            while (t3.isAlive()) { t3.join(); }
            while (t4.isAlive()) { t4.join(); }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Countdown terminated by all\n");
        
        //Part C:
        System.out.println("Part C: Thread Pools");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        executor.execute(new Task());
        executor.execute(new Task());
        executor.execute(new Task());
        executor.execute(new Task());
        executor.execute(new Task());
        
        executor.shutdown();
        
        while (!executor.isTerminated()) {
            
        }
        
        System.out.println("Countdown terminated by all\n");
    }
}
