/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangle;

/**
 *
 * @author Alex Vasil
 */
public class Driver {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(20, 10);
        Square square = new Square(5);
        Square rectSquare = new Square(10, 20);
        Triangle trig = new Triangle(30, 10);
        
        displayOne(square);
        displayOne(rect);
        displayOne(rectSquare);
        displayOne(trig);
    }
    
    public static void displayOne(GeometricFigures figure) {
        System.out.println("Displaying a " + figure.getClass());
        System.out.println("Height: " + figure.height);
        System.out.println("Width : " + figure.width);
        System.out.println("Area  : " + figure.computeArea());
    }
}
