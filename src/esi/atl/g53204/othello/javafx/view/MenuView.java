package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.javafx.controller.EventNewScore;
import esi.atl.g53204.othello.model.Game;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Paul
 */
public class MenuView extends BorderPane {

    /**
     * add a menu to the game, the menu only has one utility : to add a new
     * window to check players additional informations
     *
     * @param game
     * @param nspv
     */
    public MenuView(Game game, PlayerView nspv) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Menu");
        MenuItem newWindow = new MenuItem("New");
        NameScorePionView menu = new NameScorePionView(game);

        Scene scene = new Scene(menu, 400, 400);
        newWindow.setOnAction(new EventNewScore(game, scene, nspv, menu));
        fileMenu.getItems().addAll(newWindow);
        menuBar.getMenus().addAll(fileMenu);
        setTop(menuBar);
    }

}
