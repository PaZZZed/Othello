package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.WHITE;
import esi.atl.g53204.othello.model.PlayerMove;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class WinnerView extends Alert {

    private final Game game;
    private final Stage stage;

    /**
     * alert window when someone win the game
     *
     * @param alertType
     * @param game
     * @param stage
     */
    public WinnerView(AlertType alertType, Game game, Stage stage) {
        super(alertType);
        this.game = game;
        this.stage = stage;
        setTitle("Félicitations!!!");
        if (game.getWinner().getColor() == null) {
            setHeaderText("DRAW");
        } else {
            setHeaderText("Winner:" + game.getWinner().getColor());
        }
        replayOrQuit();
    }

    /**
     * asks if the player want to replay or quit
     */
    public void replayOrQuit() {
        getButtonTypes().clear();
        ButtonType replay = new ButtonType("rejouer?");
        ButtonType quit = new ButtonType("quitter?");
        getButtonTypes().addAll(replay, quit);
        Optional<ButtonType> option = showAndWait();
        if (option.get() == replay) {
            PlayerMove move = new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "REPLAY", null, 0);
            game.getPlayerMove().add(move);
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
