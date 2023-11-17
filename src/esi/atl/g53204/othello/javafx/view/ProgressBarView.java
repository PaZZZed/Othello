package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.BLACK;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Paul
 */
public class ProgressBarView extends ProgressBar implements Observer {

    private final Game game;

    /**
     * display the proportion of black pieces and white pieces
     *
     * @param game
     */
    public ProgressBarView(Game game) {
        this.game = game;
        game.addObserver(this);
        this.setPrefWidth(500);
        this.setBorder(new Border(new BorderStroke(Color.LIGHTCYAN, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.MEDIUM)));

    }

    /**
     * update each time the player put a piece
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, Object o1) {
        double black = 0.0;
        double white = 0.0;
        if (game.getCurrent().getColor() == BLACK) {
            black = (double) game.countPoints(game.getCurrent());
            white = (double) game.countPoints(game.getOpponent());
        } else {
            black = (double) game.countPoints(game.getOpponent());
            white = (double) game.countPoints(game.getCurrent());
        }
        setProgress(black / (black + white));
    }

}
