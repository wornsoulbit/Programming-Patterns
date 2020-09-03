package lab2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alex Vasil
 */
public class Driver {

    public static void main(String[] args) {
        //Question 1.
        List<Student> students = Arrays.asList(new Student("David Pack", 99.9), 
                new Student("Nick", 80.1), new Student("James Ling", 60.5), 
                new Student("Alexis", 75.2), new Student("Elizabeth", 90.4));
        
        students.stream().sorted((s1, s2) -> (int) (s2.getGrade() - s1.getGrade())).forEach(System.out::println);
        
        //Question 2.
        Double[] numbers = new Double[]{203.23, 50.2, 55.0, 9.0, 9.6, 2.5, 100.0, 76.5, 10.2, 60.9};
        
        System.out.println(NumberParser.print(numbers));
        
        //Question 3.
        NumReader num = new NumReader();
        
        num.numParse();
        System.out.println(num.toString());
        
    }
    
}
