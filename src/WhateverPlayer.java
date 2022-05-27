/**
 * File for the TicTacToe exercise.
 * Represents a code WhateverPlayer.
 *  WhateverPlayer implements the Player interface.
 * The WhateverPlayer can :
 * play  a turn of a given mark on a given board.
 * He plays randomly.
 * @author Meitav Mortov Ovadya
 */

import java.util.Random;

class WhateverPlayer implements Player{
    private Random rand = new Random();
    public WhateverPlayer() {

    }

    /**
     * method that play Turn of a given Mark in a given board .
     * return boolean true if the coordinates are valid, else return false.
     *  # My strategy regarding the whatever player
     *  is finding all the blanks and than randomally
     *  choose one blank position.
     * @param boardToPlayOn board to play on the turn.
     * @param  playerMark - the mark of the player that play turn.
     */
    @Override
    public void playTurn(Board boardToPlayOn, Mark playerMark){
        int[][] arrayOfBlanks = getArrayOfBlanks(boardToPlayOn);
        if (arrayOfBlanks == null) {          //reserve: it should not be:
            return;
        }
        int randomPosition = rand.nextInt(arrayOfBlanks.length);
        int row = arrayOfBlanks[randomPosition][0];
        int col = arrayOfBlanks[randomPosition][1];
        boardToPlayOn.putMark(playerMark, row, col);
    }

    /**
     * method that gets array of the blanks coordinates in a given board .
     * return array of the blanks coordinates.
     * @param  board board to check on.
     * @return array of arrays of two integers.
     *  the inner arrays represents blanks coordinates in the given board.
     */
    private int[][] getArrayOfBlanks(Board board){
        int arrayLength = getNumOfBlanks(board);
        if (arrayLength == 0){
            return null;
        }
        int[][] arrayOfBlanks = new int[arrayLength][2];
        int  indexArray = 0;
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++){
                if (board.getMark(row,col) == Mark.BLANK) {
                    arrayOfBlanks[indexArray][0] = row;
                    arrayOfBlanks[indexArray][1] = col;
                    indexArray += 1;
                }
            }
        }
        return arrayOfBlanks;
    }

    /**
     * This method find num of blanks in the given board.
     * @param  board board to check on.
     * @return integer represents the  num of blanks in the given board.
     */
    private int getNumOfBlanks(Board board){
        //find num of blanks in the given board:
        int blanksCounter = 0;
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++){
                if (board.getMark(row,col) == Mark.BLANK) {
                    blanksCounter+=1;
                }
            }
        }
        return blanksCounter;
    }
}

