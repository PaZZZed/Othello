package esi.atl.g53204.othello.model;

/**
 *
 * @author Paul
 */
public class PlayerMove {

    private final int id;
    private final Player name;
    private final String action;
    private final Position position;
    private final int prises;

    /**
     *
     * @param id of the action
     * @param name of the player
     * @param action type of action
     * @param position position of the action
     * @param prises number of pieces the player has taken from his opponent
     */
    public PlayerMove(int id, Player name, String action, Position position, int prises) {
        this.id = id;
        this.name = name;
        this.action = action;
        this.position = position;
        this.prises = prises;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return name
     */
    public Player getName() {
        return name;
    }

    /**
     *
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     *
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     *
     * @return prises
     */
    public int getPrises() {
        return prises;
    }

}
