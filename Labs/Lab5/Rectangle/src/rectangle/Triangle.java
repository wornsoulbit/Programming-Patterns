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
public class Triangle extends GeometricFigures {
    
    public Triangle(double width, double height) {
        super.width = width;
        super.height = height;
    }
    
    /**
     * Calculates the area of the triangle.
     * 
     * @return Area of the triangle.
     */
    @Override
    public double computeArea() {
        return (width / 2) * height;
    }
}
