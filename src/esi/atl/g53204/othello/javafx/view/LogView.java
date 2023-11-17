package esi.atl.g53204.othello.javafx.view;

import esi.atl.g53204.othello.model.Game;
import esi.atl.g53204.othello.model.PlayerMove;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class LogView extends TableView implements Observer {

    private final TableColumn id;
    private final TableColumn name;
    private final TableColumn action;
    private final TableColumn position;
    private final TableColumn prises;
    private final Game game;
    private ObservableList<PlayerMove> data;

    /**
     * it will display all the actions the player will do like put a piece click
     * on a certain button...
     *
     * @param game
     */
    public LogView(Game game) {
        this.game = game;
        this.game.addObserver(this);
        this.setPrefSize(500, 600);
        this.setBorder(new Border(new BorderStroke(Color.LIGHTCYAN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));
        this.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.id = new TableColumn("ID");
        this.name = new TableColumn("Name");
        this.action = new TableColumn("Action");
        this.position = new TableColumn("Position");
        this.prises = new TableColumn("Prises");
        game.getPlayerMove().add(new PlayerMove(game.getPlayerMove().size(), game.getCurrent(), "new game", null, 0));
        this.data = FXCollections.observableArrayList(game.getPlayerMove());
        setItems(data);

        id.setCellValueFactory(new PropertyValueFactory<PlayerMove, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<PlayerMove, String>("name"));
        action.setCellValueFactory(new PropertyValueFactory<PlayerMove, String>("action"));
        position.setCellValueFactory(new PropertyValueFactory<PlayerMove, String>("position"));
        prises.setCellValueFactory(new PropertyValueFactory<PlayerMove, String>("prises"));
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        this.getColumns().setAll(id, name, action, position, prises);

    }

    /**
     * update the list of moves the player has
     *
     * @param o
     * @param o1
     */
    @Override
    public void update(Observable o, Object o1) {
        this.data = FXCollections.observableArrayList(game.getPlayerMove());
        setItems(data);

    }

}
