package is.ru.hugb;

import java.util.Scanner;

public class UI {
    public static void printBoard(Game game) {
        for (int i = 0; i < 3; i++) {
          System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.println(game.getBoard()[i][j]);
            }
        }
    }

    public static void main(String[] args) {
      Game currentGame = new Game();
      Scanner scan = new Scanner(System.in);

      int row, col;
      do {
        System.out.println("New game starting");
        printBoard(currentGame);
        row = scan.nextInt();
        col = scan.nextInt();
        currentGame.setCell(row, col);
      }
      while (currentGame.getState() == Game.State.PLAYING);

      if (currentGame.getState() == Game.State.WIN) {
        System.out.println(currentGame.getPlayer() + " is the winner");
      }
      else if (currentGame.getState() == Game.State.DRAW) {
        System.out.println("It's a draw!");
      }
      //
    }
}
