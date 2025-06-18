package com.game.strategies.winningStrategies;


import com.game.model.Board;
import com.game.model.Move;
import com.game.model.Symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DiagonalWinningStrategy implements WinningStrategies{

    Map<Integer, Map<Symbol,Integer>> diagonalHashMap=new HashMap<>();
    @Override
    public boolean checkWinningStrategy(Board board, Move move) {
        Integer row=move.getCell().getRow();
        Integer column=move.getCell().getColumn();
        Symbol symbol=move.getPlayer().getSymbol();
        if(diagonalHashMap.isEmpty()){
            diagonalHashMap.put(1,new HashMap<>());
            diagonalHashMap.put(2,new HashMap<>());
        }
        //if(Objects.equals(row, column) ||Objects.equals(row+column, board.getDimensions()-1)){
            if(Objects.equals(row, column)){
                diagonalHashMap.get(1).put(symbol,diagonalHashMap.get(1).getOrDefault(symbol,0)+1);
                if (Objects.equals(diagonalHashMap.get(1).get(symbol), board.getDimensions()))
                    return true;
            }
            if(Objects.equals(row+column, board.getDimensions()-1)){
                diagonalHashMap.get(2).put(symbol,diagonalHashMap.get(2).getOrDefault(symbol,0)+1);
                return Objects.equals(diagonalHashMap.get(2).get(symbol), board.getDimensions());
            }
        //}
        return false;
    }
}
