package esi.atl.g53204.othello.model;

/**
 *
 * @author Paul
 */
public class Player {

    private final PlayerColor color;

    /**
     * constructor Player
     *
     * @param color of the player
     */
    public Player(PlayerColor color) {
        this.color = color;
    }

    /**
     *
     * @return the color of the player
     */
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "" + color;
    }

}
