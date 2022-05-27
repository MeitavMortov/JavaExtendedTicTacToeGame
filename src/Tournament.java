/**
 * File for the TicTacToe exercise.
 * Represents a code Tournament.
 * The Tournament can :
 * play Tournament with properties from the parameters he received
 * @author Meitav Mortov Ovadya
 */



class Tournament{
    private static final int ARG_NUM_OF_ROUNDS 	= 0;
    private static final int ARG_RENDERER_TYPE = 1;
    private static final int ARG_PLAYER_1_TYPE = 2;
    private static final int ARG_PLAYER_2_TYPE = 3;
    private static final int ARGS_NUM = 4;


    private static final int NUM_OF_PLAYERS = 2;
    private int rounds;
    private Renderer renderer;
    private Player[] players;
    private int player1numOfVictories;
    private int player2numOfVictories;
    private int numOfTies;


    /**
     * Constructor.
     * Initializes the Tournament
     * @param  rounds int represent how many games are in the tournament.
     * @param  renderer the type of rendering the board to the user
     * @param  players array of 2 players for the games.
     */
    public Tournament(int rounds, Renderer renderer, Player[] players) {

        this.rounds = rounds;
        this.renderer = renderer;
        this.players = players;
        this.player1numOfVictories = 0;
        this.player2numOfVictories = 0;
        this.numOfTies = 0;
    }

    /**
     * This method  plays a tournament  according to the parameters that the constructor received.
     */
    public void playTournament() {
        int roundCounter = 0;
        int[] numOfVictories = {player1numOfVictories, player2numOfVictories};
        int indexOfXPlayer, indexOfOPlayer;
        while ( roundCounter < rounds) {
            indexOfXPlayer = roundCounter % 2;
            indexOfOPlayer = (indexOfXPlayer + 1) % 2;
            Game currGame = new Game(players[indexOfXPlayer], players[indexOfOPlayer], renderer);
            Mark markOfCurrWinner  = currGame.run();
            if (markOfCurrWinner == Mark.X) {
                numOfVictories[indexOfXPlayer] += 1;
            }
            else if (markOfCurrWinner == Mark.O) {
                numOfVictories[indexOfOPlayer] += 1;
            }
            else{
                numOfTies += 1;
            }
            roundCounter+=1;
        }
        System.out.format("=== player 1: %d | player 2: %d | Draws: %d ===\r",
                numOfVictories[0], numOfVictories[1], numOfTies);
    }


    /**
     * the main method which "make" a full tournament.
     * @param  args the input of the program.
     */
    public static void main(String[] args) {
        if (ARGS_NUM != args.length) {
            System.out.println("Usage: [rounds] [renderer] [player1] [player2]");
            return;
        }
        //assume other arguments are valid
        int rounds = Integer.parseInt(args[ARG_NUM_OF_ROUNDS]);

        RendererFactory rendererFactory = new RendererFactory();
        Renderer renderer = rendererFactory.buildRenderer(args[ARG_RENDERER_TYPE]);

        PlayerFactory playerFactory = new PlayerFactory();
        Player[] players = new Player[NUM_OF_PLAYERS];
        players[0] = playerFactory.buildPlayer(args[ARG_PLAYER_1_TYPE]);
        players[1] = playerFactory.buildPlayer(args[ARG_PLAYER_2_TYPE]);

        Tournament tournament = new Tournament(rounds, renderer, players);
        tournament.playTournament();
    }
}


