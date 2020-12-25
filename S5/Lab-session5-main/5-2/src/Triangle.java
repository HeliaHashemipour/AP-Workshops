import java.util.Objects;
/**
 * Triangle class
 * @author Helia Sadat Hashemipour
 * @version 0.0
 */
public class Triangle extends Polygon {
    /**
     * create a new triangle
     * @param args sides of triangle
     */
    public Triangle(Integer...args) {
        super(args);
    }

    /**
     * check if triangle
     * @return true/false
     */
    public boolean isEquilateral() {
        return getSides().get(0).equals(getSides().get(1)) && getSides().get(0).equals(getSides().get(2));
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2.0;
        return Math.sqrt(p * (p - getSides().get(0)) * (p - getSides().get(1)) * (p - getSides().get(2)));
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
     * @return boolean
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSides());
    }
}
