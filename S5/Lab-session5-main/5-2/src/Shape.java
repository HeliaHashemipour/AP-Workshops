/**
 * Shape class
 * @author Helia Sadat Hashemipour
 * @version 0.0
 */
public abstract class Shape {
    /**
     * calculate perimeter
     * @return perimeter
     */
    public abstract double calculatePerimeter();

    /**
     * calculate area
     * @return area
     */
    public abstract double calculateArea();

    /**
     * draw shape
     */
    public void draw() {
        System.out.println("Shape is: " + getClass().getName() + " Perimeter: " + String.format("%.2f",calculatePerimeter())
                + " Area: " + String.format("%.2f",calculateArea()));
    }

    /**
     * @return string of shape information
     */
    @Override
    public abstract String toString();

    /**
     * @param o object to check equality
     * @return boolean
     */
    @Override
    public abstract boolean equals(Object o);

    /**
     * @return hashcode
     */
    @Override
    public abstract int hashCode();
}
