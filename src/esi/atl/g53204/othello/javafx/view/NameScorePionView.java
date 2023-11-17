package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import static esi.atl.g53204.othello.model.PlayerColor.BLACK;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Paul
 */
public class NameScorePionView extends GridPane implements Observer {

    private final Label name1;
    private final Label name2;
    private final Label pionB;
    private final Label pionW;
    private final Label scoreB;
    private final Label scoreW;
    private final Label name;
    private final Label pion;
    private final Label score;
    private final Game game;

    /**
     * display the two players informations score name and number of pieces of
     * each player
     *
     * @param game
     */
    public NameScorePionView(Game game) {
        this.game = game;
        this.game.addObserver(this);

        name1 = new Label("");
        name2 = new Label("");
        pionB = new Label("2");
        pionW = new Label("2");
        scoreB = new Label("2");
        scoreW = new Label("2");
        name = new Label("name");
        pion = new Label("pion");
        score = new Label("score");

        this.setHgap(20);
        this.setVgap(20);
        this.add(this.name, 0, 0);
        this.add(this.pion, 1, 0);
        this.add(this.score, 2, 0);

        this.add(this.name1, 0, 1);
        this.add(this.name2, 0, 2);
        this.add(this.pionB, 1, 1);
        this.add(this.pionW, 1, 2);
        this.add(this.scoreB, 2, 1);
        this.add(this.scoreW, 2, 2);

    }

    public Label getName1() {
        return name1;
    }

    public Label getName2() {
        return name2;
    }

    @Override
    public void update(Observable o, Object o1) {
        if (game.getCurrent().getColor() == BLACK) {
            scoreB.setText(String.valueOf(game.countBonusPoints(game.getCurrent())));//compte le score 
            scoreW.setText(String.valueOf(game.countBonusPoints(game.getOpponent())));
            pionB.setText(String.valueOf(game.countPoints(game.getCurrent())));//compte les pions  
            pionW.setText(String.valueOf(game.countPoints(game.getOpponent())));
        } else {
            scoreB.setText(String.valueOf(game.countBonusPoints(game.getOpponent())));//compte le score 
            scoreW.setText(String.valueOf(game.countBonusPoints(game.getCurrent())));
            pionB.setText(String.valueOf(game.countPoints(game.getOpponent())));//compte les pions 
            pionW.setText(String.valueOf(game.countPoints(game.getCurrent())));
        }

    }
}
