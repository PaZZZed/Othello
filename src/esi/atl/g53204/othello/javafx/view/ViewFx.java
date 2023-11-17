package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class ViewFx extends HBox {

    private final ScoreView score;
    private final GameView game;
    private final MenuView mv;

    /**
     * display the GameView and ScoreView
     *
     * @param stage
     */
    public ViewFx(Stage stage) {

        this.game = new GameView(stage);
        this.score = new ScoreView(game.getBoard().getGame());

        this.mv = new MenuView(game.getBoard().getGame(), score.getPlayers());
        this.getChildren().add(mv);

        this.getChildren().add(this.game);
        this.getChildren().add(this.score);
    }

    /**
     * get ScoreView
     *
     * @return
     */
    public ScoreView getScore() {
        return score;
    }

    /**
     * get ScoreView
     *
     * @return
     */
    public GameView getGame() {
        return game;
    }

    public Game getModelGame() {
        return game.getBoard().getGame();
    }

}
