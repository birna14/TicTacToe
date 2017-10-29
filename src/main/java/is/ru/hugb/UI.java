package is.ru.hugb;
 
import java.util.Scanner;
import java.net.URLDecoder;
 
import static spark.Spark.*;
 
public class UI {
 
    public static String newGameButton() {
     String out = "<a href='/reset/'>Want to play again?</a>"; 
     return out;    
    }

 
    // prints the board of the given gam
    public static String printBoard(Game game) {
        //game.setCell(1,2);
        //game.setCell(0,0);
        String out = "<h1>";
        for (int i = 0; i < 3; i++) {
            out += "<br>";
            for (int j = 0; j < 3; j++) {
                if (game.getBoard()[i][j] == ' ') {
                    out += "&ensp;";
                } else {
                    out += game.getBoard()[i][j];
                }
                if(j != 2) out += ("   |   ");
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
 
    private static int validateInput(Scanner scan) {
        while (!scan.hasNextInt()){
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
            String input = req.queryParams("input");
            String numbers[] = input.split(",");
 
            int iInput1 = Integer.parseInt(numbers[0]);
            int iInput2 = Integer.parseInt(numbers[1]);
 
            game.setCell(iInput1, iInput2);
 
            if(game.getState() == Game.State.PLAYING) {
                return ui.printBoard(game) + "<br> <h1>" + game.getPlayer() + "'s turn";
            }
            else if(game.getState() == Game.State.WIN) {
                return ui.printBoard(game) + "<br> <h1>" + game.getPlayer() + " has won!! :)" + ui.newGameButton();
            }
            else {
                return ui.printBoard(game) + "<br> <h1>It's a draw!";
            }
        });
 
        delete("/reset", (req, res) -> {
            //game = new Game();
            ui.clearBoard(game);
            return "<h1> Play Tic Tac Toe! </h1>" + ui.printBoard(game) + "<br> <h1>" + game.getPlayer() + "'s turn";
        });
 
        get("/", (req, res) -> {
            ui.clearBoard(game);
            return "<h1> Play Tic Tac Toe! </h1>" + ui.printBoard(game) + "<br> <h1>" + game.getPlayer() + "'s turn";
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
}