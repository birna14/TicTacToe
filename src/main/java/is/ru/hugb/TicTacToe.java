package is.ru.hugb;

public class Board {
	private char[][] board;
	int position;

	public Board(int size) {
		board = new char[3][3];
		
	}
	
	//TODO
	Boolean checkLegalMove() {
		return true;
	}
	
	//TODO
	Boolean checkWin();
	
	//TODO
	Boolean isFull();
}

