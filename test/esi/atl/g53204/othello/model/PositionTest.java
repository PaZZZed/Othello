package esi.atl.g53204.othello.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class PositionTest {

    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Position instance = new Position(1, 2);
        int expResult = 1;
        int result = instance.getRow();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Position instance = new Position(1, 2);
        int expResult = 2;
        int result = instance.getColumn();
        assertEquals(expResult, result);

    }

    @Test
    public void testNext() {
        System.out.println("getColumn");
        Position instance = new Position(1, 1);
        Position expResult = new Position(2, 1);
        Position result = instance.next(Direction.DOWN);
        assertEquals(expResult, result);

    }

}
