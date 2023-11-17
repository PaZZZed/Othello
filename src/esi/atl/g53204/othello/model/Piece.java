package esi.atl.g53204.othello.model;

import static esi.atl.g53204.othello.model.PlayerColor.*;
import static esi.atl.g53204.othello.view.Color.ANSI_BLACK;
import static esi.atl.g53204.othello.view.Color.ANSI_RESET;
import static esi.atl.g53204.othello.view.Color.ANSI_WHITE;
import java.util.Objects;

/**
 *
 * @author Paul
 */
public class Piece {

    private PlayerColor color;

    /**
     * constructor Piece
     *
     * @param color
     */
    public Piece(PlayerColor color) {
        this.color = color;
    }

    /**
     *
     * @return the color of the piece
     *
     */
    public PlayerColor getColor() {
        return color;
    }

    public void setColor(PlayerColor color) {
        this.color = color;
    }

//QUESTION PROF: marche pas 
    public void flip() {
        if (this.color == BLACK) {
            this.color = WHITE;
        } else if (this.color == WHITE) {
            this.color = BLACK;
        }
    }

    @Override
    public String toString() {
        String pion = "";

        if (color == PlayerColor.BLACK) {
            pion = (ANSI_BLACK + "B" + ANSI_RESET);//couleur marche pas 
        }
        if (color == PlayerColor.WHITE) {
            pion = (ANSI_WHITE + "W" + ANSI_RESET);//couleur marche pas 
        }

        return pion;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.color);
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
        final Piece other = (Piece) obj;
        return this.color == other.color;
    }

}
