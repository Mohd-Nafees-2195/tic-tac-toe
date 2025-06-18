package com.game.model;

import com.game.Enum.CellState;

public class Cell {
    private Integer row;
    private Integer column;
    private Player player;
    private CellState cellState;

    public Cell(Integer row,Integer column, CellState cellState) {
        this.row = row;
        this.cellState = cellState;
        this.column = column;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
