/**
 * File for the TicTacToe exercise.
 * Represents a code which creates VoidRenderer.
 * VoidRenderer implements the Renderer interface.
 * the VoidRenderer can:
 * render Board which means to not print the supplied board.
 * @author Meitav Mortov Ovadya
 */

class VoidRenderer implements Renderer{

    /**
     * Does not print the supplied board.
     * @param board the board to print.
     */
    @Override
    public void renderBoard(Board board){
        //do nothing!
    }
}