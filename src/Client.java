import com.controller.GameController;
import com.game.Enum.BotDifficultyLevel;
import com.game.Enum.GameState;
import com.game.Enum.PlayerType;
import com.game.exceptions.InvalidMoveException;
import com.game.exceptions.PlayerValidationExceptions;
import com.game.model.Bot;
import com.game.model.Game;
import com.game.model.Player;
import com.game.model.Symbol;

import java.util.List;

public class Client {
    public static void main(String[] args) throws PlayerValidationExceptions, InvalidMoveException {
        Symbol symbol1=new Symbol('O');
        Player player1=new Player("Nafees",symbol1, PlayerType.HUMAN);
        Symbol symbol2=new Symbol('X');
        Player player2=new Player("Anish",symbol2, PlayerType.HUMAN);
        List<Player> players=List.of(player1,player2);
        Player player3=new Bot("Bot",new Symbol('#'), BotDifficultyLevel.EASY);

        GameController gc=new GameController();
        Game game=gc.startGame(players);

        while(gc.getGameState(game)== GameState.IN_PROGRESS){
            gc.makeMove(game);
        }
        if(gc.getGameState(game)==GameState.WINNER){
            System.out.println(gc.getWinner(game).getName()+" Wins ");
        }if(gc.getGameState(game)==GameState.DRAW){
            System.out.println("Draw, Play again");
        }
    }
}