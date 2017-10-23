package is.ru.hugb;

public class Board {
        private static char[][] board;
        private static int row;
        private static int col;

        public Board(int size) {
            row = 3;
            col = 3;

            board = setupBoard();
        }


        public char[][] setupBoard() {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j] = ' ';
                }
            }
            return board;
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
        public static Boolean isFull(){
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // if some cell is empty the board is not full
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
}
