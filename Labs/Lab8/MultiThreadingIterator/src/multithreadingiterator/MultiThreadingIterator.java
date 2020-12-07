
package multithreadingiterator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Alex Vasil
 */
public class MultiThreadingIterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set hash = Collections.synchronizedSet(new HashSet());
        
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("Thread 1");
                hash.add(new Integer(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        
        new Thread(() -> {
           while (true) {
               System.out.println("Thread 2");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException ex) {
                   ex.printStackTrace();
               }
               
               synchronized (hash) {
                   Iterator iterator = hash.iterator();
                   
                   while (iterator.hasNext()) {
                       System.out.println(iterator.next());
                   }
               }
           } 
        }).start();
    }
    
}
