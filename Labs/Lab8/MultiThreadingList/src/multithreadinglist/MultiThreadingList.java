
package multithreadinglist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alex Vasil
 */
public class MultiThreadingList {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        //Integer array to be made into a synchronizedList later.
        Integer[] numberArray = {3, 5, 7, 10, 13, 18, 27, 30, 33, 35, 40, 55};
        //Creates the synchronized list for thread safe application.
        List<Integer> numberList = Collections.synchronizedList(new LinkedList(Arrays.asList(numberArray)));
        
        //Prints out the original list before any modifications.
        System.out.println("Original List: " + numberList);
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        //Changes any even numbers to be the number divided by two.
        //Then prints out the modified list.
        executorService.execute(() -> {
            for (int i = 0; i < numberList.size(); i++) {
                if (i % 2 == 0) {
                    numberList.set(i, numberList.get(i) / 2);
                }
            }
            System.out.println(Thread.currentThread().getName() + "--> The list after Multiplying " + numberList);
        });
        
        //Changes any odd numbers to be the number mulitplied by two.
        //Then prints out the modified list.
        executorService.execute(() -> {
            for (int i = 0; i < numberList.size(); i++) {
                if (i % 2 != 0) {
                    numberList.set(i, numberList.get(i) * 2);
                }
            }
            System.out.println(Thread.currentThread().getName() + "--> The list after Dividing " + numberList);
        });
        
        //Closes the thread pool.
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            
        }
    }
}
