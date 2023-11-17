package esi.atl.g53204.othello.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class PlayerTest {

    @Test
    public void testGetColor() {
        System.out.println("testGetColor");
        Player instance = new Player(PlayerColor.BLACK);
        PlayerColor expResult = PlayerColor.BLACK;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);

    }

}
