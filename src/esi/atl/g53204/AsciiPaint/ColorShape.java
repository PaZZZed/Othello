package esi.atl.g53204.AsciiPaint;

/**
 *
 * @author Paul
 */
public abstract class ColorShape implements Shape {

    private char color;

    /**
     * constructor of our class ColorShape
     *
     * @param color is the color of the Shape
     */
    public ColorShape(char color) {
        this.color = color;
    }

    /**
     * change the shape's color
     *
     * @param color is the new color we want to apply to our shape
     */
    @Override
    public void setColor(char color) {
        this.color = color;
    }

    /**
     * get the color of the shape
     *
     * @return the "color" of the shape as an character
     */
    @Override
    public char getColor() {
        return color;
    }

}
