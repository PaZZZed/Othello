package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.BLACK;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author Paul
 */
public class ProgressIndicatorView extends ProgressIndicator implements Observer {

    private final Game game;

    /**
     * display the proportion of the pieces on the board if the board is full
     * the indicator will be 100%
     *
     * @param game
     */
    public ProgressIndicatorView(Game game) {
        this.game = game;
        this.game.addObserver(this);
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

        setProgress((black + white) / 64.0);
    }
}
