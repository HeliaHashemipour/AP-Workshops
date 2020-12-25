/**
 * Paint class
 * @author Helia Sadat Hashemipour
 * @version 0.0
 */
import java.util.ArrayList;

public class Paint {

    ArrayList<Shape> shapes;

    /**
     * create a new paint
     */
    public Paint() {
        shapes = new ArrayList<>();
    }

    /**
     * add shape to paint
     * @param shape shape to add
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * draw all the shapes
     */
    public void drawAll() {
        for (Shape shape : shapes)
            shape.draw();
    }

    /**
     * print all the shapes
     */
    public void printAll() {
        for (Shape shape : shapes)
            System.out.println(shape.toString());
    }

    /**
     * print square and equilateral
     */
    public void describeEqualSides() {
        for (Shape shape : shapes) {
            if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                if (triangle.isEquilateral())
                    System.out.println(triangle.toString());
            }
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                if (rectangle.isSquare())
                    System.out.println(rectangle.toString());
            }
        }
    }
}
