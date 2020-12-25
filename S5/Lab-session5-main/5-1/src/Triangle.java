import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
/**
 * Triangle class
 * @author Helia Hashemipour
 * @version 0.0
 */

public class Triangle {
    private ArrayList<Integer> sides;

    /**
     * create a new triangle
     * @param args sides of triangle
     */
    public Triangle(Integer...args) {
        sides = new ArrayList<>();
        sides.addAll(Arrays.asList(args));
    }

    /**
     * get sides
     * @return triangle sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * check if triangle equilateral
     * @return boolean
     */
    public boolean isEquilateral() {
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2));
    }

    /**
     * calculate triangle perimeter
     * @return perimeter
     */
    public int calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    /**
     * calculate triangle area
     * @return area
     */
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
    }

    /**
     * draw triangle
     */
    public void draw() {
        System.out.println("Triangle => "+ "Perimeter: " + calculatePerimeter() + " Area: " +
                String.format("%.2f",calculateArea()));
    }

    /**
     * override toString method
     * @return string of triangle info
     */
    @Override
    public String toString() {
        return "Triangle" + " side1 = " + sides.get(0) + " side2 = " + sides.get(1) + " side3 = " + sides.get(2);
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
        if (!(o instanceof Triangle))
            return false;
        Triangle triangle = (Triangle) o;
        return getSides().equals(triangle.getSides());
    }

    /**
     * override hashCode method
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSides());
    }
}
