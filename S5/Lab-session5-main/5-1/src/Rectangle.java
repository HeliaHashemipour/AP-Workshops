/**
 * Rectangle class
 * @author Helia Hashemipour
 * @version 0.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Rectangle {
    private ArrayList<Integer> sides;

    /**
     * create a new rectangle
     * @param args sides of rectangle
     */
    public Rectangle(Integer... args) {
        sides = new ArrayList<>();
        sides.addAll(Arrays.asList(args));
    }

    /**
     * get sides
     * @return rectangle sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * check if rectangle is square
     * @return true or false
     */
    public boolean isSquare() {
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2)) && sides.get(0).equals(sides.get(3));
    }

    /**
     * calculate rectangle perimeter
     * @return perimeter
     */
    public int calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2) + sides.get(3);
    }

    /**
     * calculate rectangle area
     * @return area
     */
    public int calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    /**
     * draw rectangle
     */
    public void draw() {
        System.out.println("Rectangle => " + "Perimeter: " + calculatePerimeter() + " Area: " + calculateArea());
    }

    /**
     * @return string of rectangle info
     */
    @Override
    public String toString() {
        return "Rectangle" + " side1 = " + sides.get(0) + " side2 = " + sides.get(1) + " side3 = " + sides.get(2) +
                "side4 = " + sides.get(3);
    }

    /**
     * override equals method
     * @param o object to check the equality
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return getSides().equals(rectangle.getSides());
    }

    /**
     * override hashcode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSides());
    }
}