/**
 * File for the TicTacToe exercise.
 * Represents a code which creates Game.
 * The Game can :
 * run a game of TicTacToe game.
 * @author Meitav Mortov Ovadya
 */


import java.util.*;
class Game {
    private Player playerX;
    private Player playerO;
    private Renderer renderer;
    private Board board;

    /**
     * Constructor.
     * Initializes game
     * @param  playerX the player that x is his mark.
     * @param  playerO the player that O is his mark.
     * @param  renderer that present the game.
     */
    public Game(Player playerX, Player playerO, Renderer renderer){
        this.playerO = playerO;
        this.playerX  = playerX;
        this.renderer = renderer;
        this.board = new Board();
    }

    /**
     * method that run the game.
     * @return Mark the winner of the game.
     */
    public Mark run() {
        int counter = 0;
        Player[] players = { playerX, playerO };
        Mark[] marks = { Mark.X, Mark.O };
        while (!board.gameEnded()){
            renderer.renderBoard(board);
            players[counter%2].playTurn(board, marks[counter%2]);
            renderer.renderBoard(board);
            counter += 1;
        }
        return board.getWinner();
    }

}