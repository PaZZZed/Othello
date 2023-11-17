package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 *
 * @author Paul
 */
public class ScoreView extends VBox {

    private final LogView log;
    private final PlayerView players;

    /**
     * display logView and PlayerView
     *
     * @param game
     */
    public ScoreView(Game game) {
        setPadding(new Insets(20));
        this.setSpacing(20);
        this.log = new LogView(game);
        this.log.update(game, game);

        this.players = new PlayerView(game);
        players.update(game, game);
        this.getChildren().addAll(players, log);

    }

    /**
     * get PlayerView
     *
     * @return
     */
    public PlayerView getPlayers() {
        return players;
    }
    
    

}
