/**
 * File for the TicTacToe exercise.
 * Represents a code which creates HumanPlayer.
 *  HumanPlayer implements the Player interface.
 * The HumanPlayer can :
 * play a turn of a given mark on a given board
 * @author Meitav Mortov Ovadya
 */



import  java.util.Scanner;

class HumanPlayer implements Player{

    /**
     * Constructor.
     */
    public HumanPlayer() {

    }

    /**
     * method that play Turn of a given Mark in a given board .
     * return boolean true if the coordinates are valid, else return false.
     * @param boardToPlayOn board to play on the turn.
     * @param  playerMark - the mark of the player that play turn.
     */
    @Override
    public void playTurn(Board boardToPlayOn, Mark playerMark){

        //while  input not valid == board.putMark return false continue
        //dont forget to match the oardinate -1 etc (from user to the method)
        if (!isBoardHasBlanks(boardToPlayOn)){
            return;
        }
        //get input fro user
        Scanner scannerUserInput = new Scanner(System.in);
        boolean isUserInputValid = false; //false because no input inputed
        int UserInputInt;
        System.out.println("Player " + playerMark + ", type coordinates: ");
        while(!isUserInputValid) {
            UserInputInt = scannerUserInput.nextInt();
            // on forum : UserInputInt is not negative, and shalem
            int row =  UserInputInt/10 - 1;
            int col =  UserInputInt%10 - 1;
            isUserInputValid = boardToPlayOn.putMark(playerMark, row, col);
            if (!isUserInputValid){
                System.out.println("Invalid coordinates, type again: ");
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
        boolean isBoardHasBlanks = false;
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++){
                if (board.getMark(row,col) == Mark.BLANK) {
                    isBoardHasBlanks = true;
                    break;
                }
            }
        }
        return isBoardHasBlanks;
    }

}
