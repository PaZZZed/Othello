package esi.atl.g53204.AsciiPaint;

/**
 *
 * @author Paul
 */
public class Circle extends ColorShape {

    private double radius;
    private Point center;

    /**
     * constructor of our class Circle create a circle the radius can't be
     * negative
     *
     * @param center is a point that is the center of our circle
     * @param radius the radius of our circle
     * @param color is the color of our circle
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive"
                    + ", received: " + radius);
        }

        this.radius = radius;
        this.center = center;
        this.center = new Point(center.getX(), center.getY());

    }

    /**
     * get the center of our circle
     *
     * @return Point center
     */
    public Point getCenter() {

        return new Point(center.getX(), center.getY());
    }

    /**
     * to String methode
     *
     * @return
     */
    @Override
    public String toString() {
        return "Circle : [" + center + ", " + radius + "]";
    }

    /**
     * move our circle right or left and up or down
     *
     * @param dx(right or left)
     * @param dy(up or down)
     */
    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    /**
     * check if a given point is inside our circle
     *
     * @param p is the given point
     * @return true (the point is in the circle) false (the point is not in the
     * circle)
     */
    @Override
    public boolean isInside(Point p) {
        boolean dedans = false;
        if (p.distanceTo(center) <= this.radius) {
            dedans = true;
        }
        return dedans;
    }

}
