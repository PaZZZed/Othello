package esi.atl.g53204.othello.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

/**
 *
 *
 * @author Paul
 */
public class Board {

    private final Square[][] squares;

    /**
     * constructor of Board create a 8x8 array of Squares
     */
    public Board() {

        this.squares = new Square[8][8];
        for (Square[] square : squares) {
            for (int j = 0; j < square.length; j++) {
                square[j] = new Square();
            }
        }
    }

    /**
     * add to the board 3 bonus squares randomly
     */
    public void addBonus() {
        Random ran = new Random();
        int x = ran.nextInt(7);
        int y = ran.nextInt(7);
        int count = 0;
        for (; count < 3;) {
            if (squares[x][y].getPiece() == null && squares[x][y].getBonus() != BonusSquare.BONUS) {
                squares[x][y].setBonus(BonusSquare.BONUS);
                count++;
            }
            x = ran.nextInt(7);
            y = ran.nextInt(7);
        }

    }

    /**
     *
     * @param position is the position we want to see if is inside or not
     * @return if we are inside the "board" at a given position
     */
    public boolean isInsideBoard(Position position) {
        return position.getColumn() >= 0 && position.getColumn() < this.squares[0].length
                && position.getRow() >= 0 && position.getRow() < this.squares.length;
    }

    /**
     *
     * @param position is the position we want to take the square
     * @return the square at the given position
     */
    public Square getSquareAt(Position position) {

        if (!isInsideBoard(position)) {
            throw new ArrayIndexOutOfBoundsException("hors plateau");
        }
        return this.squares[position.getRow()][position.getColumn()];
    }

    /**
     * put a piece in the position we give
     *
     * @param piece the piece we want to put
     * @param position the posititon we want to put the piece
     */
    public void put(Piece piece, Position position) {
        if (!isInsideBoard(position)) {
            throw new IllegalArgumentException("hors plateau");
        }

        this.getSquareAt(position).put(piece);
    }

    /**
     *
     * @return the Board (array of squares)
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     *
     * @param position at wich we want to know is the square is empty
     * @return if the square is empty or not
     */
    public boolean isEmpty(Position position) {
        if (!isInsideBoard(position)) {
            throw new IllegalArgumentException("hors du plateau");
        }
        return getSquareAt(position).isFree();
    }

    /**
     *
     * @param position of our piece
     * @param color of our piece
     * @return if the color is the same at a given position
     */
    public boolean isMyColor(Position position, PlayerColor color) {
        if (!isInsideBoard(position)) {
            throw new IllegalArgumentException("hors du plateau");
        }
        return !isEmpty(position) && getSquareAt(position).getPiece().getColor() == color;
    }

    /**
     * check if there is a free space in our board
     *
     * @param direction we want to check the free space
     * @param position of our initial piece
     * @return the position of the free space
     */
    public Position nextDir(Direction direction, Position position) {
        PlayerColor color = squares[position.getRow()][position.getColumn()].getPiece().getColor();
        while (isInsideBoard(position.next(direction))) {
            if (isEmpty(position.next(direction))) {
                return position.next(direction);
            } else if (isMyColor(position.next(direction), color)) {
                return null;
            }
            position = position.next(direction);
        }
        return null;
    }

    /**
     * list of pieces by each player
     *
     * @param player BLACK or WHITE
     * @return the list of pieces of a player
     */
    public List<Position> getTakenSquare(Player player) {
        List<Position> posPieceColor = new ArrayList<>();

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {

                Position position = new Position(i, j);
                if (isMyColor(position, player.getColor())) {
                    posPieceColor.add(position);
                }
            }
        }
        return posPieceColor;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Board= " + Arrays.deepToString(squares);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Arrays.deepHashCode(this.squares);
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
        final Board other = (Board) obj;
        return Arrays.deepEquals(this.squares, other.squares);
    }

}
