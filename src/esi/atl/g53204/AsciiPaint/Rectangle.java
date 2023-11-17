package esi.atl.g53204.AsciiPaint;

/**
 *
 * @author Paul
 */
public class Rectangle extends ColorShape {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor of our class Rectangle
     *
     * @param p is the point upper left of our rectangle
     * @param w is the width of our rectangle
     * @param h is the height of our rectangle
     * @param color is the color of our rectangle
     */
    public Rectangle(Point p, double w, double h, char color) {
        super(color);
        if (w < 0 || h < 0) {
            throw new IllegalArgumentException("positive width and length are recuired");
        }
        width = w;
        height = h;
        upperLeft = new Point(p.getX(), p.getY()); // APA : = new Point(p)

    }

    /**
     * move our rectangle right or left and up or down
     *
     * @param dx(right or left)
     * @param dy (up or down)
     */
    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    /**
     * check if a given point is inside our rectangle
     *
     * @param p is the given point
     * @return true (if the point is inside the rectangle) false(if the point is
     * not in the rectangle)
     */
    @Override
    public boolean isInside(Point p) {
        boolean dedans = false;
        if (((p.getX() >= upperLeft.getX()) && (p.getX() <= (upperLeft.getX() + width)))
                && ((p.getY() >= upperLeft.getY()) && (p.getY() <= (upperLeft.getY() + height)))) {
            dedans = true;
        }
        return dedans;
    }

}
