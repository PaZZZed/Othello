package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.javafx.controller.*;
import javafx.scene.layout.GridPane;
import esi.atl.g53204.othello.model.*;
import static esi.atl.g53204.othello.model.BonusSquare.BONUS;
import static esi.atl.g53204.othello.model.PlayerColor.*;
import java.util.Observable;
import java.util.Observer;
import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Paul
 */
public class BoardView extends GridPane implements Observer {

    private final SquareView[][] square;
    private final Game game;
    private final Stage stage;
    private final Terminator T800;

    /**
     * the boardView will display the board where all the pieces are
     *
     * @param o
     * @param stage
     */
    public BoardView(Game o, Stage stage) {
        this.game = o;
        this.stage = stage;
        this.game.addObserver(this);
        this.square = new SquareView[game.getBoard().length][game.getBoard()[0].length];
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        T800 = new Terminator(game);
    }

    /**
     * to acces the Terminator(ia) class
     *
     * @return
     */
    public Terminator getAI() {
        return T800;
    }

    /**
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * it will update the board each time the player will interact with the
     * board also create the board and put the pieces from game
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, Object o1) {

        //monsieur si vous mettez ca il y a le  bot qui jou
        /*PauseTransition delay = new PauseTransition(Duration.seconds(2));//2 second of delay before the bot plays 
        delay.setOnFinished(event -> T800.play());//dont work properly!!!
        delay.play();*/
        //ce code fait un peu bugger le tout donc je l'ai mis en note mais il marche 
        for (int i = 0; i < game.getBoard().length; i++) {
            for (int j = 0; j < game.getBoard()[0].length; j++) {
                square[i][j] = new SquareView();
                add(square[i][j], i, j);
                if (game.getBoard()[i][j].getPiece() != null) {
                    if (game.getBoard()[i][j].getPiece().getColor() == BLACK) {
                        square[i][j].addPiece(Color.BLACK);
                    } else if (game.getBoard()[i][j].getPiece().getColor() == WHITE) {
                        square[i][j].addPiece(Color.WHITE);
                    }
                }
                if (game.getBoard()[i][j].getPiece() == null || game.getBoard()[i][j].getPiece().getColor() == BLACK || game.getBoard()[i][j].getPiece().getColor() == WHITE) {
                    if (game.getBoard()[i][j].getBonus() == BONUS) {
                        square[i][j].setBgBonus();
                    }
                }

                square[i][j].setOnMouseClicked(new EventPut(game, new Position(i, j)));
                square[i][j].setOnMouseEntered(new EventChoice(game, new Position(i, j), square[i][j]));
                square[i][j].setOnMouseExited(new EventExitChoice(square[i][j]));

            }
        }
        displayWinner();
    }

    /**
     * display the winner with an alert message
     */
    public void displayWinner() {
        if (!game.hasMoves(game.getCurrent()) && !game.hasMoves(game.getOpponent())) {
            new WinnerView(Alert.AlertType.INFORMATION, game, stage);
        }
    }
}
