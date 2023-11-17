package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.javafx.view.NameScorePionView;
import esi.atl.g53204.othello.javafx.view.PlayerView;
import esi.atl.g53204.othello.model.Game;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class EventNewScore implements EventHandler {

    private final Game game;
    private Scene scene;
    private PlayerView original;
    private NameScorePionView newOne;

    /**
     * event that will display a new window with player infos like score, name
     * ...
     *
     * @param game
     * @param scene
     */
    public EventNewScore(Game game, Scene scene, PlayerView original, NameScorePionView newOne) {
        this.game = game;
        this.original = original;
        this.newOne = newOne;
        this.scene = scene;

    }

    @Override
    public void handle(Event event) {

        newOne.getName1().setText(original.getPlayer1().getName().getText());//mettre dans le nouvel onglet le nom J1
        newOne.getName2().setText(original.getPlayer2().getName().getText());//mettre dans le nouvel onglet le nom J2
        Stage bob = new Stage();
        bob.setScene(scene);
        bob.show();
    }

}
