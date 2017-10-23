package is.ru.hugb;

public class UI {
    public static void printBoard() {
        Board b = new Board();
        char[][] board = b.getBoard();
        for (int i = 0; i < 3; i++) {
          System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

    public static void main(String[] args) {
      Board b = new Board();
      Game g = new Game();

      printBoard();
    }
    // annað fall sem sér um að prenta X og O?
}
