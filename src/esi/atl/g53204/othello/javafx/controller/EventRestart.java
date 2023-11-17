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
public class EventRestart implements EventHandler {

    private final Game game;

    /**
     * event that restart the game
     *
     * @param game
     */
    public EventRestart(Game game) {
        this.game = game;

    }

    @Override
    public void handle(Event event) {

        if (game.getCurrent().getColor() == BLACK) {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "REPLAY", null, 0);
            game.getPlayerMove().add(move);//for the logView
        }
        if (game.getCurrent().getColor() == WHITE) {

            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "REPLAY", null, 0);
            game.getPlayerMove().add(move);//for the logView
            game.swapCurrent();//change the current player if not the white will start 
        }
        game.initialize();
    }

}
