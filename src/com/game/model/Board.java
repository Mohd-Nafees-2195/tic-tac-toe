package com.game.model;

import com.game.Enum.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Integer dimensions;
    private List<List<Cell>> cells;

    public Board(Integer dimensions) {
        this.dimensions = dimensions;
        this.cells=new ArrayList<>(dimensions);
        for(int i=0;i<this.dimensions;i++){
            List<Cell> cell=new ArrayList<>();
            for(int j=0;j<this.dimensions;j++){
                cell.add(new Cell(i,j, CellState.EMPTY));
            }
            cells.add(cell);
        }
    }

    public Integer getDimensions() {
        return dimensions;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void printBoard() {
            //[[],[],[],[]...]
            for(List<Cell> cells: cells){
                for(Cell cell: cells){
                    if(cell.getCellState().equals(CellState.EMPTY)){
                        System.out.print("|   |"); //|  |
                    }else{
                        System.out.print("| " + cell.getPlayer().getSymbol().getSymbol() + " |"); // | O |
                    }
                }
                System.out.println();
            }
    }
}
