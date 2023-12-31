package esi.atl.oo_inheritance;
import java.util.*;

public class TestPolymorphism {
    
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0,0));
        points.add(new ColoredPoint(2, 4, 0xFF0000FF));
        points.add(new PinnablePoint(1, 1));
        printPoints(points);
    }
    
    static void printPoints(List<Point> list) {
        for(Point p : list) {
            p.move(1,1);
            System.out.println(p);
        }
    }
}