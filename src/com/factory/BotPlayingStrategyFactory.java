package com.factory;

import com.game.Enum.BotDifficultyLevel;
import com.game.strategies.botPlayingStrategies.BotPlayingStrategy;
import com.game.strategies.botPlayingStrategies.EasyBotStrategy;
import com.game.strategies.botPlayingStrategies.HardBotStrategy;
import com.game.strategies.botPlayingStrategies.MediumBotStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel==BotDifficultyLevel.HARD){
            return new HardBotStrategy();
        }else if(difficultyLevel==BotDifficultyLevel.MEDIUM){
            return new MediumBotStrategy();
        }else {
            return new EasyBotStrategy();
        }
    }
}
