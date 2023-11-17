package esi.atl.g53204.cards;

import static esi.atl.g53204.cards.Color.*;
import static esi.atl.g53204.cards.Value.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author g53204
 */
public class DeckTest {

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        System.out.println("testShuffle");
        Deck instance = new Deck();
        Deck result = new Deck();
        instance.shuffle();
        result = instance;
        assertEquals(instance, result);
    }

    /**
     * Test of isEmpty method, of class Deck.
     */
    @Test
    public void testIsEmptyFalse() {
        System.out.println("testIsEmptyFalse");
        Deck instance = new Deck();
        assertFalse(instance.isEmpty());

    }

    @Test
    public void testIsEmptyTrue() {
        System.out.println("testIsEmptyFalse");
        Deck instance = new Deck();
        for (int i = 0; i < 52; i++) {
            instance.hit();
        }
        assertTrue(instance.isEmpty());
    }

    // APA : testIsEmptyTrue
    /**
     * Test of hit method, of class Deck.
     */
    @Test
    public void testHit() {
        System.out.println("testHit");
        Deck instance = new Deck();
        Card expResult = new Card(KING, SPADE);
        Card result = instance.hit();
        assertEquals(expResult, result);

    }

    @Test(expected = NullPointerException.class)
    public void testHitNull() {
        System.out.println("testHit");
        Deck instance = new Deck();
        for (int i = 0; i < 53; i++) {
            instance.hit();
        }

    }
    // APA : Tester hit si le paquet est vide

}
