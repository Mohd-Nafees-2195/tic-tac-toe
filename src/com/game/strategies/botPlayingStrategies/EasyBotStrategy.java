package com.game.strategies.botPlayingStrategies;

import com.game.Enum.CellState;
import com.game.model.Board;
import com.game.model.Cell;

import java.util.List;

public class EasyBotStrategy implements BotPlayingStrategy{

    @Override
    public Cell selectCell(Board board) {
       for (List<Cell> cells: board.getCells()){
           for(Cell cell:cells){
               if(cell.getCellState()== CellState.EMPTY){
                   return cell;
               }
           }
       }
       return null;
    }
}
