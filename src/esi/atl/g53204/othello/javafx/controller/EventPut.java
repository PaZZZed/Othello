package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.model.*;
import static esi.atl.g53204.othello.model.PlayerColor.*;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Paul//extends Observable
 */
public class EventPut implements EventHandler<MouseEvent> {

    private final Game game;
    private final Position position;

    /**
     * event when the player want to put a piece on the board
     *
     * @param game
     * @param position
     */
    public EventPut(Game game, Position position) {
        this.game = game;
        this.position = position;

    }

    @Override
    public void handle(MouseEvent event) {
        if (canPut()) {
            if (game.getCurrent().getColor() == BLACK) {
                PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "PUT", position, prise());
                game.getPlayerMove().add(move);//for the logView
                game.notif();

            } else if (game.getCurrent().getColor() == WHITE) {
                PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "PUT", position, prise());
                game.getPlayerMove().add(move);//for the logView
                game.notif();
            }
        } else {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "ERROR", position, 0);
            game.getPlayerMove().add(move);//for the logView when the player cant play on that position
            game.notif();

        }

    }

    /**
     * return the number of pieces the player has won after puting on the board
     * his piece
     *
     * @return
     */
    public int prise() {
        int oldScore = game.countPoints(game.getCurrent());
        game.putAt(position);
        int newScore = (game.countPoints(game.getOpponent()) - oldScore - 1);
        return newScore;

    }

    /**
     * check if the player can play at the position the mouse will click on,
     * thanks to the list of moves the player has
     *
     * @return
     */
    public boolean canPut() {
        boolean put = false;
        for (Position pos : game.listMoves(game.getCurrent())) {
            if ((pos.getColumn() == position.getColumn()) && (pos.getRow() == position.getRow())) {
                put = true;
            }
        }
        return put;
    }

}
