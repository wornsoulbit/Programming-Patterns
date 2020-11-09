package lab4part1;

/**
 *
 * @author Alex Vasil
 */
public class IsPrime {

    /**
     * Checks if the given number is prime.
     * 
     * @param num Number to check if it's prime
     * @return If the number is a prime number.
     */
    public static boolean isPrime(int num) { //44
        if (num == 0 || num == 1) 
            return false;
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) 
                return false;
        }
        return true;
    }

    
}
