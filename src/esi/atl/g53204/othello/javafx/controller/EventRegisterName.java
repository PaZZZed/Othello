package esi.atl.g53204.othello.javafx.controller;

import esi.atl.g53204.othello.javafx.view.RegisterView;
import esi.atl.g53204.othello.model.PlayerColor;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class EventRegisterName implements EventHandler {

    private final RegisterView rv;
    private final Stage stage;
    private final Scene scene;

    /**
     * event that will transfer the names of the players to the main scene and
     * it change the scene from the register scene to the main scene
     *
     * it will also check if the player selected a bot to play against,the
     * player can select if the bot is black or white
     *
     *
     * @param rv
     * @param stage
     * @param scene
     */
    public EventRegisterName(RegisterView rv, Stage stage, Scene scene) {
        this.rv = rv;
        this.scene = scene;
        this.stage = stage;
    }

    @Override
    public void handle(Event event) {
        String player1 = rv.getPlayers().getNom1().getText();
        String player2 = rv.getPlayers().getNom2().getText();
        if (player1.isEmpty()) {
            player1 = "ROB";//default name for black player
        }
        if (player2.isEmpty()) {
            player2 = "BOB";//default name for white player
        }
        if (rv.getPlayers().getBot1().isSelected()) {//bot is black
            rv.getFx().getGame().getBoard().getAI().setBot(Boolean.TRUE);
            rv.getFx().getGame().getBoard().getAI().setPlayer(PlayerColor.BLACK);
        }
        if (rv.getPlayers().getBot2().isSelected()) {//bot is white
            rv.getFx().getGame().getBoard().getAI().setBot(Boolean.TRUE);
            rv.getFx().getGame().getBoard().getAI().setPlayer(PlayerColor.WHITE);
        }
        stage.setScene(scene);
        rv.getFx().getScore().getPlayers().getPlayer1().getName().setText(player1);
        rv.getFx().getScore().getPlayers().getPlayer2().getName().setText(player2);

    }
}
