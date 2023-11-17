package esi.atl.g53204.AsciiPaint;

import java.util.Scanner;

/**
 *
 * @author Paul
 */
public class Application {

    private AsciiPaint paint;

    /**
     * initialize the drawing and manage all the interaction with the user, all
     * the commands the user can enter
     */
    
    public void displayChoice(){
        System.out.println("Entrez une commande : ");
        System.out.println("-add\n" + " *rectangle x y height width color\n" + " *circle x y radius color\n" + " *square x y side color");
        System.out.println("-show");
        System.out.println("-quit");
        System.out.println("-new");
        System.out.println("-move\n" + " *x y moveX moveY");
        System.out.println("-remove\n" + " *x y");
        System.out.println("-change\n" + " *x y color");
    }
    public void start() {
        paint = new AsciiPaint(20, 20);
        Scanner clavier = new Scanner(System.in);
        
        displayChoice();
        
        boolean fini = false;
        while (!fini) {
            try {
                String commande = clavier.next();

                if (commande.equals("add")) {
                    
                    commande = clavier.next();
                    switch (commande) {
                        case "rectangle":
                            commande = clavier.next();
                            int xr = Integer.parseInt(commande);
                            commande = clavier.next();
                            int yr = Integer.parseInt(commande);
                            commande = clavier.next();
                            int x = Integer.parseInt(commande);
                            commande = clavier.next();
                            int y = Integer.parseInt(commande);
                            commande = clavier.next();
                            paint.newRectangle(xr, yr, x, y, commande.charAt(0));

                            break;
                        case "circle":
                            commande = clavier.next();
                            int xc = Integer.parseInt(commande);
                            commande = clavier.next();
                            int yc = Integer.parseInt(commande);
                            commande = clavier.next();
                            double radius = Integer.parseInt(commande);
                            commande = clavier.next();
                            paint.newCircle(xc, yc, radius, commande.charAt(0));
                            break;
                        case "square":
                            commande = clavier.next();
                            int xs = Integer.parseInt(commande);
                            commande = clavier.next();
                            int ys = Integer.parseInt(commande);
                            commande = clavier.next();
                            double cote = Integer.parseInt(commande);
                            commande = clavier.next();
                            paint.newSquare(xs, ys, cote, commande.charAt(0));
                            break;
                        case "line":
                            commande = clavier.next();
                            int lx1 = Integer.parseInt(commande);
                            commande = clavier.next();
                            int ly1 = Integer.parseInt(commande);
                            commande = clavier.next();
                            int lx2 = Integer.parseInt(commande);
                            commande = clavier.next();
                            int ly2 = Integer.parseInt(commande);
                            commande = clavier.next();
                            paint.newLine(lx1, ly1, lx2, ly2, commande.charAt(0));
                            break;
                        default:
                            break;
                    }
                } else if (commande.equals("show")) {
                    System.out.println(paint.asAscii());

                } else if (commande.equals("quit")) {
                    fini = true;

                } else if (commande.equals("new")) {
                    paint = new AsciiPaint(20, 20);

                } else if (commande.equals("move")) {
                    commande = clavier.next();
                    int mx = Integer.parseInt(commande);
                    commande = clavier.next();
                    int my = Integer.parseInt(commande);
                    commande = clavier.next();
                    int moveX = Integer.parseInt(commande);
                    commande = clavier.next();
                    int moveY = Integer.parseInt(commande);
                    paint.getDrawing().getShapeAt(new Point(mx, my)).move(moveX, moveY);

                } else if (commande.equals("remove")) {

                    commande = clavier.next();
                    int rx = Integer.parseInt(commande);
                    commande = clavier.next();
                    int ry = Integer.parseInt(commande);
                    Shape shape = paint.getDrawing().getShapeAt(new Point(rx, ry));
                    paint.getDrawing().getShapes().remove(shape);

                } else if (commande.equals("change")) {
                    commande = clavier.next();
                    int colorX = Integer.parseInt(commande);
                    commande = clavier.next();
                    int colorY = Integer.parseInt(commande);
                    commande = clavier.next();
                    char newColor = commande.charAt(0);
                    paint.getDrawing().getShapeAt(new Point(colorX, colorY)).setColor(newColor);

                }
            } catch (NumberFormatException e) {
                System.out.println("mauvaise données");
            }
        }

    }

    public static void main(String[] args) {
        Application app = new Application();

        app.start();

    }
}
