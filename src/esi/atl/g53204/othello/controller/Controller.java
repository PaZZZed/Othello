package esi.atl.g53204.othello.controller;

import esi.atl.g53204.othello.model.Model;
import esi.atl.g53204.othello.model.Position;
import esi.atl.g53204.othello.view.View;

/**
 *
 * @author Paul
 */
public class Controller {

    private final Model game;
    private final View view;

    /**
     * constructor Controller
     *
     * @param game
     * @param view
     */
    public Controller(Model game, View view) {

        this.game = game;
        this.view = view;

        if (this.game == null || this.view == null) {
            throw new IllegalArgumentException("Error(Model or View)");
        }
    }

    /**
     * initialize the game and the view
     */
    public void initialize() {
        view.displayStart();
        game.initialize();
    }

    /**
     * start the game
     */
    public void start() {

        view.displayBoard(game.getBoard());
        boolean end = false;

        while (game.hasMoves(game.getCurrent()) && !end) {
            String message = view.askCommande();
            try {
                if (message.startsWith("quit")) {
                    view.quit();
                    end = true;
                }
                if (message.startsWith("show")) {
                    view.displayBoard(game.getBoard());
                    view.displayPlayer(game.getCurrent());
                    view.displayPossibleMoves(game);

                }
                if (message.startsWith("score")) {
                    view.displayScore(game);
                    System.out.println(game.countPoints(game.getOpponent()));
                    System.out.println(game.countPoints(game.getCurrent()));

                }
                if (message.startsWith("play")) {
                    int r = Integer.parseInt(message.substring(5, 6));
                    int c = Integer.parseInt(message.substring(7, 8));
                    game.putAt(new Position(r, c));
                }
            } catch (IllegalStateException | NullPointerException | IllegalArgumentException e) {
                System.out.println("mauvaise mouvement réesseyer");
            }
        }

        view.displayWinner(game);
    }
}
