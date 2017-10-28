package is.ru.hugb;

import java.util.Scanner;
import java.net.URLDecoder;

import static spark.Spark.*;

public class UI {

  // prints the board of the given game
    public static String printBoard(Game game) {
      //game.setCell(1,2);
      //game.setCell(0,0);
      String out = "<h1>";
        for (int i = 0; i < 3; i++) {
          out += "<br>";
          for (int j = 0; j < 3; j++) {
				if(game.getBoard()[i][j] == ' '){
					out += "&ensp;";
				}
				else{
					out += game.getBoard()[i][j];
				}
            if(j != 2)
              out += ("   |   ");
          }
        out += "<br>";
        if(i != 2) {
            out += "---------";
        }
     
      }
      return out + "</h1>";
    }
	public static void clearBoard(Game game) {
		for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
                  game.getBoard()[i][j] = ' ';
              }
          }
		  game.resetState();
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
      staticFileLocation("/public");
      port(getHerokuPort());

       Game game = new Game();
       UI ui = new UI();

      post("/add", (req, res) -> {
		  
           String input1 = req.queryParams("input1");
			String input2 = req.queryParams("input2");
			int iInput1 = Integer.parseInt(input1);
			int iInput2 = Integer.parseInt(input2);

			game.setCell(iInput1, iInput2);
				
            if(game.getState() == Game.State.PLAYING){
				return ui.printBoard(game) + "<br> <h1>" + game.getPlayer() + "'s turn";
			}
			else if(game.getState() == Game.State.WIN) {
				
				return ui.printBoard(game) + "<br> <h1>" + game.getPlayer() + " has won!! :)";
			}
			else {
				return ui.printBoard(game) + "<br> <h1>No one has won!";
			}
          });
		  
		delete("/reset", (req, res) -> {
			//game = new Game();
			ui.clearBoard(game);
			return "<h1> New game </h1>" + ui.printBoard(game) + "<br> <h1>" + game.getPlayer() + "'s turn";
		});

      post("/", (req, res) -> {
          
			if(game.getState() == Game.State.PLAYING){
            return ui.printBoard(game);
			}
			else{
				return "Something completly diffrent!";
			}

          });
      
      get("/add/:numbers", (req, res) -> {
        String input1 = req.queryParams("input1");
        String input2 = req.queryParams("input2");
        int iInput1 = Integer.parseInt(input1);
        int iInput2 = Integer.parseInt(input2);
        
        return game.setCell(iInput1, iInput2);
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
