package esi.atl.g53204.othello.javafx.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Paul
 */
public class PieceView extends Circle {

    private final Color color;

    /**
     * display a circle with a color representing the piece of the player
     *
     * @param fill
     */
    public PieceView(Color fill) {
        super(20, fill);
        this.color = fill;
        this.setStroke(Color.BLACK);
    }

    /**
     * get the color of the piece
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

}
