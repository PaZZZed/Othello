package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.javafx.view.SquareView;
import esi.atl.g53204.othello.model.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Paul
 */
public class EventChoice implements EventHandler<MouseEvent> {

    private final Game game;
    private final Position position;
    private final SquareView sv;

    /**
     * event when the mouse enter the node it will paint the node depending if
     * the player can play at the position or not if he can=green if not=red
     *
     * @param game
     * @param position
     * @param sv
     */
    public EventChoice(Game game, Position position, SquareView sv) {
        this.game = game;
        this.position = position;
        this.sv = sv;
    }

    @Override
    public void handle(MouseEvent event) {
        if (game.getBoard()[position.getRow()][position.getColumn()].isFree()) {
            sv.setBackground(new Background(new BackgroundFill(Color.CORAL, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        for (Position pos : game.listMoves(game.getCurrent())) {

            if ((pos.getColumn() == position.getColumn()) && (pos.getRow() == position.getRow())) {
                sv.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }

        }
    }
}
