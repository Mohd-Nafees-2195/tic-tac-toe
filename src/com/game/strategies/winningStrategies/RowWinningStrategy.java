package com.game.strategies.winningStrategies;

import com.game.model.Board;
import com.game.model.Cell;
import com.game.model.Move;
import com.game.model.Symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RowWinningStrategy implements WinningStrategies{
    Map<Integer, Map<Symbol,Integer>> rowHashMap=new HashMap<>();

    @Override
    public boolean checkWinningStrategy(Board board,Move move) {
        Integer row=move.getCell().getRow();
        Symbol symbol=move.getPlayer().getSymbol();
        if(!rowHashMap.containsKey(row)){
            rowHashMap.put(row, new HashMap<>());
        }
        rowHashMap.get(row).put(symbol,rowHashMap.get(row).getOrDefault(symbol,0)+1);
        return Objects.equals(rowHashMap.get(row).get(symbol), board.getDimensions());
    }

    @Override
    public void unDo(Move move, int dimension) {
        Cell cell=move.getCell();
        int row=cell.getRow();
        Symbol symbol=move.getPlayer().getSymbol();
        Map<Symbol,Integer> rowMap=rowHashMap.get(row);
        rowMap.put(symbol,rowMap.get(symbol)-1);
    }
}
