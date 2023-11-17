package esi.atl.g53204.othello.model;

import static esi.atl.g53204.othello.model.PlayerColor.BLACK;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class PieceTest {

    @Test
    public void testGetColor() {
        System.out.println("testGetColor");
        Piece instance = new Piece(PlayerColor.WHITE);
        PlayerColor expResult = PlayerColor.WHITE;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetColor() {
        System.out.println("testSetColor");
        Piece instance = new Piece(PlayerColor.WHITE);
        PlayerColor expResult = PlayerColor.BLACK;
        instance.setColor(BLACK);

        assertEquals(expResult, instance.getColor());

    }
    /*@Test
    public void testFlip() {
        System.out.println("testFlip");
        Piece instance = new Piece(PlayerColor.WHITE);
        Piece insta1nce = new Piece(PlayerColor.WHITE);
        PlayerColor expResult = PlayerColor.BLACK;
        instance.flip();
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);

    }*/

}
