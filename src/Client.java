import com.controller.GameController;
import com.game.Enum.BotDifficultyLevel;
import com.game.Enum.GameState;
import com.game.Enum.PlayerType;
import com.game.exceptions.InvalidMoveException;
import com.game.exceptions.PlayerValidationExceptions;
import com.game.model.*;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws PlayerValidationExceptions, InvalidMoveException {
        Scanner sc=new Scanner(System.in);
        Symbol symbol1=new Symbol('O');
        Bot player1=new Bot("Bot",symbol1,BotDifficultyLevel.EASY);
        Symbol symbol2=new Symbol('X');
        Player player2=new Player("Anish",symbol2, PlayerType.HUMAN);
        List<Player> players=List.of(player1,player2);
        Player player3=new Bot("Bot",new Symbol('#'), BotDifficultyLevel.EASY);

        GameController gc=new GameController();
        Game game=gc.startGame(players);

        while(gc.getGameState(game)== GameState.IN_PROGRESS){
            Player currentPlayer=gc.getCurrentPlayer(game);
            gc.printBoard(game);
            gc.makeMove(game);
            if(gc.getGameState(game)!= GameState.IN_PROGRESS){
                gc.printBoard(game);
                break;
            }
            if(currentPlayer.getPlayerType()!=PlayerType.BOT){
                System.out.println("Do you want to unDO ? (y/n):");
                String choice=sc.next();
                if(choice.equalsIgnoreCase("y")){
                    gc.unDo(game);
                }
            }
        }
        if(gc.getGameState(game)==GameState.WINNER){
            System.out.println(gc.getWinner(game).getName()+" Wins ");
        }if(gc.getGameState(game)==GameState.DRAW){
            System.out.println("Draw, Play again");
        }
    }
}