package com.game.strategies.winningStrategies;


import com.game.model.Board;
import com.game.model.Cell;
import com.game.model.Move;
import com.game.model.Symbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DiagonalWinningStrategy implements WinningStrategies{

    Map<Symbol,Integer> diagonalMap=new HashMap<>();
    Map<Symbol,Integer> rDiagonalMap=new HashMap<>();
    @Override
    public boolean checkWinningStrategy(Board board, Move move) {
        Integer row=move.getCell().getRow();
        Integer column=move.getCell().getColumn();
        Symbol symbol=move.getPlayer().getSymbol();
            if(Objects.equals(row, column)){
                diagonalMap.put(symbol,diagonalMap.getOrDefault(symbol,0)+1);
                if (Objects.equals(diagonalMap.get(symbol), board.getDimensions())) return true;
            }
            if(Objects.equals(row+column, board.getDimensions()-1)){
                rDiagonalMap.put(symbol,rDiagonalMap.getOrDefault(symbol,0)+1);
                if (Objects.equals(rDiagonalMap.get(symbol), board.getDimensions())) return true;
            }
        return false;
    }

    @Override
    public void unDo(Move move, int dimension) {
        Cell cell=move.getCell();
        int row=cell.getRow();
        int col=cell.getColumn();
        Symbol symbol=move.getPlayer().getSymbol();
        if(row==col){
            diagonalMap.put(symbol,diagonalMap.get(symbol)-1);
        }
        if(row+col==dimension-1){
            rDiagonalMap.put(symbol,rDiagonalMap.get(symbol)-1);
        }
    }
}
