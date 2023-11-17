package esi.atl.g53204.AsciiPaint;

/**
 *
 * @author Paul
 */
public class Line extends ColorShape {

    private final Point a;
    private final Point b;

    public Line(Point a, Point b, char color) {
        super(color);
        this.a = a;
        this.b = b;
    }

    public double lineDistanceTo(Point p) {
        return ((a.getY() - b.getY()) * p.getX() + (b.getX() - a.getX()) * p.getY() + a.getX() * b.getY() - b.getX() * a.getY())
                / Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getX()), 2));
    }

    @Override
    public void move(double dx, double dy) {
        a.move(dx, dy);
        b.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        double pente = (b.getY() - a.getY()) / (b.getX() - a.getX());
        double b1 = p.getY() - pente * p.getX();
        double b2 = a.getY() - pente * b.getX();
        if (b1 == b2) {
            return true;
        }

        return false;
    }

}
