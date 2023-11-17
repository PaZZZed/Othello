package esi.atl.g53204.othello.javafx.view;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Paul
 */
public class RegisterPlayersView extends GridPane {

    private final Label player1;
    private final Label player2;
    private final TextField nom1;
    private final TextField nom2;
    private final Label nomBot1;
    private final Label nomBot2;
    private final RadioButton bot1;
    private final RadioButton bot2;

    /**
     * display the register informations player names and possibility to chose
     * ia allows to enter the names
     */
    public RegisterPlayersView() {
        this.setHgap(20);
        player1 = new Label("Player1:");
        player1.getStyleClass().add("player");
        player2 = new Label("Player2:");
        player2.getStyleClass().add("player");
        nom1 = new TextField();
        nom1.setPromptText("nom du joueur 1");
        nom2 = new TextField();
        nom2.setPromptText("nom du joueur 2");
        nomBot1 = new Label("BOT");
        nomBot1.getStyleClass().add("radio");
        nomBot2 = new Label("BOT");
        nomBot2.getStyleClass().add("radio");
        bot1 = new RadioButton();
        bot2 = new RadioButton();
        final ToggleGroup group = new ToggleGroup();

        bot1.setToggleGroup(group);
        bot2.setToggleGroup(group);

        this.add(this.player1, 0, 0);
        this.add(this.nom1, 0, 1);
        this.add(this.nomBot1, 1, 0);
        this.add(this.bot1, 1, 1);

        this.add(this.player2, 2, 0);
        this.add(this.nom2, 2, 1);
        this.add(this.nomBot2, 3, 0);
        this.add(this.bot2, 3, 1);

    }

    /**
     * get the name of player 1
     *
     * @return
     */
    public TextField getNom1() {
        return nom1;
    }

    /**
     * get the name of player 2
     *
     * @return
     */
    public TextField getNom2() {
        return nom2;
    }

    /**
     * get the first radio button
     *
     * @return
     */
    public RadioButton getBot2() {
        return bot2;
    }

    /**
     * get the second radio button
     *
     * @return
     */
    public RadioButton getBot1() {
        return bot1;
    }

}
