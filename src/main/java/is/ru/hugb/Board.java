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
       public Boolean checkWin(char[][] board){
          if(checkWinRow(board) || checkWinCol(board) || checkWinDiag(board)) {
            return true;
          }
          else {
            return false;
          } 
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

        private Boolean checkWinRow(char[][] board){
          if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][0] == 'x' || board[0][0] == 'o')) {
            return true;
          }
          else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][1] == 'x' || board[0][1] == 'o')) {
            return true;
          } 
          else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] == 'x' || board[0][2] == 'o')) {
            return true;
          }
          else return false;
        }

        private Boolean checkWinCol(char[][] board){
          if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][0] == 'x' || board[0][0] == 'o')) {
            return true;
          } 
          else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[1][0] == 'x' || board[1][0] == 'o')) {
              return true;
          } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[2][0] == 'x' || board[2][0] == 'o')) {
              return true;
         }
         else return false;
       }

       private Boolean checkWinDiag(char[][] board){
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'x' || board[0][0] == 'o')) {
            return true;
          } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && (board[2][0] == 'x' || board[2][0] == 'o')) {
              return true;
          }
          else return false;
     }
}
