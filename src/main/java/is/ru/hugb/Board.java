package is.ru.hugb;

public class Board {
        private static char[][] board;
        private static final int row = 3;
        private static final int col = 3;

        private static final char EMPTY = ' ';
        private static final char PLAYER_O = 'o';
        private static final char PLAYER_X = 'x';

        public Board() {
          board = new char[row][col];
          
          for (int i = 0; i < row; i++) {
              for (int j = 0; j < col; j++) {
                  board[i][j] = EMPTY;
              }
          }
        }

        //TODO
       public static Boolean checkLegalMove(int row, int col) {
          if((row > 2 || row < 0) || (col > 2 || col < 0))
            return false;
          else if(board[row][col] != EMPTY) {
            return false;
          }

          return true;

        }

        //TODO
       public Boolean checkWin(){
          return true;
       }

        //TODO
        public static Boolean isFull(){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // if some cell is empty the board is not full
                    if (board[i][j] == EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }
}
