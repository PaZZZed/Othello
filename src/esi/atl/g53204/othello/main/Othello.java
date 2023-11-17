package esi.atl.g53204.othello.main;

import esi.atl.g53204.othello.controller.Controller;
import esi.atl.g53204.othello.model.Game;
import esi.atl.g53204.othello.model.Model;
import esi.atl.g53204.othello.view.View;
import java.util.Scanner;

/**
 *
 * @author Paul
 */
public class Othello {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        Model game = new Game();
        View view = new View(clavier);

        Controller controller = new Controller(game, view);
        controller.initialize();
        controller.start();
    }
}
