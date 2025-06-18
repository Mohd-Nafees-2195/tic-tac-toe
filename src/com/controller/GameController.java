package com.controller;

import com.game.Enum.GameState;
import com.game.exceptions.InvalidMoveException;
import com.game.exceptions.PlayerValidationExceptions;
import com.game.model.Game;
import com.game.model.Player;
import com.game.strategies.winningStrategies.ColumnWinningStrategy;
import com.game.strategies.winningStrategies.DiagonalWinningStrategy;
import com.game.strategies.winningStrategies.WinningStrategies;
import com.game.strategies.winningStrategies.RowWinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(List<Player> players) throws PlayerValidationExceptions {
        List<WinningStrategies> strategies=List.of(new RowWinningStrategy(),new ColumnWinningStrategy(),new DiagonalWinningStrategy());
        return Game.getGame().setPlayers(players).setStrategies(strategies).build();
    }
    public GameState makeMove(Game game) {
        try {
            return game.makeMove();
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        return GameState.IN_PROGRESS;
    }
    public GameState getGameState(Game game){
        return game.getGameState();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
}
