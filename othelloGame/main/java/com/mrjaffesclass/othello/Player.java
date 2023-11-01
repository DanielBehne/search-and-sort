package main.java.com.mrjaffesclass.othello;
import java.util.ArrayList;

/**
 * Player object. Students will extend this class
 * and override the getNextMove method
 * 
 * @author Mr. Jaffe
 * @version 1.0
 */
public class Player
{
    private final int color;

    /**
     * Player constructor
     * @param color   One of Constants.WHITE or Constants.BLACK
     */
    public Player(int color) {
        this.color = color;
    }

    /**
     * Gets the player color
     * @return        Player color
     */
    public int getColor() {
        return this.color;
    }

    /**
     * Gets the player name
     * @return        Player name
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * The player must override getNextMove
     * @param board Game board
     * @return A position coordinate pair of his/her next move. Returns null
     *          if no move is available
     */
    Position getNextMove(Board board) {
        Position position = new Position(2, 3);
        Player p = new Player(-1);
        //Position nextMove = p.getNextMove(board);
        
        if (isLegalMove(board, position)) {
            return position;
        } else {
            return null;
        }

    }

    /**
     * Get the legal moves for this player on the board
     * @param board
     * @return True if this is a legal move for the player
     */
    public ArrayList<Position> getLegalMoves(Board board) {
        int color = this.getColor();
        ArrayList list = new ArrayList<>();
        for (int row = 0; row < Constants.SIZE; row++) {
            for (int col = 0; col < Constants.SIZE; col++) {
                if (board.getSquare(this, row, col).getStatus() == Constants.EMPTY) {
                    Position testPosition = new Position(row, col);
                    if (this.isLegalMove(board, testPosition)) {
                        list.add(testPosition);
                    }
                }        
            }
        }
        return list;
    }

    /**
     * Is this a legal move?
     * @param player Player asking
     * @param positionToCheck Position of the move being checked
     * @return True if this space is a legal move
     */
    private boolean isLegalMove(Board board, Position positionToCheck) {
        for (String direction : Directions.getDirections()) {
            Position directionVector = Directions.getVector(direction);
            if (step(board, positionToCheck, directionVector, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean step(Board board, Position position, Position direction, int count) {
        Position newPosition = position.translate(direction);
        int color = this.getColor();
        if (newPosition.isOffBoard()) {
            return false;
        } else if (board.getSquare(newPosition).getStatus() == -color) {
            return this.step(board, newPosition, direction, count+1);
        } else if (board.getSquare(newPosition).getStatus() == color) {
            return count > 0;
        } else {
            return false;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }

    
    /**
     * Are this player and the passed-in player the same?
     * @param p Passed-in player
     * @return true if the players are the same
     */
    boolean isThisPlayer(Player p) {
        return p.getColor() == this.getColor();
    }

    /**
     * Are this color and the passed-in color the same?
     * @param p Passed-in color (represented as an integer)
     * @return true if the colors (integers) are the same
     */
    boolean isThisPlayer(int p) {
        return p == this.getColor();
    }

    @Override
    public String toString() {
        switch (this.color) {
            case Constants.BLACK:
                return this.getName()+" (BLACK)";
            case Constants.WHITE:
                return this.getName()+" (WHITE)";
            default:
                return this.getName()+" (?????)";
        }
    }

}
