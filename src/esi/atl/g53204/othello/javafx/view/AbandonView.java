package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.*;
import esi.atl.g53204.othello.model.PlayerMove;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class AbandonView extends Alert {

    private final Game game;
    private final Stage stage;

    /**
     * alert window that will popup when the player want to abandon the game
     *
     * @param alertType
     * @param game
     * @param stage
     */
    public AbandonView(Alert.AlertType alertType, Game game, Stage stage) {
        super(alertType);
        this.game = game;
        this.stage = stage;
        setTitle("Abandon de la partie");
        setHeaderText("Voulez vous vraiment abbandonner joueur : " + game.getCurrent());
        this.abandon();//first alert

    }

    /**
     * first alert it asks the player if he want to abandon or continue playing
     */
    public void abandon() {
        getButtonTypes().clear();
        ButtonType oui = new ButtonType("oui");
        ButtonType non = new ButtonType("non");
        getButtonTypes().addAll(oui, non);
        Optional<ButtonType> option = showAndWait();
        if (option.get() == oui) {
            this.setHeaderText("le joueur " + game.getCurrent() + " a abbandonner,honte a lui\n"
                    + "Bravo au joueur " + game.getOpponent());
            replayOrQuit();
        }
        if (option.get() == non) {
            this.close();
        }
    }

    /**
     * second alert it asks if the player want to replay or quit the game
     */
    public void replayOrQuit() {
        getButtonTypes().clear();
        ButtonType replay = new ButtonType("rejouer?");
        ButtonType quit = new ButtonType("quitter?");
        getButtonTypes().addAll(replay, quit);
        Optional<ButtonType> option = showAndWait();
        if (option.get() == replay) {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "REPLAY", null, 0);
            game.getPlayerMove().add(move);//for logView
            game.initialize();
            if (game.getCurrent().getColor() == WHITE) {
                game.swapCurrent();
            }
        }
        if (option.get() == quit) {
            stage.close();
        }
    }

}
