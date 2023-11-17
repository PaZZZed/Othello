package esi.atl.g53204.othello.model;

/**
 *
 * @author Paul
 */
public enum Direction {
    //UP, DOWN, LEFT, RIGHT;

    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
    SUDOUEST(1, -1),
    SUDEST(1, 1),
    NORDEST(-1, 1),
    NORDOUEST(-1, -1);

    //row directed move
    private final int row;
    //column directed move
    private final int column;

    /**
     * Constructor
     *
     * @param row
     * @param column
     */
    private Direction(int row, int column) {
        this.row = row;
        this.column = column;

    }

    /**
     *
     * @return the row of our direction(position)
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return the column of our direction(position)
     */
    public int getColumn() {
        return column;
    }

}
