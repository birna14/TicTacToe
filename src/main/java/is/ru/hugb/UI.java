package is.ru.hugb;

import java.util.Scanner;

public class UI {

  // prints the board of the given game
    public static void printBoard(Game game) {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            System.out.print(game.getBoard()[i][j]);
            if(j != 3 - 1)
              System.out.print(" | ");
          }
        System.out.println();
        if(i != 3 - 1){
            System.out.println("-----------");
        }

        }
        System.out.println();

    }

   private static int validateInput(Scanner scan){
    while (!scan.hasNextInt()){
      System.out.println("please enter two numbers, 0, 1 or 2");
      scan.next();
    } 
    return scan.nextInt();
  }

    // here the game is played

    public static void main(String[] args) {
      Game currentGame = new Game();
      Scanner scan = new Scanner(System.in);
      int row, col;
      System.out.println("New game, X starts.");
      do {
        printBoard(currentGame);

        // user inputs two numbers (0, 1), (2,0)...
        System.out.println("It's your turn, " + currentGame.getPlayer() + ", please enter two numbers, 0, 1 or 2");
        row = validateInput(scan);
        col = validateInput(scan);
        while(!currentGame.setCell(row, col)){
          System.out.println("Not a valid move, try again");
          row = scan.nextInt();
          col = scan.nextInt();
        }
      }
      while (currentGame.getState() == Game.State.PLAYING);

      // determines a win and prints the winner
      if (currentGame.getState() == Game.State.WIN) {
        printBoard(currentGame);

        System.out.println(currentGame.getPlayer() + " is the winner");
      }
      // determines a draw
      else if (currentGame.getState() == Game.State.DRAW) {
        printBoard(currentGame);
        System.out.println("It's a draw!");
      }
      // play again?
    }
}
