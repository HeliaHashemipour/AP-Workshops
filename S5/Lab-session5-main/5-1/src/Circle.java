/**
 * Circle class
 * @author Helia Hashemipour
 * @version 0.0
 */

import java.util.Objects;

public class Circle {
    private double radius;

    /**
     * create a new circle with a given radius
     * @param radius circle radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * get radius
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * calculate circle perimeter
     * @return perimeter
     */
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }

    /**
     * calculate circle area
     * @return area
     */
    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    /**
     * draw circle
     */
    public void draw() {
        System.out.println("Circle => "+ "Perimeter: " + String.format("%.2f",calculatePerimeter())
                + " Area: " + String.format("%.2f",calculateArea()));
    }

    /**
     * override toString method
     * @return string of triangle info
     */

    @Override
    public String toString() {
        return "Circle => " + "radius = " + radius;
    }

    /**
     * override equals method
     * @param o object to check the equality
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Circle))
            return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }
    /**
     * override hashCode method
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}
