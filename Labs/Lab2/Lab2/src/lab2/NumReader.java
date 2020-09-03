package lab2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Reads x amount of numbers and displays any distinct numbers and sorts them.
 *
 * @author Alex Vasil
 */
public class NumReader {

    private int numLimit = 10;
    private int counter = 0;
    private Scanner console = new Scanner(System.in);
    private Double[] numbers = new Double[numLimit];

    public void numParse() {
        while (counter != numLimit) {
            System.out.println("Input a number: ");
            numbers[counter] = console.nextDouble();
            counter++;
        }
    }

    public int uniqueNums() {
        HashSet<Double> numbers = new HashSet();
        numbers.addAll(Arrays.asList(this.numbers));
        return numbers.size();
    }

    public void printUniqueNums() {
        HashSet<Double> numbers = new HashSet();
        Arrays.sort(this.numbers);
        numbers.addAll(Arrays.asList(this.numbers));
        numbers.forEach((number) -> { System.out.print(number + " "); });
    }
    
    @Override
    public String toString() {
        String strOut = String.format("Number of unique numbers: %d\n", uniqueNums());
        strOut += "Numbers: ";
        printUniqueNums();
        return strOut;
    }
}
