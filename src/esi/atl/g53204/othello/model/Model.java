package esi.atl.g53204.othello.model;

import java.util.List;

/**
 *
 * @author Paul
 */
public interface Model {

    /**
     * initialize the board with 4 pieces in the center
     */
    void initialize();

    /**
     *
     * @return the board
     */
    Square[][] getBoard();

    /**
     * put a piece at the given position
     *
     * @param position
     */
    void putAt(Position position);

    /**
     * swap players between current and opponent
     */
    void swapCurrent();

    /**
     *
     * @return the opponent player
     */
    Player getOpponent();

    /**
     *
     * @return the winner black or white
     */
    Player getWinner();

    /**
     *
     * @param player
     * @return the number of points for a player
     */
    int countPoints(Player player);

    /**
     *
     * @param player
     * @return the number of Points with bonus points also
     */
    public int countBonusPoints(Player player);

    /**
     *
     * @return the current player
     */
    Player getCurrent();

    /**
     *
     * @param player
     * @return
     */
    public List<Position> listMoves(Player player);

    /**
     *
     * @param player
     * @return
     */
    boolean hasMoves(Player player);
}
