package is.ru.hugb;

public class Board {
        private static char[][] board;
        private static int row;
	private static int col;

        public Board(int size) {
		row = 3;
		col = 3;
                board = new char[row][col];
        }

        //TODO
       public static Boolean checkLegalMove() {
                return true;
        }

        //TODO
       public Boolean checkWin(){
                return true;
       }

        //TODO
        public Boolean isFull(){
               	// tvöföld forlúppa og ef ekkert hólf er empty skilar fallið true, annars false
		return true;
        }
}

