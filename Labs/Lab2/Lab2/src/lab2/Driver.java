package lab2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

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
        double[] numbers = {203.23, 50.2, 55.0, 9.0, 9.6, 2.5, 100.0, 76.5, 10.2, 60.9};

        System.out.println(DoubleStream.of(numbers).sum());
        System.out.println(DoubleStream.of(numbers).average());
        System.out.println(DoubleStream.of(numbers).max());
        System.out.println(DoubleStream.of(numbers).min());

        //Question 3.
        double[] numbers2 = {203.23, 50.2, 50.2, 9.0, 9.6, 2.5, 100.0, 76.5, 10.2, 60.9};
        System.out.println(DoubleStream.of(numbers2).distinct().count());
        System.out.println(Arrays.toString(DoubleStream.of(numbers2).distinct().sorted().toArray()));

        //Question 4.
        double[] scores = {70, 80, 50, 60, 77, 68, 90, 99};
        System.out.println(Arrays.toString(DoubleStream.of(scores).sorted().filter(e -> e >= DoubleStream.of(scores).average().getAsDouble()).toArray()));
        System.out.println(Arrays.toString(DoubleStream.of(scores).sorted().filter(e -> e <= DoubleStream.of(scores).average().getAsDouble()).toArray()));
        
        //Question 5.
        int number = 1234;
        
        System.out.println(IntStream.of(Integer.toString(number).chars().map(e -> e - '0').toArray()).sum());
    }

}
