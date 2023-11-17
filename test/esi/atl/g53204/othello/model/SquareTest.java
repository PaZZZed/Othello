package esi.atl.g53204.othello.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Paul
 */
public class SquareTest {

    @Test
    public void testPut() {
        System.out.println("testPut");
        Piece piece = new Piece(PlayerColor.BLACK);
        Square instance = new Square();
        System.out.println(instance);
        instance.put(piece);
        System.out.println(instance);

    }

    @Test(expected = NullPointerException.class)
    public void testPutWhenPieceNull() {
        System.out.println("testPutWhenPieceNull");
        Piece piece = null;
        Square instance = new Square();
        instance.put(piece);
    }

    @Test(expected = IllegalStateException.class)
    public void testPutWhenPieceExist() {
        System.out.println("testPutWhenPieceExist");
        Piece piece = new Piece(PlayerColor.BLACK);
        Piece piece1 = new Piece(PlayerColor.WHITE);

        Square instance = new Square(piece1);
        instance.put(piece);

    }

    @Test
    public void testSetPiece() {
        System.out.println("testSetPiece");
        Piece piece = new Piece(PlayerColor.BLACK);

        Square instance = new Square();
        instance.setPiece(piece);
        assertEquals(piece, instance.getPiece());

    }

    @Test
    public void testIsFreeTrue() {
        System.out.println("testIsFreeTrue");

        Square instance = new Square();

        assertTrue(instance.isFree());

    }

    @Test
    public void testIsFreeFalse() {
        System.out.println("testIsFreeFalse");

        Square instance = new Square(new Piece(PlayerColor.BLACK));

        assertFalse(instance.isFree());

    }
}
