package esi.atl.g53204.AsciiPaint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul
 */
public class Drawing {

    private List<Shape> shapes;
    private int height;
    private int width;

    /**
     * constructor by defaut of our class Drawing
     */
    public Drawing() {
        // APA : Pourquoi arrayList ? 
        this(new ArrayList<>(), 100, 100);
    }

    /**
     * constructor of our class Drawing
     *
     * @param shapes is a list of Shapes
     * @param height is the height of our drawing
     * @param width is the width of our drawing
     */
    public Drawing(List<Shape> shapes, int height, int width) {
        this.shapes = shapes;
        this.height = height;
        this.width = width;
    }

    /**
     * get the list of shapes
     *
     * @return the list of shapes
     */
    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * add a new shape to our list of shapes
     *
     * @param shape is the shape that will be add to the list
     */
    public void addShapes(Shape shape) {
        shapes.add(shape);
    }

    /**
     * get the shape at a givent point if the point dont touch a shape return
     * null
     *
     * @param p is the given point
     * @return the Shape at the given point
     */
    public Shape getShapeAt(Point p) {
        Shape shape = null;
        boolean trouver = false;
        for (int i = 0; i < shapes.size() && !trouver; i++) {
            if (shapes.get(i).isInside(p)) {
                shape = shapes.get(i);
                trouver = true;
            }
        }
        return shape;
    }

    /**
     * get the height of our drawing
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * get the width of our drawing
     *
     * @return
     */
    public int getWidth() {
        return width;
    }
}
