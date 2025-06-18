package com.game.model;

import com.game.Enum.BotDifficultyLevel;
import com.game.Enum.PlayerType;
import com.game.strategies.botPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(String name, Symbol symbol,BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
        //Using factory pattern to create the object of BotPlayingStrategy
        // will do it later

    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }
}
