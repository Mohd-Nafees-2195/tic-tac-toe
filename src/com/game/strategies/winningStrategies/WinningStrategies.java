package com.game.strategies.winningStrategies;

import com.game.model.Board;
import com.game.model.Move;

public interface WinningStrategies {
    boolean checkWinningStrategy(Board board, Move move);
}
