package lab2;

/**
 *
 * @author Alex Vasil
 */
public class NumberParser {
    
    public static double sum(Double... numbers) {
        double sum = 0;
        
        for (Double number : numbers) 
            sum += number;
        
        return sum;
    }
    
    public static double average(Double... numbers) {
        double avg = 0;
        
        for (Double number : numbers)
            avg += number;
        
        avg = avg / numbers.length;
        
        return avg;
    }
    
    public static double min(Double... numbers) {
        double min = numbers[numbers.length - 1];
        
        for (Double number : numbers) 
            if (number < min) 
                min = number;
        
        return min;
    }
    
    public static double max(Double... numbers) {
        double max = numbers[numbers.length - 1];
        
        for (Double number : numbers) 
            if (number > max)
                max = number;
        
        return max;
    }
    
    public static String print(Double... numbers) {
        String strOut = String.format("Sum: %.2f\n", sum(numbers));
        strOut += String.format("Average: %.2f\n", average(numbers));
        strOut += String.format("Max: %.2f\n", max(numbers));
        strOut += String.format("Min: %.2f\n", min(numbers));
        
        return strOut;
    }
    
}
