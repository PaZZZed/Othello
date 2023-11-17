package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.*;
import esi.atl.g53204.othello.model.PlayerMove;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Paul
 */
public class EventPass implements EventHandler {

    private final Game game;

    /**
     * event when the player want to pass his turn it will swap the current
     * player
     *
     * @param game
     */
    public EventPass(Game game) {
        this.game = game;

    }

    @Override
    public void handle(Event event) {

        if (game.getCurrent().getColor() == BLACK) {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "PASS", null, 0);
            game.getPlayerMove().add(move);//for the logView
        }
        if (game.getCurrent().getColor() == WHITE) {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "PASS", null, 0);
            game.getPlayerMove().add(move);//for the logView
        }
        game.swapCurrent();
    }

}
