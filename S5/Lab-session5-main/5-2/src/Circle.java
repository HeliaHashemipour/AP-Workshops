import java.util.Objects;
/**
 * Circle class
 * @author Helia Sadat Hashemipour
 * @version 0.0
 */
public class Circle extends Shape {
    private int radius;
    /**
     * create a new circle with a given radius
     * @param radius circle radius
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * get radius
     * @return radius
     */
    public int getRadius() {
        return radius;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }
    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }
    @Override
    public String toString() {
        return "Shape is: " +  getClass().getName() + "  radius = " + radius ;
    }
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
     * @return boolean
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}
