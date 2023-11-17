package esi.atl.g53204.othello.javafx.view;

import javafx.scene.layout.HBox;

/**
 *
 * @author Paul
 */
public class ButtonsView extends HBox {

    private final ButtonFx rec;
    private final ButtonFx aba;
    private final ButtonFx pas;

    /**
     * place the buttons as i want
     */
    public ButtonsView() {
        this.setSpacing(20);
        this.rec = new ButtonFx("recommencer");
        this.aba = new ButtonFx("abandoner");
        this.pas = new ButtonFx("passer");
        rec.getStyleClass().add("btn");//css
        aba.getStyleClass().add("btn");//css
        pas.getStyleClass().add("btn");//css
        this.getChildren().addAll(rec, aba, pas);
    }

    /**
     * get the button to interact with it
     *
     * @return replay button
     */
    public ButtonFx getRec() {
        return rec;
    }

    /**
     * get the button to interact with it
     *
     * @return abandon button
     */
    public ButtonFx getAba() {
        return aba;
    }

    /**
     * get the button to interact with it
     *
     * @return pass button
     */
    public ButtonFx getPas() {
        return pas;
    }

}
