package esi.atl.g53204.AsciiPaint;

/**
 *
 * @author Paul
 */
public interface Shape {

    /**
     * move our Shape by dx(right or left) and dy(up or down)
     *
     * @param dx
     * @param dy
     */
    void move(double dx, double dy);

    /**
     * check if a given point is inside our Shape
     *
     * @param p point we want to check if our shape is in contact with
     * @return true(point is in the shape ) or false(point is not in the shape)
     */
    boolean isInside(Point p);

    /**
     * get the color of the shape
     *
     * @return the "color" of the shape as an character
     */
    char getColor();

    /**
     * change the shape's color
     *
     * @param color is the new color we want to apply to our shape
     */
    void setColor(char color);
}
