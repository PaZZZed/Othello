package esi.atl.g53204.AsciiPaint;

/**
 *
 * @author Paul
 */
public class Point {

    private double x;
    private double y;

    /**
     * constructor of the class Point
     *
     * @param x abscissa of the point
     * @param y ordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * create a point
     *
     * @param p is the point we want to recreate
     */
    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * get the x attribute
     *
     * @return x attribute
     */
    public double getX() {
        return x;
    }

    /**
     * get the y attribute
     *
     * @return y attribute
     */
    public double getY() {
        return y;
    }

    /**
     * move our point by dx(right or left) and dy(up or down)
     *
     * @param dx
     * @param dy
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * calculate the distance from a point to another point using the distance
     * formula
     *
     * @param other
     * @return
     */
    public double distanceTo(Point other) {

        return Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));
    }

    /**
     * to string methode
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
