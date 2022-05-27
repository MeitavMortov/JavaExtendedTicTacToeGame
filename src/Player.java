/**
 * File for the TicTacToe exercise.
 * Represents a code which creates Player interface.
 * The Player can :
 * play a turn of a given mark on a given board.
 * @author Meitav Mortov Ovadya
 */



import  java.util.Scanner;

interface Player {

    /**
     * method that play Turn of a given Mark in a given board .
     * return boolean true if the coordinates are valid, else return false.
     * @param boardToPlayOn board to play on the turn.
     * @param  playerMark - the mark of the player that play turn.
     */
    void playTurn(Board boardToPlayOn, Mark playerMark);
}