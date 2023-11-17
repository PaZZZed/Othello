package esi.atl.g53204.othello.model;

import static esi.atl.g53204.othello.model.BonusSquare.NORMAL;
import java.util.Objects;

/**
 *
 * @author Paul
 */
public class Square {

    private Piece piece;
    private BonusSquare bs;

    /**
     * constructor of Square create an empty square
     */
    public Square() {
        this.piece = null;
    }

    /**
     * create a square with a piece in it
     *
     * @param piece
     * @param bs
     */
    public Square(Piece piece, BonusSquare bs) {
        this.bs = bs;
        this.piece = piece;
    }

    public Square(Piece piece) {
        this.bs = NORMAL;
        this.piece = piece;
    }

    /**
     *
     * @return the piece on the square
     */
    public Piece getPiece() {
        return piece;
    }

    public BonusSquare getBonus() {
        return bs;
    }

    public void setBonus(BonusSquare bs) {
        this.bs = bs;
    }

    /**
     * put a piece in the square
     *
     * @param piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece changeColor() {

        if (this.piece.getColor() == PlayerColor.BLACK) {
            this.piece.setColor(PlayerColor.WHITE);
        }
        if (this.piece.getColor() == PlayerColor.WHITE) {
            this.piece.setColor(PlayerColor.BLACK);
        }
        return this.piece;
    }

    /**
     * put a piece in the square
     *
     * @param piece
     */
    public void put(Piece piece) {
        if (piece == null) {
            throw new NullPointerException("aucune piece a placer");
        }
        if (this.piece != null) {
            throw new IllegalStateException("piece deja presente");

        }
        this.piece = piece;

    }

    /**
     *
     * @return if the piece is there or not
     */
    public boolean isFree() {
        return this.piece == null;
    }

    /*
    public void flip() {
        if (this.piece.getColor() == PlayerColor.WHITE) {
            this.piece.setColor(BLACK);
        } else if (this.piece.getColor() == PlayerColor.BLACK) {
            this.piece.setColor(WHITE);
        }
    }
     */
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if (piece == null) {
            return " ";
        }
        return "" + piece;

    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.piece);
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
        final Square other = (Square) obj;
        return Objects.equals(this.piece, other.piece);
    }

}
