import java.util.ArrayList;
import java.util.Arrays;

/**
 * Polygon class super class of rectangle and triangle classes
 *
 * @author Helia Sadat Hashemipour
 * @version 0.0
 */
public abstract class Polygon extends Shape {
    //side of shapes
    private ArrayList<Integer> sides;
    //the index
    int i = 1;

    /**
     * create a new polygon
     *
     * @param args sides of polygon
     */
    public Polygon(Integer... args) {
        sides = new ArrayList<>();
        sides.addAll(Arrays.asList(args));
    }

    /**
     * get sides
     *
     * @return polygon sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * calculate perimeter
     *
     * @return polygon perimeter
     */
    @Override
    public double calculatePerimeter() {
        int p = 0;
        for (Integer side : sides)
            p += side;
        return p;
    }

    /**
     * this method returns the value of index
     * @return i
     */
    public int getNumber() {
        return i++;

    }

    /**
     * calculate area
     *
     * @return polygon area
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{ ");
        for (Integer side : sides)
            res.append("side" + getNumber() + ":" + side).append("  ");
        res.append("}");
        return "Shape is: " + getClass().getName() +" "+ res;
    }
}
