package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.*;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.HBox;

/**
 *
 * @author Paul
 */
public class PlayerView extends HBox implements Observer {

    private final InfoPlayerView player1;
    private final InfoPlayerView player2;
    private final Game game;

    /**
     * display the two players informations score name color...
     *
     * @param game
     */
    public PlayerView(Game game) {
        this.game = game;
        this.game.addObserver(this);
        this.setSpacing(20);
        player1 = new InfoPlayerView("BLACK");
        player2 = new InfoPlayerView("WHITE");
        player1.getColor().getStyleClass().add("colorBlack");
        player2.getColor().getStyleClass().add("colorWhite");
        this.getChildren().addAll(player1, player2);
    }

    /**
     * update the score of both players
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, Object o1) {
        if (game.getCurrent().getColor() == BLACK) {
            player1.getPoints().setText(String.valueOf(game.countBonusPoints(game.getCurrent())));
            player2.getPoints().setText(String.valueOf(game.countBonusPoints(game.getOpponent())));
        } else {
            player1.getPoints().setText(String.valueOf(game.countBonusPoints(game.getOpponent())));
            player2.getPoints().setText(String.valueOf(game.countBonusPoints(game.getCurrent())));
        }

    }

    /**
     * get the first player
     *
     * @return
     */
    public InfoPlayerView getPlayer1() {
        return player1;
    }

    /**
     *
     * get the second player
     *
     * @return
     */
    public InfoPlayerView getPlayer2() {
        return player2;
    }

}
