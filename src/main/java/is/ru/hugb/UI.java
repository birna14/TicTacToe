package is.ru.hugb;

import java.util.Scanner;

import static spark.Spark.*;

public class UI {

  // prints the board of the given game
    public static String printBoard(Game game) {
      String out = "";
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            out += game.getBoard()[i][j];
            if(j != 3 - 1)
              out += ("   |   ");
          }
        out += "<br>";
        if(i != 3 - 1) {
            out += "-----------";
        }
      }
      out += "<br>";
      return out;
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
    // In order for this to work on Heroku, we need to allow Heroku to set the port number

      port(getHerokuPort());
      get("/", (req, res) -> {
            Game game = new Game();
            UI ui = new UI();
            return ui.printBoard(game);

          });
      }

      static int getHerokuPort() {
        ProcessBuilder psb = new ProcessBuilder();
        if (psb.environment().get("PORT") != null) {
          return Integer.parseInt(psb.environment().get("PORT"));
        }
        return 4567;
      }
/*
      final String portNumber = System.getenv("PORT");
          if (portNumber != null) {
              Spark.port(Integer.parseInt(portNumber));
          }
              get("/", (req, res) -> { return "Helloooo!"; });
      }


/*

port(getHerokuPort());
      get("/", (req, res) -> {
          return "Virkar!";
      });
      get(
          "/add/:input",
          (req, res) -> add(req.params(":input"))
      );
  }


  }
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
    }*/
}
