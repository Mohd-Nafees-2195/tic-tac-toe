package com.game.strategies.botPlayingStrategies;


import com.game.model.Board;
import com.game.model.Cell;

public interface BotPlayingStrategy {
   Cell selectCell(Board board);
}
