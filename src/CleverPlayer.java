/**
 * File for the TicTacToe exercise.
 * Represents a code CleverPlayer.
 *  CleverPlayer implements the Player interface.
 * The CleverPlayer can :
 * play  a turn of a given mark on a given board
 * most of the  time he wins the whatever player.
 * @author Meitav Mortov Ovadya
 */


import java.util.Random;

class CleverPlayer implements Player{

    private Random rand = new Random();

    /**
     * method that play Turn of a given Mark in a given board .
     * return boolean true if the coordinates are valid, else return false.
     * # My strategy regarding the smart player is to choose a random slot from
     * a specific line, (and thus go beyond the possible lines as long
     * as we have not been able to fill the turn)
     * so that most of the time he wins the player
     *  who plays in a completely random player- whatever.
     * @param boardToPlayOn board to play on the turn.
     * @param  playerMark - the mark of the player that play turn.
     */
    @Override
    public void playTurn(Board boardToPlayOn, Mark playerMark){
        if (!isBoardHasBlanks(boardToPlayOn)){
            return;
        }
        for(int row = 0; ;row++){
            int counter = 0;
            while (counter < Board.SIZE) {
                int col = rand.nextInt(Board.SIZE);
                if (boardToPlayOn.putMark(playerMark, row%Board.SIZE, col)) {
                    return;
                }
                counter += 1 ;
            }
        }
    }

    /**
     * This method checks  if Board Has Blanks.
     * @param  board board to check on.
     * @return true if Board Has Blanks, false otherwise.
     */
    private boolean isBoardHasBlanks(Board board){
        //check if the board is full:
        int blanksCounter = 0;
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++){
                if (board.getMark(row,col) == Mark.BLANK) {
                    return true;
                }
            }
        }
        return false;
        }
    }
