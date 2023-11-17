package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.javafx.view.AbandonView;
import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.BLACK;
import static esi.atl.g53204.othello.model.PlayerColor.WHITE;
import esi.atl.g53204.othello.model.PlayerMove;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class EventAbandon implements EventHandler {

    private final Game game;
    private final Stage stage;

    /**
     * event when the player want to abandon the game if he abandon his opponent
     * will win the game and he will have to choice to replay or quit if he
     * don't abandon the game continue
     *
     * @param game
     * @param stage
     */
    public EventAbandon(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;

    }

    @Override
    public void handle(Event event) {

        if (game.getCurrent().getColor() == BLACK) {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "ABA", null, 0);
            game.getPlayerMove().add(move);//for the logView
        }
        if (game.getCurrent().getColor() == WHITE) {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "ABA", null, 0);
            game.getPlayerMove().add(move);//for the logView
        }
        game.notif();
        new AbandonView(Alert.AlertType.INFORMATION, game, stage);//alert window to confirm if the player want to abandon 
    }

}
