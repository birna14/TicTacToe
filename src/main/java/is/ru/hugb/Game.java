package is.ru.hugb;

public class Game {
	public enum State {
	  PLAYING, DRAW, WIN
	}
  private Board board;            // the game board
  private State currentState; // the current state of the game (of enum tate)
  private char currentPlayer; 		// the player

	private final char PLAYER_O = 'o';
	private final char PLAYER_X = 'x';

	public Game() {
		currentPlayer = PLAYER_X;
		currentState = State.PLAYING;
		board = new Board();
	}

	public State getState() {
		return currentState;
	}

	public char getPlayer() {
		return currentPlayer;
	}

	public Boolean setCell(int row, int col) {
		if(board.checkLegalMove(row, col)) {
			board.updateCell(currentPlayer, row, col);
			if(board.checkWin()) {
				currentState = State.WIN;
				return true;
			}
			else if (board.isFull()) {
				currentState = State.DRAW;
				return true;
			}

			if (currentPlayer == PLAYER_X) {
				currentPlayer = PLAYER_O;
			}
			else {
				currentPlayer = PLAYER_X;
			}
			return true;
		}
		return false;
	}

	public char changePlayer(char player){
		if(player == PLAYER_O)
			return PLAYER_X;
		else{
			return PLAYER_O;
		}
	}
	//fall sem sendir borð leiksins áfram
	public char[][] getBoard() {
		return board.getBoard();
	}
}
