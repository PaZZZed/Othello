package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.javafx.controller.EventAbandon;
import esi.atl.g53204.othello.javafx.controller.EventPass;
import esi.atl.g53204.othello.javafx.controller.EventRestart;
import esi.atl.g53204.othello.model.Game;
import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class GameView extends VBox implements Observer {

    private final ButtonsView button;

    private final Label current;
    private final BoardView board;
    private final ProgressBarView pbv;
    private final ProgressIndicatorView piv;
    private final Game game;

    /**
     * GameView it will have the board the progress Indicator and Bar and also
     * the 3 buttons replay abandon and pass
     *
     * @param stage
     */
    public GameView(Stage stage) {
        Game game = new Game();
        game.initialize();
        this.game = game;
        this.game.addObserver(this);
        this.current = new Label("PLAYER: " + game.getCurrent());
        this.current.setId("currentPlayer");//css
        this.button = new ButtonsView();
        this.board = new BoardView(game, stage);
        this.pbv = new ProgressBarView(game);
        this.piv = new ProgressIndicatorView(game);
        this.current.setPadding(new Insets(0, 0, 0, 180));
        button.getRec().setOnAction(new EventRestart(board.getGame()));//event replay on button
        button.getPas().setOnAction(new EventPass(board.getGame()));//event pass on button
        button.getAba().setOnAction(new EventAbandon(board.getGame(), stage));//event abandon on button

        this.board.update(game, game);
        this.pbv.update(game, game);
        this.piv.update(game, game);

        setPadding(new Insets(20));
        this.setSpacing(20);

        button.setAlignment(Pos.CENTER);
        this.getChildren().addAll(current, board, pbv, piv, button);

    }

    /**
     * access the BoardView
     *
     * @return
     */
    public BoardView getBoard() {
        return board;
    }

    /**
     * it will update who is the current player
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, Object o1) {
        this.current.setText("PLAYER: " + game.getCurrent());
    }

}
