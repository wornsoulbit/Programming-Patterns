package multithreading;

/**
 *
 * @author Alex Vasil
 */
public class Task implements Runnable {

    private int number = 7;

    public Task() {
        
    }

    public int subtractByOne() {
        return number--;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        while (number > 0) {
            subtractByOne();
            System.out.println(Thread.currentThread().getName() + " : " + number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
