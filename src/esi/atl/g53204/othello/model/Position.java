package esi.atl.g53204.othello.model;

/**
 *
 * @author Paul
 */
public class Position {

    private int row;
    private int column;

    /**
     * constructor of Position create a position "x y"
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        if (row > 8 || column > 8) {
            throw new ArrayIndexOutOfBoundsException("colonne ou ligne hors du plateau");
        }
        this.row = row;
        this.column = column;
    }

    public boolean isBonus() {
        if (true) {
            
        }
        return false;

    }

    /**
     * get the row of our position
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * get the column of our position
     *
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     *
     * @param direction
     * @return the position at the next direction
     */
    public Position next(Direction direction) {
        Position position = new Position(this.row, this.column);
        position.row = position.row + direction.getRow();
        position.column = position.column + direction.getColumn();
        return new Position(position.row, position.column);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.row;
        hash = 79 * hash + this.column;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

}
