/**
 * File for the TicTacToe exercise.
 * Represents a code which creates PPlayerFactory.
 * The PlayerFactory can :
 * build a player of a specific given type.
 * @author Meitav Mortov Ovadya
 */

class PlayerFactory{

    /**
     * This method builds a player of a specific given type.
     * @param  playerType a string represents the player Type  to build.
     * @return Player of a specific given type, if type was valid return null player.
     */
    public Player buildPlayer(String playerType){
        Player player;
        switch(playerType) {
            case "clever":
                player = new CleverPlayer();
                break;
            case "whatever":
                player = new WhateverPlayer();
                break;
            case "human":
                player = new HumanPlayer();
                break;
            case "snartypamts":
                player = new SnartypamtsPlayer();
                break;
            default:
                player = null;
                break;

        }
        return player;
    }

}


