package esi.atl.g53204.othello.model;

import static esi.atl.g53204.othello.model.BonusSquare.BONUS;
import java.util.ArrayList;
import java.util.List;

import java.util.Observable;

/**
 *
 * @author Paul
 */
public class Game extends Observable implements Model {

    private Board board;
    private Player opponent;
    private Player current;
    private final List<PlayerMove> playerMove;

    /**
     *
     * constructor of Game, two players current:BLACK opponent:WHITE
     */
    public Game() {
        this.current = new Player(PlayerColor.BLACK);
        this.opponent = new Player(PlayerColor.WHITE);
        this.playerMove = new ArrayList<>();

    }

    /**
     * initialize the board with four pieces in the center by the rules of
     * othello
     */
    @Override
    public void initialize() {
        this.board = new Board();

        this.board.put(new Piece(PlayerColor.WHITE), new Position(3, 3));
        this.board.put(new Piece(PlayerColor.WHITE), new Position(4, 4));
        this.board.put(new Piece(PlayerColor.BLACK), new Position(3, 4));
        this.board.put(new Piece(PlayerColor.BLACK), new Position(4, 3));
        this.board.addBonus();
        notif();

    }

    /**
     *
     * @return the board(2Darray)
     */
    @Override
    public Square[][] getBoard() {
        return board.getSquares();
    }

    /**
     *
     * @return the current player
     */
    @Override
    public Player getCurrent() {
        return this.current;
    }

    /**
     *
     * @return the opponent player
     */
    @Override
    public Player getOpponent() {
        return opponent;
    }

    /**
     * count the number of pieces on the board for a player
     *
     * @return
     */
    @Override
    public int countPoints(Player player) {
        int points = 0;

        for (int i = 0; i < board.getTakenSquare(player).size(); i++) {

            points++;

        }

        return points;

    }

    /**
     * compte le score total du joueur avec les cases bonus
     *
     * @param player
     * @return
     */
    @Override
    public int countBonusPoints(Player player) {
        int points = 0;

        for (int i = 0; i < board.getTakenSquare(player).size(); i++) {
            int row = board.getTakenSquare(player).get(i).getRow();
            int col = board.getTakenSquare(player).get(i).getColumn();

            if (board.getSquares()[row][col].getBonus() == BONUS) {
                points = points + 3;
            } else {
                points++;
            }

        }

        return points;

    }

    /**
     * swap between current and opponent
     */
    @Override
    public void swapCurrent() {
        Player swap = opponent;
        opponent = current;
        current = swap;
        notif();
    }

    /**
     *
     * @param player
     * @return true if the player has moves if not false
     */
    @Override
    public boolean hasMoves(Player player) {

        return listMoves(player).size() > 0;

    }

    /**
     *
     * @param player
     * @return the list of moves for a player
     */
    @Override
    public List<Position> listMoves(Player player) {
        List<Position> pos = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            for (Position takenSquare : board.getTakenSquare(player)) {
                if (board.nextDir(direction, takenSquare) != null
                        && board.getSquareAt(takenSquare.next(direction)).getPiece() != null
                        && !board.isMyColor(takenSquare.next(direction), player.getColor())) {//eviter les bords 
                    pos.add(board.nextDir(direction, takenSquare));
                }
            }
        }

        return pos;

    }

    /**
     * put a piece at the given position on the board and then swap the pieces
     * if the rules of othello applies
     *
     * @param position
     */
    @Override
    public void putAt(Position position) {
        boolean canput = false;

        for (Direction direction : Direction.values()) {
            if (checkDirection(position, direction)) {
                swapDirection(position, direction);
                canput = true;
            }
        }
        if (canput) {
            board.put(new Piece(current.getColor()), position);
            swapCurrent();
        }
        notif();//dire aux observers que y a eu
    }

    /**
     * swap pieces in chosen direction
     *
     * @param position
     * @param direction
     */
    public void swapDirection(Position position, Direction direction) {
        Position nextPosition = position.next(direction);
        while (board.isInsideBoard(nextPosition.next(direction)) && !board.getSquareAt(nextPosition).isFree()) {
            if (board.isMyColor(nextPosition, current.getColor())) {
                break;
            }
            board.getSquareAt(nextPosition).getPiece().flip();

            nextPosition = nextPosition.next(direction);
        }
    }

    /**
     * check if we can place the piece in chosen direction at the given position
     *
     * @param position
     * @param direction
     * @return
     */
    public boolean checkDirection(Position position, Direction direction) {
        Position nextPosition = position.next(direction);
        if (!board.isInsideBoard(nextPosition) || board.isEmpty(nextPosition) || board.isMyColor(nextPosition, current.getColor())) {
            return false;
        }
        while (board.isInsideBoard(nextPosition.next(direction)) && !board.isEmpty(nextPosition)) {
            nextPosition = nextPosition.next(direction);
            if (board.isMyColor(nextPosition, current.getColor())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return the player who has the more pieces only one winner
     */
    @Override
    public Player getWinner() {

        if (countPoints(current) > countPoints(opponent)) {
            return new Player(current.getColor());
        } else if (countPoints(current) < countPoints(opponent)) {
            return new Player(opponent.getColor());
        }
        return null;

    }

    /**
     *
     * @return list of PlayerMove(actions)
     */
    public List<PlayerMove> getPlayerMove() {

        return playerMove;

    }

    /**
     * nottify changes
     */
    public void notif() {
        this.setChanged();
        this.notifyObservers();

    }
}
