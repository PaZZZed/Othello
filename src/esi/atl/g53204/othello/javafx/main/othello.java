package esi.atl.g53204.othello.javafx.main;

import esi.atl.g53204.othello.javafx.view.RegisterView;
import esi.atl.g53204.othello.javafx.view.ViewFx;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Paul
 */
public class othello extends Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFx view = new ViewFx(stage);

        Scene mainScene = new Scene(view, 1000, 750);
        RegisterView rv = new RegisterView(stage, mainScene, view);
        Scene registerScene = new Scene(rv, 600, 200);

        registerScene.getStylesheets().add("esi/atl/g53204/othello/javafx/css/registerScene.css");
        mainScene.getStylesheets().add("esi/atl/g53204/othello/javafx/css/mainScene.css");
        stage.setResizable(false);

        stage.setScene(registerScene);
        stage.show();

    }

}
