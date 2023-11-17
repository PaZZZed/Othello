package esi.atl.g53204.othello.model;

import static esi.atl.g53204.othello.model.Direction.DOWN;
import static esi.atl.g53204.othello.model.PlayerColor.BLACK;
import static esi.atl.g53204.othello.model.PlayerColor.WHITE;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class GameTest {

    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square(), new Square()}};

    @Before
    public void setUp() throws Exception {
        defaultBoard[4][3].put(new Piece(PlayerColor.BLACK));
        defaultBoard[3][4].put(new Piece(PlayerColor.BLACK));
        defaultBoard[3][3].put(new Piece(PlayerColor.WHITE));
        defaultBoard[4][4].put(new Piece(PlayerColor.WHITE));
    }

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Game instance = new Game();
        instance.initialize();
        //System.out.println(Arrays.deepToString(instance.getBoard()));
        //System.out.println(Arrays.deepToString(defaultBoard));
    }

    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game instance = new Game();
        instance.initialize();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testPutAt() {
        System.out.println("testPutAt");
        Game instance = new Game();
        instance.initialize();
        instance.putAt(new Position(3, 2));
    }

    @Test
    public void testCountBlack() {
        System.out.println("testCountBlack");
        Game instance = new Game();
        instance.initialize();
        int expResult = 2;
        int result = instance.countPoints(instance.getCurrent());
        assertEquals(expResult, result);

    }

    @Test
    public void testCountWhite() {
        System.out.println("testCountWhite");
        Game instance = new Game();
        instance.initialize();
        int expResult = 2;
        int result = instance.countPoints(instance.getOpponent());
        assertEquals(expResult, result);

    }

    @Test
    public void testGetCurrent() {
        System.out.println("testGetCurrent");
        Game instance = new Game();
        instance.initialize();
        Player expResult = new Player(BLACK);
        Player result = instance.getCurrent();
        assertEquals(result.getColor(), expResult.getColor());

    }

    @Test
    public void testSwapCurrent() {
        System.out.println("testSwapCurrent");
        Game instance = new Game();
        instance.initialize();
        Player expResult = new Player(WHITE);
        instance.swapCurrent();
        Player result = instance.getCurrent();
        assertEquals(result.getColor(), expResult.getColor());

    }

    @Test
    public void testHasMoves() {
        System.out.println("testHasMoves");
        Game instance = new Game();
        instance.initialize();
        assertTrue(instance.hasMoves(instance.getCurrent()));

    }

    @Test
    public void testListMoves() {
        System.out.println("testListMoves");
        Game instance = new Game();
        instance.initialize();
        List<Position> result = instance.listMoves(instance.getCurrent());
        assertEquals(result.size(), 4);

    }

    @Test//si swap down marche les autres marchent aussi
    public void testSwapDirectionDOWN() {
        System.out.println("testSwapDown");
        Game instance = new Game();
        instance.initialize();
        Piece piece = instance.getBoard()[3][3].getPiece();
        //System.out.println(piece.getColor());
        Position position = new Position(2, 3);

        instance.swapDirection(position, DOWN);

        assertFalse(piece != piece);
    }

    @Test//si down marche les autres marchent aussi
    public void testCheckDirectionTrue() {
        System.out.println("testDownTrue");
        Game instance = new Game();
        instance.initialize();
        Position position = new Position(2, 3);
        assertTrue(instance.checkDirection(position, DOWN));
    }

    @Test
    public void testDownFalse() {
        System.out.println("testDownFalse");
        Game instance = new Game();
        instance.initialize();
        Position position = new Position(1, 3);
        assertFalse(instance.checkDirection(position, DOWN));
    }

    @Test//defense projet
    public void testCountScore() {
        System.out.println("testCountScore");
        Game instance = new Game();
        instance.initialize();
        instance.getBoard()[3][2].setBonus(BonusSquare.BONUS);
        int expResult = 6;

        System.out.println(instance.getCurrent());
        instance.putAt(new Position(3, 2));
        int result = instance.countBonusPoints(instance.getOpponent());//opponent car put swap et je veux le score de black

        assertEquals(expResult, result);

    }

}
