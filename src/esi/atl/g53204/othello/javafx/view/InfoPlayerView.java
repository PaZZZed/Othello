package esi.atl.g53204.othello.javafx.view;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Paul
 */
public class InfoPlayerView extends GridPane {

    private final Label score;
    private final Label points;
    private final Label pion;
    private final Label color;
    private final Label name;
    private final Label player;

    /**
     * display player name his score and his color
     *
     * @param color
     */
    public InfoPlayerView(String color) {

        this.setBorder(new Border(new BorderStroke(Color.LIGHTCYAN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        this.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefSize(210, 100);
        setPadding(new Insets(10));
        this.setHgap(20);
        this.setVgap(20);
        this.score = new Label("score");
        this.pion = new Label("pion");
        this.name = new Label("name");
        this.player = new Label("");
        this.points = new Label("");
        points.getStyleClass().add("pointsFont");
        name.getStyleClass().add("scoreFont");
        pion.getStyleClass().add("scoreFont");
        score.getStyleClass().add("scoreFont");
        player.getStyleClass().add("scoreFont");
        this.color = new Label(color);

        this.add(this.score, 0, 0);
        this.add(this.points, 0, 1);
        this.add(this.pion, 2, 0);
        this.add(this.color, 2, 1);
        this.add(this.name, 1, 0);
        this.add(this.player, 1, 1);
    }

    /**
     * get to acces the player name
     *
     * @return
     */
    public Label getName() {
        return player;
    }

    /**
     * get to acces player color(black or white)
     *
     * @return
     */
    public Label getColor() {
        return color;
    }

    /**
     * get to acces player score
     *
     * @return
     */
    public Label getPoints() {
        return points;
    }

}
