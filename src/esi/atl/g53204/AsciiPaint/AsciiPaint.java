package esi.atl.g53204.AsciiPaint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul
 */
public class AsciiPaint {

    private Drawing drawing;

    /**
     * constructor by default of our class AsciiPaint
     */
    public AsciiPaint() {
        this(100, 100);
    }

    /**
     * constrctor of our class AsciiPaint initialize the drawing
     *
     * @param width is the width of our drawing
     * @param length is the length of our drawing
     */
    public AsciiPaint(int width, int length) {
        List<Shape> shapes = new ArrayList<>();
        drawing = new Drawing(shapes, width, length);
    }

    /**
     * get the drawing
     *
     * @return
     */
    public Drawing getDrawing() {
        return drawing;
    }

    /**
     * add a new circle to our drawing
     *
     * @param x is the abscissa of the center of the circle
     * @param y is the ordinate of the center of the circle
     * @param radius is the radius of the circle
     * @param color is the color of the circle
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShapes(new Circle(new Point(x, y), radius, color));
    }

    /**
     * add a new rectangle to our drawing
     *
     * @param x is the abscissa of the upper left point of the rectangle
     * @param y is the ordinate of the upper left point of the rectangle
     * @param width is the width of the new rectangle
     * @param height is the height of the new rectangle
     * @param color is the color of the new rectangle
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShapes(new Rectangle(new Point(x, y), width, height, color));

    }

    /**
     * add a new square to our drawing
     *
     * @param x is the abscissa of the upper left point of the square
     * @param y is the abscissa of the upper left point of the square
     * @param side is the side of the new square
     * @param color is the color of the new square
     */
    public void newSquare(int x, int y, double side, char color) {
        drawing.addShapes(new Square(new Point(x, y), side, color));

    }

    /**
     * add a new Line to the drawing
     *
     * @param x1 is the abscissa of our first point
     * @param y1 is the ordinate of our first point
     * @param x2 is the abscissa of our second point
     * @param y2 is the ordinate of our second point
     * @param color
     */
    public void newLine(int x1, int y1, int x2, int y2, char color) {
        drawing.addShapes(new Line(new Point(x1, y1), new Point(x2, y2), color));

    }

    /**
     * display all the shapes that are in the drawing
     *
     * @return a string representing the drawing
     */
    public String asAscii() {
        // APA : StringBuilder/StringBuffer
        
        String dessin = "";
        for (int i = 1; i < drawing.getWidth(); i++) {
            for (int j = 1; j < drawing.getHeight(); j++) {
                if (drawing.getShapeAt(new Point(i, j)) == null) {
                    dessin = dessin + "-";
                } else if (drawing.getShapeAt(new Point(i, j)).isInside(new Point(i, j))) {
                    dessin = dessin + drawing.getShapeAt(new Point(i, j)).getColor();
                }
            }
            dessin = dessin + "\n";
        }
        return dessin;
    }

}
