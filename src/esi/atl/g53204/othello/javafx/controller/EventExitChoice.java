package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.javafx.view.SquareView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Paul
 */
public class EventExitChoice implements EventHandler<MouseEvent> {

    private final SquareView sv;

    /**
     * event when the mouse exit the node it will paint the node in the color it
     * was before the EventChoice was applied
     *
     * @param sv
     */
    public EventExitChoice(SquareView sv) {
        this.sv = sv;
    }

    @Override
    public void handle(MouseEvent event) {
        sv.getBg();

    }
}
