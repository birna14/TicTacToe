package is.ru.hugb;

public class Game {
	public enum State {
	  PLAYING, DRAW, X_WON, O_WON
	}
	private Board board;            // the game board
  private State currentState; // the current state of the game (of enum tate)
  private char currentPlayer; 		// the player

	private static final char PLAYER_O = 'o';
	private static final char PLAYER_X = 'x';

	public Game() {
		currentPlayer = 'x';
		initializeGame();
	}

	//TODO:
	//public playGame();
	public void initializeGame() {
		 currentState = State.PLAYING; // ready to play
	}
	//TODO:
	//public int takeTurn();

	public char changePlayer(char player){
		if(player == PLAYER_O)
			return PLAYER_X;
		else{
			return PLAYER_O;
		}
	}
}
