package assignmentone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Alex Vasil
 */
public class Driver {

    public static void main(String[] args) {
        Taxable[] taxable = new Taxable[]{new TaxableHouse(10000, "Montreal, Quebec", true, 1000000),
            new TaxableHouse(1000, "Chambly, Quebec", true, 500000),
            new TaxableHouse(2000, "Mirabel, Quebec", true, 800000),
            new TaxableBus(100, 20542, 100, 20000),
            new TaxableBus(50, 22542, 60, 10000),
            new TaxableBus(30, 21542, 80, 5000)};

        for (Taxable tax : taxable) {
            System.out.println(tax.valueTax());
        }

        //Declaring ArrayList with 5 Points.
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(3, 2));
        points.add(new Point(2, 10));
        points.add(new Point(5, 22));
        points.add(new Point(6, 1));

        //Sorts based on Point x.
        Collections.sort(points);
        System.out.println("");
        System.out.println("Sort Based on x for ArrayList");
//        for (Point point : points)
//            System.out.println(point);
        points.forEach((point) -> {System.out.println(point);});
        

        //Sorts based on Point y.
        Collections.sort(points, new ComparatorPoints());
        System.out.println("");
        System.out.println("Sort Based on y for ArrayList");
//        for (Point point : points)
//            System.out.println(point);
        points.forEach((point) -> {System.out.println(point);});

        //Declaring Array with 5 Points.
        Point[] pointss = new Point[]{new Point(1, 2), new Point(2, 1), 
            new Point(10, 5), new Point(-5, -2), new Point(0, 0)};
        
        //Sorts based on Point x.
        Arrays.sort(pointss);
        System.out.println("");
        System.out.println("Sort Based on x for Point Array");
        for (Point point : pointss) 
            System.out.println(point);
        
        //Sorts based on Point y.
        Arrays.sort(pointss, new ComparatorPoints());
        System.out.println("");
        System.out.println("Sort Based on y for Point Array");
        for (Point point : pointss) 
            System.out.println(point);
    }
}
