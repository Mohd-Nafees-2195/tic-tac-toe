package com.game.model;

import com.factory.BotPlayingStrategyFactory;
import com.game.Enum.BotDifficultyLevel;
import com.game.Enum.CellState;
import com.game.Enum.PlayerType;
import com.game.strategies.botPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(String name, Symbol symbol,BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
        this.botPlayingStrategy=BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
        //Using factory pattern to create the object of BotPlayingStrategy
        // will do it later

    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }
    @Override
    public Cell selectCell(Board board) {
        System.out.println("It's "+this.getName()+" turn");
        return botPlayingStrategy.selectCell(board);
    }
}
