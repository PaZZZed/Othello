package esi.atl.g53204.othello.view;

import esi.atl.g53204.othello.model.Direction;
import esi.atl.g53204.othello.model.Model;
import esi.atl.g53204.othello.model.Player;
import esi.atl.g53204.othello.model.Square;

import java.util.Scanner;

/**
 *
 * @author Paul
 */
public class View {

    private final Scanner in;

    public View(Scanner in) {
        this.in = in;
    }

    /**
     * display start message
     */
    public void displayStart() {
        System.out.println("        OTHELLO\n");
    }

    /**
     * display the board
     *
     * @param squares
     */
    public void displayBoard(Square[][] squares) {
        System.out.println("   a    b    c    d    e    f    g    h");
        for (int i = 0; i < squares.length; i++) {
            System.out.print(i);
            for (Square square : squares[i]) {

                System.out.print("| " + square + " |");

            }
            System.out.println("");
        }
    }

    /**
     * display the current player
     *
     * @param player
     */
    public void displayPlayer(Player player) {
        System.out.println("au tour du joueur: " + player);
    }

    /**
     * ask the player a certaine commande
     *
     * @return
     */
    public String askCommande() {
        System.out.println("Quelle commande voulez vous faire:  *quit *show *play *score");
        String commande = in.nextLine();
        return commande;
    }

    /**
     * display the score of both players
     *
     * @param game
     */
    public void displayScore(Model game) {
        int black = game.countPoints(game.getCurrent());
        int white = game.countPoints(game.getOpponent());
        System.out.println("Black: " + black + " White: " + white);
    }

    /**
     * display the winner
     *
     * @param game
     */
    public void displayWinner(Model game) {
        Player player = game.getWinner();
        System.out.println("Le vinqueur est le joueur:" + player);
    }

    /**
     * display possible moves for each player
     *
     * @param game
     */
    public void displayPossibleMoves(Model game) {
       
            System.out.println("Moves: " + game.listMoves(game.getCurrent()));

        

    }

    /**
     * message after quit the game
     */
    public void quit() {
        System.out.println("Merci d'avoir joué");
    }

}
