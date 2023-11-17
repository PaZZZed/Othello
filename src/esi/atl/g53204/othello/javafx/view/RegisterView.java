package esi.atl.g53204.othello.javafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import esi.atl.g53204.othello.javafx.controller.*;

/**
 *
 * @author Paul
 */
public class RegisterView extends VBox {

    private final RegisterPlayersView players;
    private final Button button;
    private final ViewFx fx;

    /**
     * display RegisterPlayersViewa and a button to confirm the information the
     * player put
     *
     * @param stage
     * @param scene
     * @param fx
     */
    public RegisterView(Stage stage, Scene scene, ViewFx fx) {

        this.setPadding(new Insets(20));
        this.setSpacing(20);

        this.fx = fx;
        this.players = new RegisterPlayersView();

        this.button = new Button("confirmer");

        this.button.setOnAction(new EventRegisterName(this, stage, scene));//transfer names to main scene and switch scene

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(players, button);
    }

    /**
     * get RegisterPlayersView
     *
     * @return
     */
    public RegisterPlayersView getPlayers() {
        return players;
    }

    /**
     * get ViewFx
     *
     * @return
     */
    public ViewFx getFx() {
        return fx;
    }

}
