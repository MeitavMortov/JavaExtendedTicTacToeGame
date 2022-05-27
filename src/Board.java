/**
 * File for the TicTacToe exercise.
 * Represents a code which creates Board.
 * The Board can :
 * 1 players need them to display their markings.
 * 2. The board should know when the game is over and how.
 * 3. The board should provide us with information about the markings
 * in the various coordinates
 * @author Meitav Mortov Ovadya
 */

class Board{

    /**
     * A constant that represents the size of the board
     * It is a constant (static final).
     */

    public static final int SIZE = 6;
    /**
     * A constant representing the sequence required for victory.
     * It is a constant (static final).
     */
    public static final int WIN_STREAK = 4;



    private Mark[][] board = new Mark[SIZE][SIZE];
    private Mark winnerOfGame = Mark.BLANK;
    private boolean signIfGameEnded = false;
    private int numOfFullPositions = 0;

    /**
     * Constructor.
     * Initializes the board in Blank's
     */
    public Board(){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++){
                this.board[row][col] = Mark.BLANK;

            }
        }
    }

    /**
     * method that put mark on the board and
     * return bolean true if successd puting mark, else return false.
     * @param  mark the mark to put on the board.
     * @param  row the num of row in the board
     * @param  col the num of column in the board.
     * @return true if the puting mark succeed, false otherwise.
     */
    public boolean putMark(Mark mark, int row, int col) {
        if (!checkValidityOfCoordinates(row, col)) {
            return false;
        }
        //coardinates are valid
        if (!checkIfPositionIsBlank(row, col)) {
            return false;
        }
        else {  //coardinates are valid and the position is Blank
            this.board[row][col] = mark;
            this.numOfFullPositions += 1;
            updateGameStatus(mark, row, col);
            return true;
        }
    }


    /**
     * method that check Validity Of Coordinates
     * return bolean true if the coordinates are valid, else return false.
     * @param  row the num of row in the board
     * @param  col the num of column in the board.
     * @return true if the coordinates are valid, false otherwise.
     */
    private boolean checkValidityOfCoordinates(int row, int col) {
        //return true if valid
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * method that check If Position Is Blank
     * return bolean true if the position is blank, else return false.
     * @param  row the num of row in the board
     * @param  col the num of column in the board.
     * @return true if the position is blank, false otherwise.
     */
    private boolean checkIfPositionIsBlank(int row, int col) {
        //return true if Blank
        //called only if row and col are valid
        if (this.board[row][col] == Mark.BLANK) {
            return true;
        }
        else {
            //the position is X or O
            return false;
        }
    }

    /**
     * method that update Game Status ecording to a new mark on the board.
     * its update if the game is there is a victorty or tie.
     * @param  mark the mark to put on the board.
     * @param  row the num of row in the board
     * @param col the num of column in the board.
     */
    private void updateGameStatus(Mark mark, int row, int col) {
        //check if has a sequence WIN_STREAK
        //if true: updates winnerOfGame, signIfGameEnded than return
        if (markIsTheWinner(mark)) {
            winnerOfGame = mark;
            signIfGameEnded = true;
            return;
        }
        //else
        //check if its a teko
        //if true: updates winnerOfGame, signIfGameEnded
        if (tieIsTheGameResult()) {
            winnerOfGame = Mark.BLANK;
            signIfGameEnded = true;
        }
    }

    /**
     * method that check if Mark Is The Winner.
     * return bolean true if Mark Is The Winner, else return false.
     * @param  mark the mark to put on the board.
     * @return true if Mark Is The Winner, false otherwise.
     */
    private boolean markIsTheWinner(Mark mark){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++){
                if (markHasWinStreak(mark, row, col)){
                    return true;
                }
            }
        }
        return false;
    }



    /**
     * method that check if Tie Is The Game Result.
     * @return true if Tie Is The Game Result, false otherwise.
     */
    private boolean tieIsTheGameResult() {
        return (numOfFullPositions == SIZE*SIZE);
    }

    /**
     * method that check if mark Has Win Streak in all the possible directions.
     * return bolean true if mark Has Win Streak, else return false.
     * @param  mark the mark to put on the board.
     * @param  row the num of row in the board
     * @param  col the num of column in the board.
     * @return true if mark Has Win Streak, false otherwise.
     */
    private boolean markHasWinStreak(Mark mark, int row, int col) {
        if (
                countMarkInDirection(row,col,0, 1, mark) == WIN_STREAK
                        || countMarkInDirection(row,col,0, -1, mark) == WIN_STREAK
                        || countMarkInDirection(row,col,-1, 0, mark) == WIN_STREAK
                        || countMarkInDirection(row,col,1, 0, mark) == WIN_STREAK
                        || countMarkInDirection(row,col,-1, 1, mark) == WIN_STREAK
                        || countMarkInDirection(row,col,1, -1, mark) == WIN_STREAK
                        || countMarkInDirection(row,col,1, 1, mark) == WIN_STREAK
                        || countMarkInDirection(row,col,-1, -1, mark) == WIN_STREAK) {

            return true;
        }
        return false;
    }


    /**
     * method that count Mark In a given direction.
     * @param  row the num of row in the board
     * @param  col the num of column in the board.
     * @param  rowDelta presents the row direction.
     * @param  colDelta presents the col direction.
     * @param  mark the mark to put on the board.
     * @return int that present how many mark were in sequence in the direction.
     */
    private int countMarkInDirection(
            int row, int col, int rowDelta, int colDelta, Mark mark) {
        int count = 0;
        while(row < SIZE && row >= 0 && col < SIZE &&
                col >= 0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }

    /**
     * this method  get Mark in the posision that match board(to row, col).
     * @param  row the num of row in the board
     * @param  col the num of column in the board.
     * @return Mark mark that match board(to row, col).
     */
    public Mark getMark(int row, int col) {
        if (!checkValidityOfCoordinates(row, col)) {
            return Mark.BLANK;
        }
        else {
            //cooarsinates are valid
            return this.board[row][col];
        }
    }

    /**
     * this method  return true if game Ended.
     * @return true if if game Ended, false otherwise.
     */
    public boolean gameEnded() {
        return this.signIfGameEnded;

    }

    /**
     * this method  return the winner of the  game.
     * @return Mark of the winner, if there is tie or game didnt ended return blank.
     */
    public Mark getWinner() {
        return this.winnerOfGame;
    }
}
