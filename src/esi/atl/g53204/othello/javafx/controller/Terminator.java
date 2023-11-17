package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.model.Game;
import esi.atl.g53204.othello.model.PlayerColor;
import static esi.atl.g53204.othello.model.PlayerColor.*;
import esi.atl.g53204.othello.model.PlayerMove;
import java.util.Random;

/**
 *
 * @author Paul
 */
public class Terminator {

    private final Game game;

    private Boolean bot;
    private PlayerColor player;

    /**
     *
     * @param game
     */
    public Terminator(Game game) {
        bot = false;
        this.game = game;

    }

    /**
     * set if the ia will be enable or not
     *
     * @param ok
     */
    public void setBot(Boolean ok) {
        this.bot = ok;
    }

    /**
     * set for wich player will be the ia (white or black)
     *
     * @param player
     */
    public void setPlayer(PlayerColor player) {
        this.player = player;
    }

    /**
     * get a random number from 0 to the number of moves the player has
     *
     * @return
     */
    public int randomPos() {
        Random r = new Random();
        int name = game.listMoves(game.getCurrent()).size() - 1;
        return r.nextInt(name) + 1;

    }

    /**
     * if the ia is enable(bot=true) will play at a random position from the
     * player moves
     */
    public void play() {
        if (bot && game.getCurrent().getColor() == WHITE && player == WHITE) {
            int i = randomPos();
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "PUT", game.listMoves(game.getCurrent()).get(i), prise(i));
            game.getPlayerMove().add(move);//for the logView
        }
        if (bot && game.getCurrent().getColor() == BLACK && player == BLACK) {

            int i = randomPos();
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "PUT", game.listMoves(game.getCurrent()).get(i), prise(i));
            game.getPlayerMove().add(move);//for the logView       
        }
        game.notif();//nottify the chenges
    }

    /**
     * return the number of pieces the player has won after puting on the board
     * his piece
     *
     * @param i is there to have the same random number as the number we will
     * put in the logView
     * @return
     */
    public int prise(int i) {
        int oldScore = game.countPoints(game.getCurrent());

        game.putAt(game.listMoves(game.getCurrent()).get(i));
        int newScore = (game.countPoints(game.getOpponent()) - oldScore - 1);
        return newScore;

    }

}
