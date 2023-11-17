package esi.atl.g53204.othello.javafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.*;

/**
 *
 * @author Paul
 */
public class SquareView extends StackPane {

    private Background bg;

    /**
     * squares of the board
     *
     * @param o
     */
    public SquareView() {

        setAlignment(Pos.CENTER);
        setMinSize(60, 60);
        bg = new Background(new BackgroundFill(Color.DARKSLATEBLUE, CornerRadii.EMPTY, Insets.EMPTY));
        setBorder(new Border(new BorderStroke(Color.LIGHTCYAN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        setBackground(bg);
    }

    public void setBgBonus() {
        bg = new Background(new BackgroundFill(Color.MAGENTA, CornerRadii.EMPTY, Insets.EMPTY));
        setBackground(bg);
    }

    public void getBg() {
        setBackground(bg);
    }

    /**
     * add a new piece of a chosen color to the square
     *
     * @param color
     */
    public void addPiece(Color color) {
        if (color == BLACK) {
            this.getChildren().add(new PieceView(BLACK));
        }
        if (color == WHITE) {
            this.getChildren().add(new PieceView(WHITE));
        }
    }

}
