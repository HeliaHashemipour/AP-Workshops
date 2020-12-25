import java.util.Objects;
/**
 * Rectangle class
 * @author Helia Sadat Hashemipour
 * @version 0.0
 */
public class Rectangle extends Polygon {
    public Rectangle(Integer...args) {
        super(args);
    }
    /**
     * check if rectangle is square
     * @return true or false
     */
    public boolean isSquare() {
        return getSides().get(0).equals(getSides().get(1)) && getSides().get(0).equals(getSides().get(2))
                && getSides().get(0).equals(getSides().get(3));
    }

    /**
     * calculate rectangle area
     * @return area
     */
    @Override
    public double calculateArea() {
        return getSides().get(0) * getSides().get(1);
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
     * @return boolean
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSides());
    }

}
