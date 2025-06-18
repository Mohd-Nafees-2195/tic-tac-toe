package com.game.strategies.winningStrategies;

import com.game.model.Board;
import com.game.model.Move;
import com.game.model.Symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ColumnWinningStrategy implements WinningStrategies{
    Map<Integer, Map<Symbol,Integer>> columnHashMap=new HashMap<>();

    @Override
    public boolean checkWinningStrategy(Board board, Move move) {
        Integer column=move.getCell().getColumn();
        Symbol symbol=move.getPlayer().getSymbol();
        if(!columnHashMap.containsKey(column)){
            columnHashMap.put(column, new HashMap<>());
        }
        columnHashMap.get(column).put(symbol,columnHashMap.get(column).getOrDefault(symbol,0)+1);
        return Objects.equals(columnHashMap.get(column).get(symbol), board.getDimensions());
    }
}
