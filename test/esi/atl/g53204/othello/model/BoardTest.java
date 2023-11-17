package esi.atl.g53204.othello.model;

import static esi.atl.g53204.othello.model.PlayerColor.BLACK;
import static esi.atl.g53204.othello.model.PlayerColor.WHITE;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class BoardTest {

    @Test
    public void testInsideBoardTrue() {
        System.out.println("testIsInsideBoardTrue");
        Position position = new Position(3, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInsideBoard(position);
        assertEquals(expResult, result);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testInsideBoardFalse() {
        System.out.println("testIsInsideBoardFalse");
        Position position = new Position(9, 3);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInsideBoard(position);
        assertEquals(expResult, result);

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetSquareNoBoard() {
        System.out.println("testGetSquarePosNoBoard");
        Position position = new Position(9, 3);
        Board instance = new Board();
        instance.getSquareAt(position);

    }

    @Test
    public void testGetSquareAt() {
        System.out.println("testGetSquareAt");
        Position position = new Position(3, 3);
        Piece piece = new Piece(PlayerColor.BLACK);
        Board instance = new Board();
        instance.put(piece, position);
        Square expResult = new Square(piece);
        Square result = instance.getSquareAt(position);
        assertEquals(expResult, result);

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPutWhenNoBoard() {
        System.out.println("testPutWhenNoBoard");
        Piece piece = new Piece(PlayerColor.BLACK);
        Position position = new Position(9, 3);
        Board instance = new Board();
        instance.put(piece, position);

    }

    @Test
    public void testPut() {
        System.out.println("testPut");
        Piece piece = new Piece(PlayerColor.BLACK);
        Position position = new Position(3, 3);
        Board instance = new Board();
        instance.put(piece, position);

    }

    @Test
    public void testIsEmptyTrue() {
        System.out.println("testIsEmptyTrue");
        Position position = new Position(3, 3);
        Board instance = new Board();
        assertTrue(instance.isEmpty(position));
    }

    @Test
    public void testIsEmptyFalse() {
        System.out.println("testIsEmptyFalse");
        Piece piece = new Piece(PlayerColor.BLACK);
        Position position = new Position(3, 3);
        Board instance = new Board();
        instance.put(piece, position);
        assertFalse(instance.isEmpty(position));
    }

    @Test
    public void testIsMyColorTrue() {
        System.out.println("testIsMyColorTrue");
        Piece piece = new Piece(PlayerColor.WHITE);
        Position position = new Position(3, 3);
        Board instance = new Board();
        instance.put(piece, position);
        assertTrue(instance.isMyColor(position, PlayerColor.WHITE));
    }

    @Test
    public void testIsMyColorFalse() {
        System.out.println("testIsMyColorFalse");
        Piece piece = new Piece(PlayerColor.BLACK);
        Position position = new Position(3, 3);
        Board instance = new Board();
        instance.put(piece, position);
        assertFalse(instance.isMyColor(position, PlayerColor.WHITE));
    }

    @Test
    public void testGetTakenSquare() {
        System.out.println("testGetTakenSquare");
        Piece pieceB = new Piece(PlayerColor.BLACK);
        Piece pieceB1 = new Piece(PlayerColor.BLACK);
        Piece pieceW = new Piece(PlayerColor.WHITE);
        Position position = new Position(3, 3);
        Position position1 = new Position(4, 3);
        Position position2 = new Position(5, 3);
        Player player = new Player(BLACK);
        Board instance = new Board();
        instance.put(pieceB, position);
        instance.put(pieceW, position1);
        instance.put(pieceB1, position2);
        instance.getTakenSquare(player);
    }

    @Test
    public void testNextDir() {
        System.out.println("testNextDir");
        Piece pieceB = new Piece(PlayerColor.BLACK);
        Piece pieceW = new Piece(PlayerColor.WHITE);

        Position position = new Position(3, 3);
        Position position1 = new Position(4, 3);

        Board instance = new Board();
        instance.put(pieceB, position1);
        instance.put(pieceW, position);

        Position expResult = instance.nextDir(Direction.DOWN, position);
        Position result = new Position(5, 3);
        assertEquals(expResult, result);
    }
}
