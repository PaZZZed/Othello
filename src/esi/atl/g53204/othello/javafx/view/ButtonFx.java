package esi.atl.g53204.othello.javafx.view;

import javafx.scene.control.Button;

/**
 *
 * @author Paul
 */
public class ButtonFx extends Button {

    /**
     * create button with a specific size and a name
     *
     * @param name
     */
    public ButtonFx(String name) {
        super(name);
        this.setPrefSize(140, 35);
    }
}
