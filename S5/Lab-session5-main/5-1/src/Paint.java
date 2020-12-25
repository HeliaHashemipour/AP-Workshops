/**
 * Paint class
 * @author Helia Hashemipour
 * @version 0.0
 */

import java.util.ArrayList;

public class Paint {
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    /**
     * create a new paint
     */
    public Paint() {
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * add circle to paint
     * @param circle circle to add
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * add triangle to paint
     * @param triangle triangle to add
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * add rectangle to paint
     * @param rectangle rectangle to add
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * draw all the shapes
     */
    public void drawAll() {
        for (Circle circle : circles)
            circle.draw();
        for (Triangle triangle : triangles)
            triangle.draw();
        for (Rectangle rectangle : rectangles)
            rectangle.draw();
    }

    /**
     * print all the shapes
     */
    public void printAll() {
        for (Circle circle : circles)
            System.out.println(circle);
        for (Triangle triangle : triangles)
            System.out.println(triangle);
        for (Rectangle rectangle : rectangles)
            System.out.println(rectangle);
    }
}
