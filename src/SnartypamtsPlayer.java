/**
 * File for the TicTacToe exercise.
 * Represents a code SnartypamtsPlayer.
 *  SnartypamtsPlayer implements the Player interface.
 * The SnartypamtsPlayer can :
 * play  a turn of a given mark on a given board
 * most of the  time he wins the whatever player and the clever player.
 * @author Meitav Mortov Ovadya
 */


class SnartypamtsPlayer implements Player{

    /**
     * method that play Turn of a given Mark in a given board .
     * return boolean true if the coordinates are valid, else return false.
     * # My strategy regarding the snartypampts player
     * is Select all the squares that can be marked
     * in sequence starting from the last row and the last column.
     * This way he will most of the time win the player who chooses
     * from the first line random choices.
     * @param boardToPlayOn board to play on the turn.
     * @param  playerMark - the mark of the player that play turn.
     */
    @Override
    public void playTurn(Board boardToPlayOn, Mark playerMark){
        for (int row = Board.SIZE - 1; row >= 0; row--) {
            for (int col = Board.SIZE - 1; col >= 0; col--){
                if (boardToPlayOn.putMark(playerMark, row, col)) {
                    //success
                    return;
                }
                }
            }
    }
    //if reached here could not put any mark cause the board is full! therefore- returns.
}